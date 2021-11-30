function logar(){
    var objeto = {
        "email" : document.getElementById("txtemail").value,
        "senha" : document.getElementById("txtsenha").value
    }

    var cabecalho = {
        method: "POST",
        body: JSON.stringify(objeto),
        headers:{
            "Content-type":"application/json"
        }
    }

    fetch("http://localhost:8080/login", cabecalho)
        .then(res => res.json())
        .then(res => {
            localStorage.setItem("logado",JSON.stringify(res));
            //window.location="login";
            console.log(objeto)
            document.getElementById("id").innerText = res.id
            document.getElementById("nome").innerText = res.nome
            document.getElementById("senha").innerText = res.senha
            document.getElementById("email").innerText = res.email
        })
        .catch(err => {
            console.log(err);
            document.getElementById("id").innerText = "null"
            document.getElementById("nome").innerText = "null"
            document.getElementById("senha").innerText = "null"
            document.getElementById("email").innerText = "null"
        });

}
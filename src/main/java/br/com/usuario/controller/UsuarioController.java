package br.com.usuario.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import br.com.usuario.dao.*;

import br.com.usuario.beans.Usuario;
@CrossOrigin("*")
@Controller
public class UsuarioController {

	@Autowired // objeto gerenciavel, não precisa de new
	private UsuarioDAO dao;
		
	@GetMapping("/index")
	public String index(){
		return "login";
	}
	//método para adicionar usuário
	@PostMapping("/novousuario")
	public ResponseEntity<Usuario> addUsuario(@RequestBody Usuario objeto){
		try {
			dao.save(objeto);
			return ResponseEntity.ok(objeto);
		}catch(Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(403).build();
		}
	}
	
	//método para criar a rota para login
	@PostMapping("/login")
	public ResponseEntity<Usuario> findByEmailAndSenha(@RequestBody Usuario objeto){
		System.out.println(objeto);
		System.out.println("email: "+ objeto.getEmail());
		System.out.println("senha: "+ objeto.getSenha());
		Usuario resposta = dao.findByEmailAndSenha(objeto.getEmail(), objeto.getSenha());
		//System.out.println(resposta);
		if(resposta == null) {
			return ResponseEntity.status(404).build();
		}
		return ResponseEntity.ok(resposta);
	}
	
	
	
	
	
	
	
	

}
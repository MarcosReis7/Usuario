package br.com.usuario.dao;

import org.springframework.data.repository.CrudRepository;

import br.com.usuario.beans.Usuario;

public interface UsuarioDAO extends CrudRepository<Usuario, Integer>  {
	
	public Usuario findByEmailAndSenha(String email, String senha);


}
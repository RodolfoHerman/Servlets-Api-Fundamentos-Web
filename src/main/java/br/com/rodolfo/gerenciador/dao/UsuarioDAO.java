package br.com.rodolfo.gerenciador.dao;

import java.util.HashMap;
import java.util.Map;

import br.com.rodolfo.gerenciador.Usuario;

/**
 * UsuarioDAO
 */
public class UsuarioDAO {

    private final static Map<String, Usuario> USUARIOS = new HashMap<String, Usuario>();
    
    static {
		USUARIOS.put("rodolfo.herman@email.com.br", new Usuario("rodolfo.herman@email.com.br","herman"));
		USUARIOS.put("rodolfo.silva@email.com.br", new Usuario("rodolfo.silva@email.com.br","silva"));
    }
    
    public Usuario buscaPorEmailESenha(String email, String senha) {
		if (!USUARIOS.containsKey(email))
			return null;

		Usuario usuario = USUARIOS.get(email);
		if (usuario.getSenha().equals(senha))
			return usuario;
		
		return null;
	}

}
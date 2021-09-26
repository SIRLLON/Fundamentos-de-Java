package br.edu.infnet.appsirflix.model.testes;

import br.edu.infnet.appsirflix.model.domain.Usuario;

public class UsuarioTeste {

	public static void main(String[] args) {
		
		Usuario usuario = new Usuario("Sirllon", "597963125-49", "sirllon@kgc.com");
		System.out.println(usuario);
	}
}

package br.edu.infnet.appsirflix.model.testes;

import java.util.ArrayList;
import java.util.List;


import br.edu.infnet.appsirflix.model.domain.Filme;
import br.edu.infnet.appsirflix.model.domain.Midia;
import br.edu.infnet.appsirflix.model.domain.Serie;
import br.edu.infnet.appsirflix.model.domain.Transacao;
import br.edu.infnet.appsirflix.model.domain.Usuario;
import br.edu.infnet.appsirflix.model.exceptions.DuracaoZeradoException;
import br.edu.infnet.appsirflix.model.exceptions.EpisodioZeradoException;

public class TransacaoTeste {

	public static void main(String[] args) {
		
		Filme preferido = new Filme("Guerra dos Mundos", 7, 321);
		try {
			preferido.setInformacoes("filme de ficcao cientifica");
			preferido.setDuracao(120);
			preferido.setEstrangeira(true);
		} catch (DuracaoZeradoException e) {
			System.out.println(e.getMessage());
		}
		
		Serie legal = new Serie("The hundred", 3, 121);
		try {
			legal.setEstrangeira(true);
			legal.setProdutora("Universal");
			legal.setEpisodio(50);
		} catch (EpisodioZeradoException e) {
			System.out.println(e.getMessage());
		}

		Serie maneira = new Serie("Alladin", 12, 987);
		try {
			maneira.setEstrangeira(true);
			maneira.setProdutora("Disney");
			maneira.setEpisodio(35);
		} catch (EpisodioZeradoException e) {
			System.out.println(e.getMessage());
		}

		List<Midia> listaMidia = new ArrayList<Midia>();		
		listaMidia.add(preferido);
		
		List<Midia> listaMaratonar = new ArrayList<Midia>();
		listaMidia.add(legal);
		listaMaratonar.add(maneira);

		Usuario usuario = new Usuario("Camila", "485785965-85", "cami97@abc.com");
		
		Transacao stremming = new Transacao();
		stremming.setDescricao("Lanche da noite");
		stremming.setWeb(true);
		stremming.setUsuario(usuario);
		stremming.setMidias(listaMidia);
		System.out.println(stremming);

		Transacao assistir = new Transacao();
		assistir.setDescricao("Balada");
		assistir.setWeb(false);
		assistir.setUsuario(usuario);
		assistir.setMidias(listaMaratonar);
		System.out.println(assistir);
	}
}
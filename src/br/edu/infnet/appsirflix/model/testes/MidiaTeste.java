package br.edu.infnet.appsirflix.model.testes;

import br.edu.infnet.appsirflix.model.domain.Filme;
import br.edu.infnet.appsirflix.model.domain.Serie;
import br.edu.infnet.appsirflix.model.exceptions.DuracaoZeradoException;
import br.edu.infnet.appsirflix.model.exceptions.EpisodioZeradoException;

public class MidiaTeste {

	public static void main(String[] args) {
		
		try {
			Serie romance = new Serie("Coisa mais linda", 15, 856);		
			romance.setEstrangeira(false);
			romance.setProdutora("Globo");
			romance.setEpisodio(20);
			System.out.println(romance);
		} catch (EpisodioZeradoException e) {
			System.out.println(e.getMessage());
		}
		
		try {
			Serie aventura = new Serie("Avangers", 90, 453);		
			aventura.setEstrangeira(true);
			aventura.setProdutora("Marvel");
			aventura.setEpisodio(90);
			System.out.println(aventura);
			System.out.println("Valor de venda: " + aventura.calcularValorMidia());
		} catch (EpisodioZeradoException e) {
			System.out.println(e.getMessage());
		}		
		
		try {
			Filme melhor = new Filme("Guerra Infinita", 6, 498);
			melhor.setInformacoes("filme de ficcao cientifica e aventura de herois");
			melhor.setDuracao(120);
			melhor.setEstrangeira(true);
			System.out.println(melhor);
		} catch (DuracaoZeradoException e) {
			System.out.println(e.getMessage());
		}
		
		try {
			Filme best = new Filme("Cidade de Deus", 9, 908);
			best.setInformacoes("filme baseado em fatos reais/drama");
			best.setDuracao(120);
			best.setEstrangeira(true);
			System.out.println(best);
			System.out.println(best.calcularValorMidia());
		} catch (DuracaoZeradoException e) {
			System.out.println(e.getMessage());
		}
		
		//TODO instanciar uma sobremesa
	}
}
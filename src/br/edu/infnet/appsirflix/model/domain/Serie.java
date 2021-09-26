package br.edu.infnet.appsirflix.model.domain;

import br.edu.infnet.appsirflix.model.exceptions.EpisodioZeradoException;

public class Serie extends Midia {

	private boolean legendado;
	private float episodios;
	private String produtora; 
	
	public Serie(String nome, float valor, int codigo) {
		super(nome, valor, codigo);
	}

	@Override
	public float calcularValorMidia() {

		return getValor() + (legendado ? 10 : 5) + 0.1f * episodios;
	}
	
	@Override
	public String toString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toString());
		sb.append(";");
		sb.append(legendado ? "Legendado" : "Nacional");
		sb.append(";");
		sb.append(episodios);
		sb.append(";");
		sb.append(produtora);
		sb.append(";");
		sb.append(calcularValorMidia());
		
		return sb.toString();
	}

	public boolean isEstrangeira() {
		return legendado;
	}

	public void setEstrangeira(boolean estrangeira) {
		this.legendado = estrangeira;
	}

	public float getEpisodio() {
		return episodios;
	}

	public void setEpisodio(float episodios) throws EpisodioZeradoException {
		
		if(episodios <= 0) {
			throw new EpisodioZeradoException("Não existem episodios a serem calculadas!!!");
		}
		
		this.episodios = episodios;
	}

	public String getProdutora() {
		return produtora;
	}

	public void setProdutora(String produtora) {
		this.produtora = produtora;
	}
}
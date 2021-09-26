package br.edu.infnet.appsirflix.model.domain;

import br.edu.infnet.appsirflix.model.exceptions.DuracaoZeradoException;

public class Filme extends Midia {
	
	private float duracao;
	private boolean estrangeira;
	private String informacoes;

	public Filme(String nome, float valor, int codigo) {
		super(nome, valor, codigo);
	}

	@Override
	public float calcularValorMidia() {
		return getValor() + (estrangeira ? 8 : 4) + 0.2f * duracao;
	}

	@Override
	public String toString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toString());
		sb.append(";");
		sb.append(duracao);
		sb.append(";");
		sb.append(estrangeira ? "Legendado" : "Nacional");
		sb.append(";");
		sb.append(informacoes);
		sb.append(";");
		sb.append(calcularValorMidia());
		
		return sb.toString();
	}

	public float getDuracao() {
		return duracao;
	}

	public void setDuracao(float duracao) throws DuracaoZeradoException {
		
		if(duracao <= 0) {
			throw new DuracaoZeradoException("Não é possivel calcular filme sem duracao!!!");
		}
		
		this.duracao = duracao;
	}

	public boolean isEstrangeira() {
		return estrangeira;
	}

	public void setEstrangeira(boolean estrangeira) {
		this.estrangeira = estrangeira;
	}

	public String getInformacoes() {
		return informacoes;
	}

	public void setInformacoes(String informacoes) {
		this.informacoes = informacoes;
	}

}

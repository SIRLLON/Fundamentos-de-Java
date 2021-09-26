package br.edu.infnet.appsirflix.model.domain;

public abstract class Midia {

	private String nome;
	private float valor;
	private int codigo;

	public Midia(String nome, float valor, int codigo) {
		this.nome = nome;
		this.valor = valor;
		this.codigo = codigo;
	}
	
	public abstract float calcularValorMidia();

	@Override
	public String toString() {

		StringBuilder sb = new StringBuilder();
		sb.append(nome);
		sb.append(";");
		sb.append(valor);
		sb.append(";");
		sb.append(codigo);
		
		return sb.toString();
	}

	public String getNome() {
		return nome;
	}
	public float getValor() {
		return valor;
	}
	public int getCodigo() {
		return codigo;
	}
}
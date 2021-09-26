package br.edu.infnet.appsirflix.model.domain;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class Transacao {

	private List<Midia> midias;
	private String descricao;
	private Usuario usuario;
	private LocalDateTime data;
	private boolean web;
	
	

	public Transacao() {
		data = LocalDateTime.now();
	}
	
	@Override
	public String toString() {
		
		DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
		
		StringBuilder sb = new StringBuilder();
		sb.append(descricao);
		sb.append(";");
		sb.append(data.format(formato));
		sb.append(";");
		sb.append(web ? "web" : "loja");
		sb.append(";");
		sb.append(usuario.toString());
		sb.append(";");
		if(midias != null) {
			sb.append(midias.size());
		}
		
		return sb.toString();
	}
	
	public boolean isWeb() {
		return web;
	}
	public void setWeb(boolean web) {
		this.web = web;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public List<Midia> getMidias() {
		return midias;
	}

	public void setMidias(List<Midia> midias) {
		this.midias = midias;
	}
}
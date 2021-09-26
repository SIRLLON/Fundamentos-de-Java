package br.edu.infnet.appsirflix.model.testes;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import br.edu.infnet.appsirflix.model.domain.Filme;
import br.edu.infnet.appsirflix.model.domain.Transacao;
import br.edu.infnet.appsirflix.model.domain.Midia;
import br.edu.infnet.appsirflix.model.domain.Serie;
import br.edu.infnet.appsirflix.model.domain.Usuario;
import br.edu.infnet.appsirflix.model.exceptions.DuracaoZeradoException;
import br.edu.infnet.appsirflix.model.exceptions.EpisodioZeradoException;

public class ArquivoTeste {

	public static void main(String[] args) {
		
		String dir = "C:/Users/Pichau/Documents/Estudos/INFNET/FJ/";
		String arq = "transacoes.txt";
		
		try {
			
			try {
				FileReader file = new FileReader(dir+arq);				
				BufferedReader leitura = new BufferedReader(file);
				
				FileWriter fileW = new FileWriter(dir+"comprovante_"+arq);
				BufferedWriter escrita = new BufferedWriter(fileW);
				
				String linha = null;
				String[] campos;
				
				linha = leitura.readLine();
				
				List<Midia> midias = new ArrayList<Midia>();
				Transacao transacao = new Transacao();

				while(linha != null) {
					
					campos = linha.split(";");
					
					if(campos.length == 5) {
						Usuario usuario = new Usuario(
								campos[2], 
								campos[3], 
								campos[4]
							);

						
						transacao.setDescricao(campos[0]);
						transacao.setWeb(Boolean.valueOf(campos[1]));
						transacao.setUsuario(usuario);
						
						
					} else {
						switch (campos[0]) {
						case "S":
							Serie serie = new Serie(
									campos[1],
									Float.valueOf(campos[2]), 
									Integer.valueOf(campos[3])
								);
							try {
								serie.setEstrangeira(Boolean.valueOf(campos[4]));
								serie.setEpisodio(Float.valueOf(campos[5]));
								serie.setProdutora(campos[6]);
								
								midias.add(serie);
							} catch (NumberFormatException | EpisodioZeradoException e) {
								System.out.println(e.getMessage());
							}

							break;

						case "F":
							Filme filme = new Filme(
									campos[1],
									Float.valueOf(campos[2]), 
									Integer.valueOf(campos[3])
								);
							try {
								filme.setDuracao(Float.valueOf(campos[4]));
								filme.setEstrangeira(Boolean.valueOf(campos[5]));
								filme.setInformacoes(campos[6]);
								
								midias.add(filme);
							} catch (NumberFormatException | DuracaoZeradoException e) {
								System.out.println(e.getMessage());
							}

							break;													
						default:
							System.out.println("Venda sem midia!!!");
							break;
						}
					}					

					linha = leitura.readLine();
				}
				transacao.setMidias(midias);
				
				for(Midia mid : transacao.getMidias()) {
					escrita.write(
							transacao.getDescricao()+";"+
							transacao.getUsuario().getNome()+";"+
									mid.getNome()+";"+
							mid.calcularValorMidia()+"\r\n");
				}
					
				
//				escrita.write(qtde+";"+somaSalarial+"\r\n");

				leitura.close();
				file.close();
				
				escrita.close();
				fileW.close();
			} catch (IOException e) {
				System.out.println(e.getMessage());
			}
			
		} finally {
			System.out.println("Transação efetuada!");
		}
	}
}

package br.com.alura.argentum.ws;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import br.com.alura.argentum.modelo.Negociacao;
import br.com.alura.argentum.reader.LeitorXml;

public class ClienteWebservice {

	public static final String URL_WEBSERVICE = "http://argentumws.caelum.com.br/negociacoes";
	
	public List<Negociacao> getNegociacoes(){
		HttpURLConnection connection = null;
		try {
			URL url = new URL(URL_WEBSERVICE);
			connection = (HttpURLConnection) url.openConnection();
			
			InputStream content = connection.getInputStream();
			
			return new LeitorXml().carrega(content);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			connection.disconnect();
		}
		
		return null;
	}
	
	public static void main(String[] args) {
		ClienteWebservice cliente = new ClienteWebservice();
		
		List<Negociacao> negociacoes = cliente.getNegociacoes();
		
		for (Negociacao negociacao : negociacoes) {
			System.out.println("preco: " + negociacao.getPreco());
		}
	}
	
}

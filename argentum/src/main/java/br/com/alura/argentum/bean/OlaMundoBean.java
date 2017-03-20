package br.com.alura.argentum.bean;

import javax.faces.bean.ManagedBean;

@ManagedBean
public class OlaMundoBean {
	private String mensagem = "Essa mensagem veio direto do meu Bean";
	private String nome;
	
	public String getMensagem() {
		return mensagem;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void botaoClicado(){
		System.out.println("O bot�o foi clicado! seu nome �: " + nome);
	}
}

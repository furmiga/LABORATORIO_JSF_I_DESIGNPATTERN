package br.com.alura.argentum.reader;

import java.io.InputStream;
import java.time.LocalDateTime;
import java.util.List;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

import br.com.alura.argentum.modelo.Negociacao;
import br.com.alura.argentum.xstream.LocalDateTimeConverter;

public class LeitorXml {
	
	public List<Negociacao> carrega(InputStream inputStream){
		XStream stream = new XStream(new DomDriver());
		stream.alias("negociacao", Negociacao.class);
		stream.registerLocalConverter(Negociacao.class, "data", new LocalDateTimeConverter());
		
		return (List<Negociacao>)stream.fromXML(inputStream);
	}
	
	public static void main(String[] args) {
		
		Negociacao negociacao = new Negociacao(10.0, 2, LocalDateTime.now());
		
		XStream xstream = new XStream(new DomDriver());
		xstream.registerLocalConverter(Negociacao.class, "data" , new LocalDateTimeConverter());
		String xml = xstream.toXML(negociacao);
		
		System.out.println(xml);
		
	}
}

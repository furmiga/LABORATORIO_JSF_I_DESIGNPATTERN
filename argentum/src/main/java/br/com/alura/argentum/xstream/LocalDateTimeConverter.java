package br.com.alura.argentum.xstream;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;

import com.thoughtworks.xstream.converters.Converter;
import com.thoughtworks.xstream.converters.MarshallingContext;
import com.thoughtworks.xstream.converters.UnmarshallingContext;
import com.thoughtworks.xstream.io.HierarchicalStreamReader;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;

public class LocalDateTimeConverter implements Converter {

	@Override
	public boolean canConvert(Class tipoClasse) {
		//verifica se a classe que esta sendo passada pode ser convertida
		return tipoClasse.isAssignableFrom(LocalDateTime.class);
	}

	//responsavel por serializar
	@Override
	public void marshal(Object object, HierarchicalStreamWriter writer, MarshallingContext context) {
		LocalDateTime data = (LocalDateTime)object;
		//pegando o fusohorario do nosso sistema
		ZonedDateTime dataComZona = data.atZone(ZoneOffset.systemDefault());
		long milis = dataComZona.toInstant().toEpochMilli();
		
		writer.startNode("time");
			writer.setValue(String.valueOf(milis));
		writer.endNode();
		
		writer.startNode("timezone");
			writer.setValue(dataComZona.getZone().toString());
		writer.endNode();
	}

	//transforma xml em object
	@Override
	public Object unmarshal(HierarchicalStreamReader reader, UnmarshallingContext arg1) {
		
		reader.moveDown();
		String milis = reader.getValue();
		reader.moveUp();
		
		reader.moveDown();
		String timeZone = reader.getValue();
		reader.moveUp();
		
		long tempoEmMillis = Long.parseLong(milis);
		Instant tempo = Instant.ofEpochMilli(tempoEmMillis);
		
		ZoneId zone = ZoneId.of(timeZone);
		ZonedDateTime dataComZona = ZonedDateTime.ofInstant(tempo, zone);
		
		LocalDateTime data = dataComZona.toLocalDateTime();
		
		return data;
	}

}

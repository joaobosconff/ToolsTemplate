package jb.estudo.ferramentas.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.stereotype.Component;


@Component
public class RabbitMQConnection {
	
	public static final String NOME_EXCHANGE = "amq.direct";
	
	
	private Queue fila(String nomeFila) {
		return new Queue(nomeFila,true,true,false);
	}
	
	private DirectExchange trocaDireta() {
		return new DirectExchange(NOME_EXCHANGE);
		
	}
	

}

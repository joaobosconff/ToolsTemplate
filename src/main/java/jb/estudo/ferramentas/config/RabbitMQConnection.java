package jb.estudo.ferramentas.config;

import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;


@Component
public class RabbitMQConnection {
	
	public static final String NOME_EXCHANGE = "amq.direct";
	public static final String FILA_ESTOQUE = "ESTOQUE";
	public static final String FILA_PRECO = "PRECO";
	
	private AmqpAdmin amqpAdmin;
	
	public RabbitMQConnection(AmqpAdmin amqpAdmin) {
		this.amqpAdmin = amqpAdmin;
	}
	
	
	private Queue fila(String nomeFila) {
		return new Queue(nomeFila,true,true,false);
	}
	
	private DirectExchange trocaDireta() {
		return new DirectExchange(NOME_EXCHANGE);
		
	}
	
	private Binding relacionamento(Queue fila, DirectExchange troca) {
		return new Binding(fila.getName(),Binding.DestinationType.QUEUE,troca.getName(),fila.getName(),null);
	}
	
	@PostConstruct
	private void adiciona() {
		Queue filaEstoque = this.fila(FILA_ESTOQUE);
		Queue filaPreco = this.fila(FILA_PRECO);
		
		DirectExchange troca = this.trocaDireta();
		
		Binding ligacaoEstoque = this.relacionamento(filaEstoque, troca);
		Binding ligacaoPreco = this.relacionamento(filaPreco, troca);
		
		this.amqpAdmin.declareQueue(filaEstoque);
		this.amqpAdmin.declareQueue(filaPreco);
		
		this.amqpAdmin.declareExchange(troca);
		
		this.amqpAdmin.declareBinding(ligacaoPreco);
		this.amqpAdmin.declareBinding(ligacaoEstoque);
	}

}

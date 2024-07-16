package br.com.mcoder.pedidos.notificacao.listener;


import br.com.mcoder.pedidos.notificacao.entity.Pedido;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class PedidoListener {

    private final Logger logger = LoggerFactory.getLogger(PedidoListener.class);

    @RabbitListener(queues = "pedidos.v1.pedido-criado.gerar-notificacao")
    public void enviarNotificacao(Pedido pedido){
        logger.info("Notificacao gerada: {}", pedido.toString());
    }
}

package br.com.mcoder.pedidos.notificacao.listener;


import br.com.mcoder.pedidos.notificacao.entity.Pedido;
import br.com.mcoder.pedidos.notificacao.service.EmailService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class PedidoListener {

    private final Logger logger = LoggerFactory.getLogger(PedidoListener.class);

    private final EmailService emailService;

    public PedidoListener(EmailService emailService){
        this.emailService = emailService;
    }

    @RabbitListener(queues = "pedidos.v1.pedido-criado.gerar-notificacao")
    public void enviarNotificacao(Pedido pedido){

        logger.info("TENTANDO CONSUMIR A MENSAGEM");
        if (pedido.getValorTotal() > 2000){
            throw new RuntimeException("VALOR MUITO ALTO");
        }

        emailService.enviarEmail(pedido);
        logger.info("Notificacao gerada: {}", pedido.toString());
    }
}

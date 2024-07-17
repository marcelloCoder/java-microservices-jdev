package br.com.mcoder.pedidos.notificacao.service;

import br.com.mcoder.pedidos.notificacao.entity.Pedido;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {
    private final JavaMailSender mailSender;

    public EmailService(JavaMailSender mailSender){
        this.mailSender = mailSender;
    }

    public void enviarEmail(Pedido pedido){
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();

        simpleMailMessage.setFrom("pedidos.api@companny.com");
        simpleMailMessage.setTo(pedido.getEmailNotificacao());
        simpleMailMessage.setSubject("Pedido de Compra");
        simpleMailMessage.setText(this.gerarMessagem(pedido));
        mailSender.send(simpleMailMessage);

    }

    private String gerarMessagem(Pedido pedido) {

        String pedidoId = pedido.getId().toString();
        String cliente = pedido.getCliente();
        String valor = String.valueOf(pedido.getValorTotal());
        String status = pedido.getStatus().name();


        return String.format("Olá %s seu pedido de numero %s no valor %s , foi realizado com sucesso. \n Status: %s",  cliente, pedidoId, valor, status);
    }

}

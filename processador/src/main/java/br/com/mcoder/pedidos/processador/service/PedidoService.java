package br.com.mcoder.pedidos.processador.service;

import br.com.mcoder.pedidos.processador.entity.ItemPedido;
import br.com.mcoder.pedidos.processador.entity.Pedido;
import br.com.mcoder.pedidos.processador.repository.PedidoRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PedidoService {

    private final Logger logger = LoggerFactory.getLogger(PedidoService.class);
    private final PedidoRepository pedidoRepository;
    private final ProdutoService produtoService;
    private final ItemPedidoService itemPedidoService;

    public PedidoService(PedidoRepository pedidoRepository, ProdutoService produtoService, ItemPedidoService itemPedidoService) {
        this.pedidoRepository = pedidoRepository;
        this.produtoService = produtoService;
        this.itemPedidoService = itemPedidoService;
    }


    public void save(Pedido pedido){

        // salvamos os produtos
        produtoService.save(pedido.getItens());
        // salvamos itens do pedido
        List<ItemPedido> itemPedidos = itemPedidoService.save(pedido.getItens());

        // salvamos pedidos
        pedidoRepository.save(pedido);

        //atualiza o pedido definindo o pedido ao qual ele faz parte
        itemPedidoService.updatedItemPedido(itemPedidos, pedido);

        logger.info("Pedido salvo: {}", pedido.toString());
    }

}

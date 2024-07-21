package br.com.mcoder.pedidos.processador.service;

import br.com.mcoder.pedidos.processador.entity.ItemPedido;
import br.com.mcoder.pedidos.processador.entity.Pedido;
import br.com.mcoder.pedidos.processador.repository.ItemPedidoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemPedidoService {

    private final ItemPedidoRepository itemPedidoRepository;

    public ItemPedidoService(ItemPedidoRepository itemPedidoRepository) {
        this.itemPedidoRepository = itemPedidoRepository;
    }

    public List<ItemPedido> save(List<ItemPedido> itens) {

        return itemPedidoRepository.saveAll(itens);
    }

    public void save(ItemPedido itemPedido){
        itemPedidoRepository.save(itemPedido);
    }

    public void updatedItemPedido(List<ItemPedido> itemPedidos, Pedido pedido) {
        itemPedidos.forEach(item ->{
            item.setPedido(pedido); // informando ao item o seu pedido
            this.save(item);
        });
    }
}

package com.spring_api_rest_full.spring_boot_web_rest_full.service;


import com.spring_api_rest_full.spring_boot_web_rest_full.entity.Pedido;
import com.spring_api_rest_full.spring_boot_web_rest_full.entity.Produto;
import com.spring_api_rest_full.spring_boot_web_rest_full.repository.PedidoRepository;
import com.spring_api_rest_full.spring_boot_web_rest_full.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class PedidoService {

    @Autowired
    private PedidoRepository repository;

    @Autowired
    private ProdutoRepository produtoRepository;

    public Pedido save(Pedido pedido){
        Set<Produto> produtos = new HashSet<>();

        pedido.setDataPedido(LocalDateTime.now());
        pedido.getProdutos().forEach(produto -> {
            produtos.add(produtoRepository.getById(produto.getId()));
        });
        pedido.setProdutos(produtos);

        return repository.save(pedido);
    }
    public  Pedido findById(long id){
        return repository.findById(id).orElse(null);
    }

    public List<Pedido> findAll(){
        return repository.findAll();
    }

}

package com.spring_api_rest_full.spring_boot_web_rest_full.controller;


import com.spring_api_rest_full.spring_boot_web_rest_full.entity.Pedido;
import com.spring_api_rest_full.spring_boot_web_rest_full.service.PedidoService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pedido")
public class PedidoController {

    @Autowired
    private PedidoService pedidoService;

    @PostMapping(value = "/save")
    public ResponseEntity<Pedido> salvarProduto(@RequestBody Pedido produto){
        produto = pedidoService.save(produto);
        return ResponseEntity.ok().body(produto);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Pedido> buscaProduto(@PathVariable long id){
        Pedido pedido = pedidoService.findById(id);
        return ResponseEntity.ok().body(pedido);
    }

    @GetMapping(value = "/busca-todos")
    public ResponseEntity<List<Pedido>> buscaTodosProdutos(){
        List<Pedido> pedidos = pedidoService.findAll();
        return ResponseEntity.ok().body(pedidos);
    }




}

package com.spring_api_rest_full.spring_boot_web_rest_full.controller;

import com.spring_api_rest_full.spring_boot_web_rest_full.entity.Produto;
import com.spring_api_rest_full.spring_boot_web_rest_full.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/produto")
public class ProdutoController {

    @Autowired
    private ProdutoService service;

    @PostMapping(value = "/save")
    public ResponseEntity<Produto> salvaProduto(@RequestBody Produto produto) throws Exception {

        produto = service.save(produto);

        return ResponseEntity.ok().body(produto);

    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Produto> buscaProduto(@PathVariable Long id) {

        Produto produto = service.findById(id);

        return ResponseEntity.ok().body(produto);

    }

    @GetMapping(value = "/busca-todos")
    public ResponseEntity<List<Produto>> buscaTodosProdutos() {

        List<Produto> produtos = service.findAll();

        return ResponseEntity.ok().body(produtos);

    }

}

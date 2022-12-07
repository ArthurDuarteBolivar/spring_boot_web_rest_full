package com.spring_api_rest_full.spring_boot_web_rest_full.service;

import com.spring_api_rest_full.spring_boot_web_rest_full.entity.Produto;
import com.spring_api_rest_full.spring_boot_web_rest_full.exception.ProductNullException;
import com.spring_api_rest_full.spring_boot_web_rest_full.exception.ProductPriceException;
import com.spring_api_rest_full.spring_boot_web_rest_full.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoService {
    @Autowired
    private ProdutoRepository repository;

    public Produto save(Produto produto) throws Exception {
        if (produto.getNome() == null || produto.getPreco() == null)
            throw new ProductNullException();
        if (produto.getPreco() < 0)
            throw new ProductPriceException();
        return repository.save(produto);
    }

    public Produto findById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public List<Produto> findAll() {
        return repository.findAll();
    }

}

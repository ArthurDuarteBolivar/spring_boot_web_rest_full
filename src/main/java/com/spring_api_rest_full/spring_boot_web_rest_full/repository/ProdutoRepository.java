package com.spring_api_rest_full.spring_boot_web_rest_full.repository;

import com.spring_api_rest_full.spring_boot_web_rest_full.entity.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {

}
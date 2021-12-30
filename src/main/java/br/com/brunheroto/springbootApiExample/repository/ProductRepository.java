package br.com.brunheroto.springbootApiExample.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.*;

import br.com.brunheroto.springbootApiExample.entity.Product;

public interface ProductRepository extends JpaRepository<Product, String>{

    Optional<Product> findBySku(String Sku);
    Optional<Product> deleteBySku(String sku);

}

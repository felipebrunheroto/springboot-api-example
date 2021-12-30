package br.com.brunheroto.springbootApiExample.repository;

import org.springframework.data.jpa.repository.*;

import br.com.brunheroto.springbootApiExample.entity.Warehouse;

public interface WarehouseRepository extends JpaRepository<Warehouse, String>{

}

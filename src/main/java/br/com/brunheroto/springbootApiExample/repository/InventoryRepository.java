package br.com.brunheroto.springbootApiExample.repository;

import org.springframework.data.jpa.repository.*;

import br.com.brunheroto.springbootApiExample.entity.Inventory;

public interface InventoryRepository extends JpaRepository<Inventory, String>{

}

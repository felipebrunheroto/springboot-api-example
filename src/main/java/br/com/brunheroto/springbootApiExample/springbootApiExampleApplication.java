package br.com.brunheroto.springbootApiExample;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import br.com.brunheroto.springbootApiExample.entity.Inventory;
import br.com.brunheroto.springbootApiExample.entity.Product;
import br.com.brunheroto.springbootApiExample.entity.Warehouse;
import br.com.brunheroto.springbootApiExample.repository.InventoryRepository;
import br.com.brunheroto.springbootApiExample.repository.ProductRepository;
import br.com.brunheroto.springbootApiExample.repository.WarehouseRepository;

@SpringBootApplication(scanBasePackageClasses = springbootApiExampleApplication.class)
public class springbootApiExampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(springbootApiExampleApplication.class, args);
    }

    @Bean
    public CommandLineRunner addWarehouses( ProductRepository productRepository,
                                            InventoryRepository inventoryRepository, WarehouseRepository warehouseRepository ) {
        return (args) -> {

            /*
             * Inclusão de primeiro produto apenas para facilitar a visualização
             */

            Warehouse whsp = new Warehouse("SP", 12, "ECOMMERCE");
            Warehouse whmoema = new Warehouse("MOEMA", 3, "PHYSICAL_STORE");

            List<Warehouse> warehouses = new ArrayList<Warehouse>();
            warehouses.add(whsp);
            warehouses.add(whmoema);
            Inventory inventory = new Inventory(15, warehouses);

            Product product = new Product(  "43264",
                                            "L'Oréal Professionnel Expert Absolut Repair Cortex Lipidium - Máscara de Reconstrução 500g",
                                            inventory,
                                            true);

            productRepository.save(product);

        };
    }

}

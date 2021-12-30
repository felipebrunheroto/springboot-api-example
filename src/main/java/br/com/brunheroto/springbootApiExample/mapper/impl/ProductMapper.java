package br.com.brunheroto.springbootApiExample.mapper.impl;

import br.com.brunheroto.springbootApiExample.dto.InventoryDto;
import br.com.brunheroto.springbootApiExample.dto.ProductDto;
import br.com.brunheroto.springbootApiExample.entity.Inventory;
import br.com.brunheroto.springbootApiExample.entity.Product;
import br.com.brunheroto.springbootApiExample.entity.Warehouse;
import br.com.brunheroto.springbootApiExample.mapper.AbstractMapper;

public class ProductMapper implements AbstractMapper<Product, ProductDto>{

    public ProductMapper() {
        super();
    }

    @Override
    public ProductDto fromEntityToDto(Product entity) {

        InventoryDto inventoryDto = new InventoryDto();
        inventoryDto.setWarehouses(entity.getInventory().getWarehouses());
        long _quantity = entity.getInventory().getWarehouses()
                .stream().mapToLong(Warehouse::getQuantity).sum();
        inventoryDto.setQuantity(_quantity);

        boolean _isMarkable = _quantity>0l;

        return new ProductDto(entity.getSku(), entity.getName(), inventoryDto, _isMarkable);
    }

    @Override
    public Product fromDtoToEntity(ProductDto dto) {

        Inventory inventory = new Inventory();
        inventory.setWarehouses(dto.getInventory().getWarehouses());
        inventory.setQuantity(dto.getInventory().getQuantity());

        return new Product(dto.getSku(), dto.getName(), inventory, dto.isMarketable());
    }

}

# Backend, Java, Spring, RESTful

### Produto:

```json
{
    "sku": 123,
    "name": "Produto 123",
    "inventory": {
        "quantity": 15,
        "warehouses": [
            {
                "locality": "Brasil",
                "quantity": 12,
                "type": "ECOMMERCE"
            },
            {
                "locality": "EUA",
                "quantity": 3,
                "type": "PHYSICAL_STORE"
            }
        ]
    },
    "isMarketable": true
}
```

### Endpoints:

- [x] Criação de produto (não preencher **isMarketable** e **inventory.quantity**)

- [x] Edição de produto por **sku**

- [x] Recuperação de produto por **sku**

- [x] Deleção de produto por **sku**


### Requisitos

- [x] Toda vez que um produto for recuperado por **sku** deverá ser calculado a propriedade: **inventory.quantity**

        A propriedade inventory.quantity é a soma da quantity dos warehouses

- [ ] Toda vez que um produto for recuperado por **sku** deverá ser calculado a propriedade: **isMarketable**

        Um produto é marketable sempre que seu inventory.quantity for maior que 0

- [ ] Caso um produto já existente em memória tente ser criado com o mesmo **sku** uma exceção deverá ser lançada

        Dois produtos são considerados iguais se os seus skus forem iguais


- [ ] Ao atualizar um produto, o antigo deve ser sobrescrito com o que esta sendo enviado na requisição

        A requisição deve receber o sku e atualizar com o produto que tbm esta vindo na requisição

package dev.wocampo.soap.server.helpers;

import dev.wocampo.soap.server.entities.ProductEntity;
import dev.wocampo.soap.server.webservice.Product;

/**
 * Clase helper para mapear requests y entidades.
 *
 * @author Walter Ocampo
 */
public final class ProductHelper {

    private ProductHelper() {
    }

    /**
     * Función para convertir un request a una entidad de tipo producto.
     *
     * @param product Request de producto vía SOAP
     * @return Entidad de Producto
     */
    public static ProductEntity convertToEntity(Product product) {
        ProductEntity productEntity = new ProductEntity();
        productEntity.setName(product.getName());
        productEntity.setPrice(product.getPrice());
        productEntity.setDescription(product.getDescription());
        return productEntity;
    }

    /**
     * Función para convertir una entidad de tipo producto a una response.
     *
     * @param productEntity Entidad de Producto
     * @return Response de producto vía SOAP
     */
    public static Product convertToResponse(ProductEntity productEntity) {
        Product product = new Product();
        product.setProductId(productEntity.getId());
        product.setName(productEntity.getName());
        product.setPrice(productEntity.getPrice());
        product.setDescription(productEntity.getDescription());
        return product;
    }

}

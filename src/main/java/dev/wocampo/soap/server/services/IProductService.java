package dev.wocampo.soap.server.services;

import java.util.List;

import dev.wocampo.soap.server.entities.ProductEntity;

/**
 * Clase de servicio para gestionar productos.
 *
 * @author Walter Ocampo
 */
public interface IProductService {

    /**
     * Método para obtener un listado de productos.
     *
     * @return Lista de productos
     */
    List<ProductEntity> getAll();

    /**
     * Método para obtener un producto en específico.
     *
     * @param id Identificador del producto
     * @return Producto encontrado
     */
    ProductEntity getById(Integer id);

    /**
     * Método para crear un nuecto producto.
     *
     * @param product Producto mapeado listo para ser válidado y registrado
     * @return Producto creado
     */
    ProductEntity save(ProductEntity product);

    /**
     * Método para actualizar un producto.
     *
     * @param product Producto mapeado listo para ser validado y actualizado
     * @param id      Identificador del producto
     * @return Producto actualizado
     */
    ProductEntity update(ProductEntity product, Integer id);

    /**
     * Método para eliminar un producto en específico.
     *
     * @param id Identificador del producto
     */
    void delete(Integer id);

}

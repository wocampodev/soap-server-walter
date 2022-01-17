package dev.wocampo.soap.server.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import dev.wocampo.soap.server.entities.ProductEntity;

/**
 * Interfaz de repositorio para gestionar productos.
 *
 * @author Walter Ocampo
 */
@Repository
public interface IProductRepository extends JpaRepository<ProductEntity, Integer> {

    @Query(value = "CALL GET_ALL_PRODUCTS();", nativeQuery = true)
    List<ProductEntity> callGetAllProducts();

    @Query(value = "CALL GET_PRODUCT_BY_ID(:product_id);", nativeQuery = true)
    Optional<ProductEntity> callGetProductById(@Param("product_id") Integer product_id);

    @Query(value = "CALL SAVE_PRODUCT(:name, :price, :description);", nativeQuery = true)
    ProductEntity callSaveProduct(@Param("name") String name, @Param("price") Integer price,
            @Param("description") String description);

    @Query(value = "CALL UPDATE_PRODUCT(:product_id, :name, :price, :description);", nativeQuery = true)
    ProductEntity callUpdateProduct(@Param("product_id") Integer product_id, @Param("name") String name,
            @Param("price") Integer price,
            @Param("description") String description);

    @Query(value = "CALL DELETE_PRODUCT(:product_id);", nativeQuery = true)
    int callDeleteProduct(@Param("product_id") Integer product_id);

}

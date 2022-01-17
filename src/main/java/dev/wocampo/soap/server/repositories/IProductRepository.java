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

    // @Query(value = "CALL firstProcedure(:page_id);", nativeQuery = true)
    // void deletePageCatalogById(@Param("page_id") Long page_id);
    @Query(value = "CALL GET_ALL_PRODUCTS();", nativeQuery = true)
    List<ProductEntity> callGetAllProducts();

    @Query(value = "CALL GET_PRODUCT_BY_ID(:product_id);", nativeQuery = true)
    Optional<ProductEntity> callGetProductById(@Param("product_id") Integer product_id);

}

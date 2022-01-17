package dev.wocampo.soap.server.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedStoredProcedureQueries;
import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureParameter;
import javax.persistence.Table;

@Entity
@Table(name = "products")
@NamedStoredProcedureQueries({
        @NamedStoredProcedureQuery(name = "GET_ALL_PRODUCTS", procedureName = "GET_ALL_PRODUCTS"),
        @NamedStoredProcedureQuery(name = "GET_PRODUCT_BY_ID", procedureName = "GET_PRODUCT_BY_ID", parameters = {
                @StoredProcedureParameter(mode = ParameterMode.IN, name = "product_id", type = Integer.class) }),
        @NamedStoredProcedureQuery(name = "SAVE_PRODUCT", procedureName = "SAVE_PRODUCT", parameters = {
                @StoredProcedureParameter(mode = ParameterMode.IN, name = "name", type = String.class),
                @StoredProcedureParameter(mode = ParameterMode.IN, name = "price", type = Integer.class),
                @StoredProcedureParameter(mode = ParameterMode.IN, name = "description", type = String.class) })
})
public class ProductEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "price", nullable = false)
    private Integer price;

    @Column(name = "description")
    private String description;

    public ProductEntity() {
    }

    public ProductEntity(String name, Integer price, String description) {
        this.name = name;
        this.price = price;
        this.description = description;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}

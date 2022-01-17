package dev.wocampo.soap.server.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import dev.wocampo.soap.server.entities.ProductEntity;
import dev.wocampo.soap.server.enumerations.SoapStatus;
import dev.wocampo.soap.server.exceptions.ProductException;
import dev.wocampo.soap.server.exceptions.ServiceFaultException;
import dev.wocampo.soap.server.repositories.IProductRepository;
import dev.wocampo.soap.server.services.IProductService;

@Service
public class ProductServiceImpl implements IProductService {

    @Autowired
    private IProductRepository productRepository;

    @Override
    public List<ProductEntity> getAll() {
        return productRepository.callGetAllProducts();
    }

    @Override
    public ProductEntity getById(Integer id) {
        Optional<ProductEntity> productEntity = productRepository.callGetProductById(id);
        if (!productEntity.isPresent()) {
            throw new ProductException(String.format("El producto con id %s no existe.", id));
        }
        return productEntity.get();
    }

    @Override
    public ProductEntity save(ProductEntity product) {
        if (product.getName() == null || product.getName().length() == 0) {
            throw new ProductException("El nombre del producto es requerido.");
        }
        if (product.getName() == null || product.getPrice() <= 0) {
            throw new ProductException("El precio del producto es requerido.");
        }
        try {
            return productRepository.callSaveProduct(product.getName(), product.getPrice(), product.getDescription());
        } catch (Exception e) {
            throw new ServiceFaultException("No se pudo registrar el producto.", e, SoapStatus.FAIL.getStatus());
        }
    }

    @Override
    public ProductEntity update(ProductEntity product, Integer id) {
        ProductEntity productEntity = this.getById(id);
        if (product.getName() != null && product.getName().length() > 0) {
            productEntity.setName(product.getName());
        }
        if (product.getPrice() != null && product.getPrice() > 0) {
            productEntity.setPrice(product.getPrice());
        }
        if (product.getDescription() != null && product.getDescription().length() > 0) {
            productEntity.setDescription(product.getDescription());
        }
        try {
            return productRepository.callUpdateProduct(id, productEntity.getName(), productEntity.getPrice(),
                    productEntity.getDescription());
        } catch (Exception e) {
            throw new ServiceFaultException("No se pudo actualizar el producto.", e, SoapStatus.FAIL.getStatus());
        }

    }

    @Override
    public void delete(Integer id) {
        try {
            productRepository.callDeleteProduct(id);
        } catch (EmptyResultDataAccessException e) {
            throw new ProductException(String.format("El producto con id %s no existe.", id));
        }
    }

}

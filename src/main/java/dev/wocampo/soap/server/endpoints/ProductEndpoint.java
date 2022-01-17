package dev.wocampo.soap.server.endpoints;

import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import dev.wocampo.soap.server.enumerations.SoapStatus;
import dev.wocampo.soap.server.helpers.ProductHelper;
import dev.wocampo.soap.server.services.IProductService;
import dev.wocampo.soap.server.webservice.*;

@Endpoint
public class ProductEndpoint {

    private static final String NAMESPACE_URI = "http://www.wocampo.dev/soap/server/webservice";

    @Autowired
    private IProductService productService;

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getProductsRequest")
    @ResponsePayload
    public GetProductsResponse handler(@RequestPayload GetProductsRequest request) {
        GetProductsResponse response = new GetProductsResponse();
        productService.getAll().stream()
                .map(x -> ProductHelper.convertToResponse(x))
                .collect(Collectors.toList())
                .forEach(x -> response.getProduct().add(x));
        response.setStatus(SoapStatus.OK.getStatus());
        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getProductByIdRequest")
    @ResponsePayload
    public GetProductByIdResponse handler(@RequestPayload GetProductByIdRequest request) {
        Product productToResponse = ProductHelper.convertToResponse(productService.getById(request.getProductId()));
        GetProductByIdResponse response = new GetProductByIdResponse();
        response.setStatus(SoapStatus.OK.getStatus());
        response.setProduct(productToResponse);
        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "saveProductRequest")
    @ResponsePayload
    public SaveProductResponse handler(@RequestPayload SaveProductRequest request) {
        Product product = new Product();
        product.setName(request.getName());
        product.setPrice(request.getPrice());
        product.setDescription(request.getDescription());
        product = ProductHelper.convertToResponse(
                productService.save(ProductHelper.convertToEntity(product)));
        SaveProductResponse response = new SaveProductResponse();
        response.setStatus(SoapStatus.OK.getStatus());
        response.setProduct(product);
        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "updateProductRequest")
    @ResponsePayload
    public UpdateProductResponse handler(@RequestPayload UpdateProductRequest request) {
        Product product = request.getProduct();
        product = ProductHelper.convertToResponse(
                productService.update(ProductHelper.convertToEntity(product), product.getProductId()));
        UpdateProductResponse response = new UpdateProductResponse();
        response.setStatus(SoapStatus.OK.getStatus());
        response.setProduct(product);
        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "deleteProductRequest")
    @ResponsePayload
    public DeleteProductResponse handler(@RequestPayload DeleteProductRequest request) {
        productService.delete(request.getProductId());
        DeleteProductResponse response = new DeleteProductResponse();
        response.setStatus(SoapStatus.OK.getStatus());
        return response;
    }

}

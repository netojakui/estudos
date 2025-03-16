package br.com.geosapiens.mapper;

import br.com.geosapiens.dto.ProductDTO;
import br.com.geosapiens.model.Product;
import org.springframework.stereotype.Component;

@Component
public class ProductMapper {

    public ProductDTO toProductDTO(Product product) {
        if (product == null) {
            return null;
        }
        ProductDTO productDTO = new ProductDTO();
        productDTO.setId(product.getId());
        productDTO.setDescription(product.getDescription());
        productDTO.setValue(product.getValue());
        return productDTO;
    }

    public Product toProduct(ProductDTO productDTO) {
        if (productDTO == null) {
            return null;
        }
        Product product = new Product();
        product.setId(productDTO.getId());
        product.setDescription(productDTO.getDescription());
        product.setValue(productDTO.getValue());
        return product;
    }
}
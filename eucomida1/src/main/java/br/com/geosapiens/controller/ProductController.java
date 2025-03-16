package br.com.geosapiens.controller;

import br.com.geosapiens.dto.ProductDTO;
import br.com.geosapiens.mapper.ProductMapper;
import br.com.geosapiens.model.Product;
import br.com.geosapiens.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/products")
public class ProductController {
    @Autowired
    private ProductService productService;

    @Autowired
    private ProductMapper productMapper;

    @PostMapping
    public ResponseEntity<ProductDTO> createProduct(@RequestBody ProductDTO productDTO) {
        Product product = productMapper.toProduct(productDTO);
        Product createdProduct = productService.createProduct(product);
        return ResponseEntity.ok(productMapper.toProductDTO(createdProduct));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductDTO> getProductById(@PathVariable Long id) {
        Product product = productService.getProductById(id);
        return ResponseEntity.ok(productMapper.toProductDTO(product));
    }

    @GetMapping
    public ResponseEntity<List<ProductDTO>> getAllProducts() {
        List<Product> products = productService.getAllProducts();
        List<ProductDTO> productDTOs = products.stream()
                                               .map(productMapper::toProductDTO)
                                               .collect(Collectors.toList());
        return ResponseEntity.ok(productDTOs);
    }
}
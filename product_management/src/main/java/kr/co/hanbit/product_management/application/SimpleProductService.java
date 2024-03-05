package kr.co.hanbit.product_management.application;

import kr.co.hanbit.product_management.domain.Product;
import kr.co.hanbit.product_management.domain.ProductRepository;
import kr.co.hanbit.product_management.presentation.ProductDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class SimpleProductService {
    private ProductRepository productRepository;
    private ValidationService validationService;

    public ProductDto add(ProductDto productDto) {
        Product product = ProductDto.toEntity(productDto);
        validationService.checkValid(product);
        Product savedProduct = productRepository.add(product);
        ProductDto savedProductDto = ProductDto.toDto(savedProduct);
        return savedProductDto;
    }

    public ProductDto findById(Long id) {
        Product product = productRepository.findById(id);
        ProductDto productDto = ProductDto.toDto(product);
        return productDto;
    }

    public List<ProductDto> findAll() {
        List<Product> products = productRepository.findAll();
        List<ProductDto> productDtos = products.stream()
                .map(product -> ProductDto.toDto(product))
                .toList();
        return productDtos;
    }

    public List<ProductDto> findByNameContaining(String name) {
        List<Product> products = productRepository.findByNameContaining(name);
        List<ProductDto> productDtos = products.stream()
                .map(product -> ProductDto.toDto(product))
                .toList();
        return productDtos;
    }

    public ProductDto update(ProductDto productDto) {
        Product product = ProductDto.toEntity(productDto);
        Product updatedProduct = productRepository.update(product);
        ProductDto updatedProductDto = ProductDto.toDto(updatedProduct);
        return updatedProductDto;
    }

    public void delete(Long id) {
        productRepository.delete(id);
    }
}

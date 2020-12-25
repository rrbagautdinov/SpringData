package ru.geekbrains.data.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.geekbrains.data.model.Product;
import ru.geekbrains.data.repository.ProductRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;

    public List<Product> getAllProducts() {
        return new ArrayList<>(productRepository.findAll());
    }

    public Optional<Product> getProductById(Long id) {
        return productRepository.findById(id);
    }

    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }

    public Product updateProduct(Long id, Product product) {
        Product productForUpdate = productRepository.findById(id).get();
        productForUpdate.setName(product.getName());
        productForUpdate.setPrice(product.getPrice());
        productRepository.save(productForUpdate);
        return productForUpdate;
    }

    public void deleteProductById(Long id) {
        productRepository.deleteById(id);
    }

    public List<Product> findProductUpperThenMinPrice(int price) {
        return productRepository.findByPriceGreaterThan(price);
    }

    public List<Product> findProductLowerThenMaxPrice(int price) {
        return productRepository.findByPriceLessThan(price);
    }

    public List<Product> findProductBetweenTwoPrices(int minPrice, int maxPrice) {
        return productRepository.findByPriceBetween(minPrice, maxPrice);
    }
}

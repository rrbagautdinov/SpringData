package ru.geekbrains.data.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.geekbrains.data.model.Product;
import ru.geekbrains.data.service.ProductService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    @GetMapping
    public List<Product> findAllProduct() {
        return productService.getAllProducts();
    }

    @GetMapping("/{id}")
    public Optional<Product> getProductById(@PathVariable("id") Long id) {
        return productService.getProductById(id);
    }

    @PostMapping("/add")
    public Product addNewProduct(@RequestBody Product product) {
        return productService.saveProduct(product);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteProduct(@PathVariable("id") Long id) {
        productService.deleteProductById(id);
    }

    @PutMapping("/update/{id}")
    public Product updateProduct(@PathVariable("id") Long id, @RequestBody Product product) {
        return productService.updateProduct(id, product);
    }

    @GetMapping("/upperThenMinPrice/{price}")
    public List<Product> findProductUpperThenMinPrice(@PathVariable("price") int price) {
        return productService.findProductUpperThenMinPrice(price);
    }

    @GetMapping("/lowerThenMaxPrice/{price}")
    public List<Product> findProductLowerThenMaxPrice(@PathVariable("price") int price) {
        return productService.findProductLowerThenMaxPrice(price);
    }

    @GetMapping("/betweenTwoPrices")
    public List<Product> findBetweenTwoPrices(@RequestParam("minPrice") int minPrice,
                                              @RequestParam("maxPrice") int maxPrice) {
        return productService.findProductBetweenTwoPrices(minPrice, maxPrice);

    }}

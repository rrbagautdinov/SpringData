package ru.geekbrains.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.geekbrains.data.model.Product;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findByPriceGreaterThan(int price);
    List<Product> findByPriceLessThan(int price);
    List<Product> findByPriceBetween(int minPrice, int maxPrice);
}

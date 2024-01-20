package ru.netology;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ShopRepositoryTest {

    @Test

    public void removeExistingProduct() {
        ShopRepository repo = new ShopRepository();

        Product product1 = new Product(1, "яблоко", 70);
        Product product2 = new Product(2, "апельсин", 100);
        Product product3 = new Product(3, "груша", 80);

        repo.add(product1);
        repo.add(product2);
        repo.add(product3);
        repo.remove(2);

        Product[] expected = {product1, product3};
        Product[] actual = repo.findAll();

        Assertions.assertArrayEquals(expected, actual);


    }

    @Test

    public void removeNotExistingProduct() {
        ShopRepository repo = new ShopRepository();

        Product product1 = new Product(1, "яблоко", 70);
        Product product2 = new Product(2, "апельсин", 100);
        Product product3 = new Product(3, "груша", 80);

        repo.add(product1);
        repo.add(product2);
        repo.add(product3);

        Assertions.assertThrows(NotFoundException.class,
                () -> repo.remove(4)
        );


    }

}
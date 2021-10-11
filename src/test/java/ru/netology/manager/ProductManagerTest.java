package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;
import ru.netology.repository.ProductRepository;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.doReturn;

@ExtendWith(MockitoExtension.class)


class ProductManagerTest {

    @Mock
    private ProductRepository repository;

    @InjectMocks
    ProductManager manager;

    Product first = new Book(1, "detective", 460, "Kristi");
    Product second = new Book(2, "novel", 720, "Tolstoy");
    Product third = new Book(3, "fantasy", 330, "Lukanenko");
    Product fourth = new Smartphone(4, "Iphone", 120000, "China");
    Product fifth = new Smartphone(5, "Nokia", 4000, "China");
    Product sixth = new Smartphone(6, "samsung", 56000, "China");

    @BeforeEach
    public void setUp() {
        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.add(fourth);
        manager.add(fifth);
        manager.add(sixth);
    }

    @Test
    void shouldSearchByNameBook() {
        Product[] returned = new Product[]{first, second, third, fourth, fifth, sixth};
        doReturn(returned).when(repository).findAll();
        Product[] expected = new Product[]{third};
        Product[] actual = manager.searchBy("fantasy");
        assertArrayEquals(expected, actual);

    }
    @Test
    void shouldSearchByAuthorOfBook() {
        Product[] returned = new Product[]{first, second, third, fourth, fifth, sixth};
        doReturn(returned).when(repository).findAll();
        Product[] expected = new Product[]{second};
        Product[] actual = manager.searchBy("Tolstoy");
        assertArrayEquals(expected, actual);

    }
    @Test
    void shouldSearchBySmartphoneName() {
        Product[] returned = new Product[]{first, second, third, fourth, fifth, sixth};
        doReturn(returned).when(repository).findAll();
        Product[] expected = new Product[]{fifth};
        Product[] actual = manager.searchBy("Nokia");
        assertArrayEquals(expected, actual);

    }
    @Test
    void shouldSearchBySmartphoneProducer() {
        Product[] returned = new Product[]{first, second, third, fourth, fifth, sixth};
        doReturn(returned).when(repository).findAll();
        Product[] expected = new Product[]{fourth, fifth, sixth};
        Product[] actual = manager.searchBy("China");
        assertArrayEquals(expected, actual);

    }

    @Test
    void shouldSearchByInvalidBookName() {
        Product[] returned = new Product[]{first, second, third, fourth, fifth, sixth};
        doReturn(returned).when(repository).findAll();
        Product[] expected = {};
        Product[] actual = manager.searchBy("poem");
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSearchByInvalidAuthor() {
        Product[] returned = new Product[]{first, second, third, fourth, fifth, sixth};
        doReturn(returned).when(repository).findAll();
        Product[] expected = {};
        Product[] actual = manager.searchBy("Lermontov");
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSearchByInvalidSmartphoneName() {
        Product[] returned = new Product[]{first, second, third, fourth, fifth, sixth};
        doReturn(returned).when(repository).findAll();
        Product[] expected = {};
        Product[] actual = manager.searchBy("Phillips");
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSearchByInvalidProducer() {
        Product[] returned = new Product[]{first, second, third, fourth, fifth, sixth};
        doReturn(returned).when(repository).findAll();
        Product[] expected = {};
        Product[] actual = manager.searchBy("USA");
        assertArrayEquals(expected, actual);
    }

    //@Test
    //void shouldRemoveById() {
    //    repository.removeById(6);
    //    Product[] expected = new Product[]{first, second, third, fourth, fifth, sixth};
    //    Product[] actual = repository.findAll();
    //    assertArrayEquals(expected, actual);
    //}



}
package com.shop.ecommerce.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.anyDouble;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.shop.ecommerce.dto.ProductDto;
import com.shop.ecommerce.exceptions.ProductNotExistsException;
import com.shop.ecommerce.model.Category;
import com.shop.ecommerce.model.Product;
import com.shop.ecommerce.repository.ProductRepository;

import java.util.ArrayList;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {ProductService.class})
@ExtendWith(SpringExtension.class)
class ProductServiceTest {
    @MockBean
    private ProductRepository productRepository;

    @Autowired
    private ProductService productService;

    /**
     * Method under test: {@link ProductService#createProduct(ProductDto, Category)}
     */
    @Test
    void testCreateProduct() {
        Category category = new Category();
        category.setCategoryName("Category Name");
        category.setDescription("The characteristics of someone or something");
        category.setId(1);
        category.setImageUrl("https://example.org/example");

        Product product = new Product();
        product.setCategory(category);
        product.setDescription("The characteristics of someone or something");
        product.setId(1);
        product.setImageURL("https://example.org/example");
        product.setName("Name");
        product.setPrice(10.0d);
        when(this.productRepository.save((Product) any())).thenReturn(product);

        ProductDto productDto = new ProductDto();
        productDto.setCategoryId(123);
        productDto.setDescription("The characteristics of someone or something");
        productDto.setId(1);
        productDto.setImageURL("https://example.org/example");
        productDto.setName("Name");
        productDto.setPrice(10.0d);

        Category category1 = new Category();
        category1.setCategoryName("Category Name");
        category1.setDescription("The characteristics of someone or something");
        category1.setId(1);
        category1.setImageUrl("https://example.org/example");
        this.productService.createProduct(productDto, category1);
        verify(this.productRepository).save((Product) any());
    }

    /**
     * Method under test: {@link ProductService#createProduct(ProductDto, Category)}
     */
    @Test
    void testCreateProduct2() {
        when(this.productRepository.save((Product) any())).thenThrow(new ProductNotExistsException("Msg"));

        ProductDto productDto = new ProductDto();
        productDto.setCategoryId(123);
        productDto.setDescription("The characteristics of someone or something");
        productDto.setId(1);
        productDto.setImageURL("https://example.org/example");
        productDto.setName("Name");
        productDto.setPrice(10.0d);

        Category category = new Category();
        category.setCategoryName("Category Name");
        category.setDescription("The characteristics of someone or something");
        category.setId(1);
        category.setImageUrl("https://example.org/example");
        assertThrows(ProductNotExistsException.class, () -> this.productService.createProduct(productDto, category));
        verify(this.productRepository).save((Product) any());
    }

    /**
     * Method under test: {@link ProductService#getProductDto(Product)}
     */
    @Test
    void testGetProductDto() {
        Category category = new Category();
        category.setCategoryName("Category Name");
        category.setDescription("The characteristics of someone or something");
        category.setId(1);
        category.setImageUrl("https://example.org/example");

        Product product = new Product();
        product.setCategory(category);
        product.setDescription("The characteristics of someone or something");
        product.setId(1);
        product.setImageURL("https://example.org/example");
        product.setName("Name");
        product.setPrice(10.0d);
        ProductDto actualProductDto = this.productService.getProductDto(product);
        assertEquals(1, actualProductDto.getCategoryId().intValue());
        assertEquals(10.0d, actualProductDto.getPrice());
        assertEquals("Name", actualProductDto.getName());
        assertEquals("https://example.org/example", actualProductDto.getImageURL());
        assertEquals(1, actualProductDto.getId().intValue());
        assertEquals("The characteristics of someone or something", actualProductDto.getDescription());
    }

    /**
     * Method under test: {@link ProductService#getProductDto(Product)}
     */
    @Test
    void testGetProductDto2() {
        Category category = new Category();
        category.setCategoryName("Category Name");
        category.setDescription("The characteristics of someone or something");
        category.setId(1);
        category.setImageUrl("https://example.org/example");

        Category category1 = new Category();
        category1.setCategoryName("Category Name");
        category1.setDescription("The characteristics of someone or something");
        category1.setId(1);
        category1.setImageUrl("https://example.org/example");
        Product product = mock(Product.class);
        when(product.getPrice()).thenReturn(10.0d);
        when(product.getId()).thenReturn(1);
        when(product.getCategory()).thenReturn(category1);
        when(product.getDescription()).thenReturn("The characteristics of someone or something");
        when(product.getImageURL()).thenReturn("https://example.org/example");
        when(product.getName()).thenReturn("Name");
        doNothing().when(product).setCategory((Category) any());
        doNothing().when(product).setDescription((String) any());
        doNothing().when(product).setId((Integer) any());
        doNothing().when(product).setImageURL((String) any());
        doNothing().when(product).setName((String) any());
        doNothing().when(product).setPrice(anyDouble());
        product.setCategory(category);
        product.setDescription("The characteristics of someone or something");
        product.setId(1);
        product.setImageURL("https://example.org/example");
        product.setName("Name");
        product.setPrice(10.0d);
        ProductDto actualProductDto = this.productService.getProductDto(product);
        assertEquals(1, actualProductDto.getCategoryId().intValue());
        assertEquals(10.0d, actualProductDto.getPrice());
        assertEquals("Name", actualProductDto.getName());
        assertEquals("https://example.org/example", actualProductDto.getImageURL());
        assertEquals(1, actualProductDto.getId().intValue());
        assertEquals("The characteristics of someone or something", actualProductDto.getDescription());
        verify(product).getCategory();
        verify(product).getPrice();
        verify(product).getId();
        verify(product).getDescription();
        verify(product).getImageURL();
        verify(product).getName();
        verify(product).setCategory((Category) any());
        verify(product).setDescription((String) any());
        verify(product).setId((Integer) any());
        verify(product).setImageURL((String) any());
        verify(product).setName((String) any());
        verify(product).setPrice(anyDouble());
    }

    /**
     * Method under test: {@link ProductService#getProductDto(Product)}
     */
    @Test
    void testGetProductDto3() {
        Category category = new Category();
        category.setCategoryName("Category Name");
        category.setDescription("The characteristics of someone or something");
        category.setId(1);
        category.setImageUrl("https://example.org/example");

        Category category1 = new Category();
        category1.setCategoryName("Category Name");
        category1.setDescription("The characteristics of someone or something");
        category1.setId(1);
        category1.setImageUrl("https://example.org/example");
        Product product = mock(Product.class);
        when(product.getPrice()).thenThrow(new ProductNotExistsException("Msg"));
        when(product.getId()).thenThrow(new ProductNotExistsException("Msg"));
        when(product.getCategory()).thenReturn(category1);
        when(product.getDescription()).thenReturn("The characteristics of someone or something");
        when(product.getImageURL()).thenReturn("https://example.org/example");
        when(product.getName()).thenReturn("Name");
        doNothing().when(product).setCategory((Category) any());
        doNothing().when(product).setDescription((String) any());
        doNothing().when(product).setId((Integer) any());
        doNothing().when(product).setImageURL((String) any());
        doNothing().when(product).setName((String) any());
        doNothing().when(product).setPrice(anyDouble());
        product.setCategory(category);
        product.setDescription("The characteristics of someone or something");
        product.setId(1);
        product.setImageURL("https://example.org/example");
        product.setName("Name");
        product.setPrice(10.0d);
        assertThrows(ProductNotExistsException.class, () -> this.productService.getProductDto(product));
        verify(product).getCategory();
        verify(product).getPrice();
        verify(product).getDescription();
        verify(product).getImageURL();
        verify(product).getName();
        verify(product).setCategory((Category) any());
        verify(product).setDescription((String) any());
        verify(product).setId((Integer) any());
        verify(product).setImageURL((String) any());
        verify(product).setName((String) any());
        verify(product).setPrice(anyDouble());
    }

    /**
     * Method under test: {@link ProductService#getAllProducts()}
     */
    @Test
    void testGetAllProducts() {
        when(this.productRepository.findAll()).thenReturn(new ArrayList<>());
        assertTrue(this.productService.getAllProducts().isEmpty());
        verify(this.productRepository).findAll();
    }

    /**
     * Method under test: {@link ProductService#getAllProducts()}
     */
    @Test
    void testGetAllProducts2() {
        Category category = new Category();
        category.setCategoryName("Category Name");
        category.setDescription("The characteristics of someone or something");
        category.setId(1);
        category.setImageUrl("https://example.org/example");

        Product product = new Product();
        product.setCategory(category);
        product.setDescription("The characteristics of someone or something");
        product.setId(1);
        product.setImageURL("https://example.org/example");
        product.setName("Name");
        product.setPrice(10.0d);

        ArrayList<Product> productList = new ArrayList<>();
        productList.add(product);
        when(this.productRepository.findAll()).thenReturn(productList);
        assertEquals(1, this.productService.getAllProducts().size());
        verify(this.productRepository).findAll();
    }

    /**
     * Method under test: {@link ProductService#getAllProducts()}
     */
    @Test
    void testGetAllProducts3() {
        when(this.productRepository.findAll()).thenThrow(new ProductNotExistsException("Msg"));
        assertThrows(ProductNotExistsException.class, () -> this.productService.getAllProducts());
        verify(this.productRepository).findAll();
    }

    /**
     * Method under test: {@link ProductService#getAllProducts()}
     */
    @Test
    void testGetAllProducts4() {
        Category category = new Category();
        category.setCategoryName("Category Name");
        category.setDescription("The characteristics of someone or something");
        category.setId(1);
        category.setImageUrl("https://example.org/example");

        Category category1 = new Category();
        category1.setCategoryName("Category Name");
        category1.setDescription("The characteristics of someone or something");
        category1.setId(1);
        category1.setImageUrl("https://example.org/example");
        Product product = mock(Product.class);
        when(product.getPrice()).thenThrow(new ProductNotExistsException("Msg"));
        when(product.getId()).thenThrow(new ProductNotExistsException("Msg"));
        when(product.getCategory()).thenReturn(category1);
        when(product.getDescription()).thenReturn("The characteristics of someone or something");
        when(product.getImageURL()).thenReturn("https://example.org/example");
        when(product.getName()).thenReturn("Name");
        doNothing().when(product).setCategory((Category) any());
        doNothing().when(product).setDescription((String) any());
        doNothing().when(product).setId((Integer) any());
        doNothing().when(product).setImageURL((String) any());
        doNothing().when(product).setName((String) any());
        doNothing().when(product).setPrice(anyDouble());
        product.setCategory(category);
        product.setDescription("The characteristics of someone or something");
        product.setId(1);
        product.setImageURL("https://example.org/example");
        product.setName("Name");
        product.setPrice(10.0d);

        ArrayList<Product> productList = new ArrayList<>();
        productList.add(product);
        when(this.productRepository.findAll()).thenReturn(productList);
        assertThrows(ProductNotExistsException.class, () -> this.productService.getAllProducts());
        verify(this.productRepository).findAll();
        verify(product).getCategory();
        verify(product).getPrice();
        verify(product).getDescription();
        verify(product).getImageURL();
        verify(product).getName();
        verify(product).setCategory((Category) any());
        verify(product).setDescription((String) any());
        verify(product).setId((Integer) any());
        verify(product).setImageURL((String) any());
        verify(product).setName((String) any());
        verify(product).setPrice(anyDouble());
    }

    /**
     * Method under test: {@link ProductService#updateProduct(ProductDto, Integer)}
     */
    @Test
    void testUpdateProduct() throws Exception {
        Category category = new Category();
        category.setCategoryName("Category Name");
        category.setDescription("The characteristics of someone or something");
        category.setId(1);
        category.setImageUrl("https://example.org/example");

        Product product = new Product();
        product.setCategory(category);
        product.setDescription("The characteristics of someone or something");
        product.setId(1);
        product.setImageURL("https://example.org/example");
        product.setName("Name");
        product.setPrice(10.0d);
        Optional<Product> ofResult = Optional.of(product);

        Category category1 = new Category();
        category1.setCategoryName("Category Name");
        category1.setDescription("The characteristics of someone or something");
        category1.setId(1);
        category1.setImageUrl("https://example.org/example");

        Product product1 = new Product();
        product1.setCategory(category1);
        product1.setDescription("The characteristics of someone or something");
        product1.setId(1);
        product1.setImageURL("https://example.org/example");
        product1.setName("Name");
        product1.setPrice(10.0d);
        when(this.productRepository.save((Product) any())).thenReturn(product1);
        when(this.productRepository.findById((Integer) any())).thenReturn(ofResult);

        ProductDto productDto = new ProductDto();
        productDto.setCategoryId(123);
        productDto.setDescription("The characteristics of someone or something");
        productDto.setId(1);
        productDto.setImageURL("https://example.org/example");
        productDto.setName("Name");
        productDto.setPrice(10.0d);
        this.productService.updateProduct(productDto, 123);
        verify(this.productRepository).save((Product) any());
        verify(this.productRepository).findById((Integer) any());
    }

    /**
     * Method under test: {@link ProductService#updateProduct(ProductDto, Integer)}
     */
    @Test
    void testUpdateProduct2() throws Exception {
        Category category = new Category();
        category.setCategoryName("Category Name");
        category.setDescription("The characteristics of someone or something");
        category.setId(1);
        category.setImageUrl("https://example.org/example");

        Product product = new Product();
        product.setCategory(category);
        product.setDescription("The characteristics of someone or something");
        product.setId(1);
        product.setImageURL("https://example.org/example");
        product.setName("Name");
        product.setPrice(10.0d);
        Optional<Product> ofResult = Optional.of(product);
        when(this.productRepository.save((Product) any())).thenThrow(new ProductNotExistsException("Msg"));
        when(this.productRepository.findById((Integer) any())).thenReturn(ofResult);

        ProductDto productDto = new ProductDto();
        productDto.setCategoryId(123);
        productDto.setDescription("The characteristics of someone or something");
        productDto.setId(1);
        productDto.setImageURL("https://example.org/example");
        productDto.setName("Name");
        productDto.setPrice(10.0d);
        assertThrows(ProductNotExistsException.class, () -> this.productService.updateProduct(productDto, 123));
        verify(this.productRepository).save((Product) any());
        verify(this.productRepository).findById((Integer) any());
    }

    /**
     * Method under test: {@link ProductService#updateProduct(ProductDto, Integer)}
     */
    @Test
    void testUpdateProduct3() throws Exception {
        Category category = new Category();
        category.setCategoryName("Category Name");
        category.setDescription("The characteristics of someone or something");
        category.setId(1);
        category.setImageUrl("https://example.org/example");

        Product product = new Product();
        product.setCategory(category);
        product.setDescription("The characteristics of someone or something");
        product.setId(1);
        product.setImageURL("https://example.org/example");
        product.setName("Name");
        product.setPrice(10.0d);
        when(this.productRepository.save((Product) any())).thenReturn(product);
        when(this.productRepository.findById((Integer) any())).thenReturn(Optional.empty());

        ProductDto productDto = new ProductDto();
        productDto.setCategoryId(123);
        productDto.setDescription("The characteristics of someone or something");
        productDto.setId(1);
        productDto.setImageURL("https://example.org/example");
        productDto.setName("Name");
        productDto.setPrice(10.0d);
        assertThrows(Exception.class, () -> this.productService.updateProduct(productDto, 123));
        verify(this.productRepository).findById((Integer) any());
    }

    /**
     * Method under test: {@link ProductService#findById(Integer)}
     */
    @Test
    void testFindById() throws ProductNotExistsException {
        Category category = new Category();
        category.setCategoryName("Category Name");
        category.setDescription("The characteristics of someone or something");
        category.setId(1);
        category.setImageUrl("https://example.org/example");

        Product product = new Product();
        product.setCategory(category);
        product.setDescription("The characteristics of someone or something");
        product.setId(1);
        product.setImageURL("https://example.org/example");
        product.setName("Name");
        product.setPrice(10.0d);
        Optional<Product> ofResult = Optional.of(product);
        when(this.productRepository.findById((Integer) any())).thenReturn(ofResult);
        assertSame(product, this.productService.findById(123));
        verify(this.productRepository).findById((Integer) any());
    }

    /**
     * Method under test: {@link ProductService#findById(Integer)}
     */
    @Test
    void testFindById2() throws ProductNotExistsException {
        when(this.productRepository.findById((Integer) any())).thenReturn(Optional.empty());
        assertThrows(ProductNotExistsException.class, () -> this.productService.findById(123));
        verify(this.productRepository).findById((Integer) any());
    }

    /**
     * Method under test: {@link ProductService#findById(Integer)}
     */
    @Test
    void testFindById3() throws ProductNotExistsException {
        when(this.productRepository.findById((Integer) any())).thenThrow(new ProductNotExistsException("Msg"));
        assertThrows(ProductNotExistsException.class, () -> this.productService.findById(123));
        verify(this.productRepository).findById((Integer) any());
    }
}


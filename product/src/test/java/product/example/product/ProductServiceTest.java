package product.example.product;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import product.example.product.Entity.Product;
import product.example.product.Repository.ProductRepository;
import product.example.product.ServiceImpl.ProductService;
class ProductServiceTest {

    @Mock
    private ProductRepository productRepository;

    @InjectMocks
    private ProductService productService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this); // Initialize the mocks
    }

    @Test
    void testSaveAllProducts() {
        // Arrange: Create sample product list
        List<Product> products = Arrays.asList(
                new Product("Product 1", "Description 1", 10),
                new Product("Product 2", "Description 2", 5)
        );

        // Mock repository behavior
        when(productRepository.saveAll(products)).thenReturn(products);

        // Act: Call the service method
        List<Product> savedProducts = productService.saveAllProducts(products);

        // Assert: Verify the expected behavior
        assertEquals(2, savedProducts.size());
        assertEquals("Product 1", savedProducts.get(0).getTitle());
        assertEquals("Product 2", savedProducts.get(1).getTitle());
    }
}

package product.example.product;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import product.example.product.Controller.ProductController;

import java.util.Arrays;
import java.util.List;
import product.example.product.ServiceImpl.ProductService;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import product.example.product.Entity.Product;


@WebMvcTest(ProductController.class)
class ProductControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ProductService productService;

    @Autowired
    private ObjectMapper objectMapper;  // This helps to convert objects to JSON

    private List<Product> products;

    @BeforeEach
    void setUp() {
        products = Arrays.asList(
                new Product( "Product 1", "Description 1", 10),
                new Product( "Product 2", "Description 2", 5)
        );
    }

    @Test
    void testSaveProducts() throws Exception {

        when(productService.saveAllProducts(any())).thenReturn(products);

        mockMvc.perform(post("/api/v1/products/saveProducts")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(products))) // Send JSON content
                .andExpect(status().isCreated()) // Expect HTTP 201 Created
                .andExpect(content().json(objectMapper.writeValueAsString(products))); // Expect the returned JSON to match the products list
    }
}

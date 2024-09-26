package product.example.product.Controller;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import product.example.product.Entity.Product;
import product.example.product.ServiceImpl.ProductService;

import java.util.List;

@RestController
@RequestMapping("api/v1/products")
public class ProductController {

    private ProductService productService;
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping("/saveProducts")
    public ResponseEntity<List<Product>> saveProducts(@RequestBody List<Product> products) {
        List<Product> savedProducts = productService.saveAllProducts(products);
        return new ResponseEntity<>(savedProducts, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Product>> findAllProducts() {
        List<Product> savedProducts = productService.findAll();
        return new ResponseEntity<>(savedProducts, HttpStatus.CREATED);
    }

}

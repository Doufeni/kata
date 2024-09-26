package product.example.product.ServiceImpl;


import org.springframework.stereotype.Service;
import product.example.product.Entity.Product;
import product.example.product.Repository.ProductRepository;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class ProductService {

    private ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }


    public List<Product> saveAllProducts(List<Product> products) {
        Iterable<Product> savedProducts = productRepository.saveAll(products);
        return StreamSupport
                .stream(savedProducts.spliterator(), false)
                .collect(Collectors.toList());
    }}

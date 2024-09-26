package product.example.product.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import product.example.product.Entity.Product;

@Repository
public interface ProductRepository extends CrudRepository<Product, Long> {
}

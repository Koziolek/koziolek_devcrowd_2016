package pl.koziolekweb.devcrowd16.data.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.koziolekweb.devcrowd16.data.Product;

/**
 * TODO write JAVADOC!!!
 * User: koziolek
 */
@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
}

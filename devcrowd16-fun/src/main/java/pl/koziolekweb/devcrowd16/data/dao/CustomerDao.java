package pl.koziolekweb.devcrowd16.data.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.koziolekweb.devcrowd16.data.Customer;

/**
 * TODO write JAVADOC!!!
 * User: koziolek
 */
public interface CustomerDao extends JpaRepository<Customer, Long> {
}

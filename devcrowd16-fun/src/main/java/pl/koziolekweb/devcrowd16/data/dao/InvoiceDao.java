package pl.koziolekweb.devcrowd16.data.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.koziolekweb.devcrowd16.data.Invoice;

/**
 * TODO write JAVADOC!!!
 * User: koziolek
 */
public interface InvoiceDao extends JpaRepository<Invoice, Long> {
}

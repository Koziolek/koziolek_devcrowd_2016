package pl.koziolekweb.devcrowd16.customers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.koziolekweb.devcrowd16.data.Customer;
import pl.koziolekweb.devcrowd16.data.Invoice;
import pl.koziolekweb.devcrowd16.data.dao.CustomerDao;
import pl.koziolekweb.devcrowd16.data.dao.InvoiceDao;

import javax.transaction.Transactional;
import java.util.Collection;
import java.util.Collections;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Stream;

/**
 * TODO write JAVADOC!!!
 * User: koziolek
 */
@Component
public class CustomerService {

	@Autowired
	private CustomerDao dao;

	@Autowired
	private InvoiceDao invoiceDao;

	public Collection<Customer> findAll() {
		return dao.findAll();
	}

	public Optional<Customer> find(Long id) {
		return Optional.ofNullable(dao.findOne(id));
	}

	public Optional<Invoice> addInvoice(Long id) {
		return Optional.ofNullable(dao.findOne(id))
				.map(c -> {
					Invoice i = new Invoice();
					i.setCustomer(c);
					return invoiceDao.save(i);
				});
	}

	@Transactional
	public Stream<Invoice> updateInvoices(Long id, Function<Invoice, Invoice> updater) {
		return Optional.ofNullable(dao.findOne(id))
				.map(Customer::getInvoices)
				.orElseGet(Collections::emptyList)
				.stream()
				.map(updater.andThen(invoiceDao::saveAndFlush));
	}


}

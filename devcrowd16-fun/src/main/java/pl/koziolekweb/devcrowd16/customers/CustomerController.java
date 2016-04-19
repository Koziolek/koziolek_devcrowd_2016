package pl.koziolekweb.devcrowd16.customers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import pl.koziolekweb.devcrowd16.data.Customer;
import pl.koziolekweb.devcrowd16.data.Invoice;

import java.util.Collection;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * TODO write JAVADOC!!!
 * User: koziolek
 */
@RestController
public class CustomerController {

	@Autowired
	private CustomerService service;

	@RequestMapping(path = "/customers", method = RequestMethod.GET)
	public Collection<Customer> all() {
		return service.findAll();
	}

	@RequestMapping(path = "/customer/{id}", method = RequestMethod.GET)
	public Customer byId(@PathVariable("id") Long id) {
		return service.find(id).orElseThrow(() -> new IllegalArgumentException("No client with Id: " + id));
	}

	@RequestMapping(path = "/customer/add/{id}", method = RequestMethod.GET)
	public Invoice newClientInvoice(@PathVariable("id") Long id) {
		Optional<Invoice> invoice = service.addInvoice(id);

		return invoice.orElseThrow(() -> new IllegalArgumentException("No client with Id: " + id));
	}

	@RequestMapping(path = "/customer/update/{id}", method = RequestMethod.GET)
	public Collection<Invoice> updateCustomerInvoices(@PathVariable("id") Long id) {
		Stream<Invoice> invoiceStream = service.updateInvoices(id, i -> new Invoice(i.getId(), i.getCustomer(), i.getTotal() + 1));
		return invoiceStream.collect(Collectors.toList());
	}


}

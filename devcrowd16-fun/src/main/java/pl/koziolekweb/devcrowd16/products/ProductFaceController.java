package pl.koziolekweb.devcrowd16.products;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import pl.koziolekweb.devcrowd16.data.Product;
import pl.koziolekweb.devcrowd16.data.dao.ProductRepository;

import java.util.Collection;

/**
 * TODO write JAVADOC!!!
 * User: koziolek
 */
@RestController
public class ProductFaceController {

	@Autowired
	private ProductRepository repository;

	@RequestMapping(path = "/product", method = RequestMethod.GET)
	public Collection<Product> all() {
		return repository.findAll();
	}
}

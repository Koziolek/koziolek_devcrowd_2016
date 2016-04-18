package pl.koziolekweb.devcrowd16.data;

import java.io.Serializable;

/**
 * TODO write JAVADOC!!!
 * User: koziolek
 */
public class ItemInvoice implements Serializable {

	private int item;
	private Invoice invoice;

	public int getItem() {
		return item;
	}

	public void setItem(int item) {
		this.item = item;
	}

	public Invoice getInvoice() {
		return invoice;
	}

	public void setInvoice(Invoice invoice) {
		this.invoice = invoice;
	}
}

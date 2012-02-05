package controllers;

import models.Contact;
import models.Link;
import play.Logger;
import play.mvc.Controller;

public class JavaScript extends Controller {

	public static void index() {
		render();
	}

	public static void init() {
		Contact contact = Contact.getByFirstName("sylvain");
		if (contact == null) {
			contact = new Contact("sylvain", "s.malnuit@libertysurf.fr");
			contact.save();
			Logger.info("Add + " + contact.toString());
		}

		contact = Contact.getByFirstName("eva");
		if (contact == null) {
			contact = new Contact("eva", "evammoll@gmail.com");
			contact.save();
			Logger.info("Add + " + contact.toString());
		}

		contact = Contact.getByFirstName("cris");
		if (contact == null) {
			contact = new Contact("cris", "eire2410@gmail.com");
			contact.save();
			Logger.info("Add + " + contact.toString());
		}

		contact = Contact.getByFirstName("sage");
		if (contact == null) {
			contact = new Contact("sage", "sylvain.malnuit@sage.com");
			contact.save();
			Logger.info("Add + " + contact.toString());
		}

	}

	public static void insert(String name, String url) {
		Contact contact = Contact.getByFirstName(name);
		if (contact != null) {
			Link link = new Link(url, contact);
			Logger.info("Add " + url.toString() + " for " + contact.firstName);
			link.save();
		}
	}

}

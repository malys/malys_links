package controllers;

import models.Contact;
import models.Link;
import play.Logger;
import play.mvc.Controller;

public class JavaScript extends Controller {

	public static void index() {
		render();
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

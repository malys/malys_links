package controllers;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.List;

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

	public static void insertPOST(String name, String url, String comment)
			throws UnsupportedEncodingException {

		Contact contact = Contact.getByFirstName(name);
		if (contact != null) {
			Link link = new Link(URLDecoder.decode(url, "UTF-8"), contact);
			if (comment != null) {
				link.comment = URLDecoder.decode(comment, "UTF-8") + "\n";
			}
			Logger.info("Add " + url.toString() + " for " + contact.firstName);
			link.save();
		}
	}

	public static void getModifiedUrls(String name) {
		List<Link> listLink = Link.getByModified(Contact.getByFirstName(name));
		renderJSON(listLink);
	}
}

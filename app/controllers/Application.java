package controllers;

import play.*;
import play.mvc.*;

import java.util.*;

import models.*;

 
	public class Application extends Controller {
	 
	    public static void index() {
	        if(Auth.isLoggedIn()) {
	            Contact user = Contact.getByEmail(Auth.getEmail());
	            if(null == user) {
	                user = new Contact();
	                user.emailAddress = Auth.getEmail();
	           
	                user.insert();
	               // Profile.edit(user.id);
	                return;
	            }
	            Profile.index();
	        }
	        render();
	    }
	 
	    public static void login() {
	        Auth.login("Application.index");
	    }
	 
	    public static void logout() {
	        Auth.logout("Application.index");
	    }
	}
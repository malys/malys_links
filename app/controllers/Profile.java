package controllers;

import models.*;
import play.*;
import play.mvc.*;
import java.util.*;
 
import play.data.validation.*;
import java.net.*;

import java.io.*;
 
import play.Logger;

public class Profile extends Application {
 
    @Before
    static void checkConnected() {
        if(Auth.getUser() == null) {
            Application.login();
        } else {
            renderArgs.put("user", Auth.getEmail());
        }
    }
 
    public static void index() {
        Contact user = Contact.getByEmail(Auth.getEmail());
 
        List<Link> links = null;

        links = Link.getByContact(user);
     

        render(user, links);
    }

}
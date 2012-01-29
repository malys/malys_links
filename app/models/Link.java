package models;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import play.*;
import play.db.jpa.*;
import siena.Column;
import siena.DateTime;
import siena.Generator;
import siena.Id;
import siena.Index;
import siena.Max;
import siena.NotNull;
import siena.Query;
import siena.Table;
import siena.core.Many;
import siena.core.Owned;
import siena.core.batch.Batch;

@Table("links")
public class Link extends siena.Model {
    @Id(Generator.AUTO_INCREMENT)
    public Long id; 

    @Column("url")
    @Max(100) @NotNull
    public String url;    
    
    @Column("modified")
    @NotNull
    @Index("modified")
    public Boolean isModified; 
    
    
    @Index("contact")
    public Contact contact;
    
    @Column("created")
    @NotNull @DateTime
    public Date created;
 
    
    public Link(){
    	super();
    }
    
    public Link(String url,Contact contact){
    	this.url = url;
    	isModified = true;
    	created = Calendar.getInstance().getTime();
    	
    }
    

    
    public String toString(){
    	return "id: "+id+", url: "+url ;
    }
    
    public static Query<Link> all() {
    	return siena.Model.all(Link.class);
    }
    
    public static Batch<Link> batch() {
    	return siena.Model.batch(Link.class);
    }
    
    public static Link getByUrl(String url){
    	return all().filter("url", url).get();
    }
    
    public static List<Link> getByContact(Contact contact){
    	return all().filter("contact", contact).fetch();
    }
    
    public static List<Link> getModified(){
    	return all().filter("isModified", true).fetch();
    }
    
    public static List<Link> getByNotModified(Contact contact){
    	return all().filter("isModified", true).filter("contact", contact).fetch();
    	
    	
    }
    

}




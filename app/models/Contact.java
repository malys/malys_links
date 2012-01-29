package models;


import play.data.validation.Email;
import play.modules.crudsiena.CrudUnique;
import siena.*;
import siena.core.batch.Batch;



@Table("contacts")
public class Contact extends Model {

        @Id(Generator.AUTO_INCREMENT)
        public Long id; 

        @Column("first_name")
        @Max(100) @NotNull
        public String firstName;    
        
        @Column("email")
        @Max(100) @NotNull @CrudUnique @Email
        public String emailAddress; 
        
        public Contact(){
        	super();
        }
        
        public Contact(String firstName,String email){
        	super();
        	this.firstName = firstName;
        	this.emailAddress = email;
        }
        
        
        public String toString() {
        	return "id: "+id+", name: "+firstName ;
        }
        
        
        public static Contact getByEmail(String email){
        	return all().filter("email", email).get();
        }
        
        public static Contact getByFirstName(String firstName){
        	return all().filter("firstName", firstName).get();
        }
        

 
        
        public static siena.Query<Contact> all() {
        	return siena.Model.all(Contact.class);
        }
        
        public static Batch<Contact> batch() {
        	return siena.Model.batch(Contact.class);
        }
  
      
}
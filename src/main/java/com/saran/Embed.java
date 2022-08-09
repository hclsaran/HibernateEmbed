package com.saran;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

public class Embed {

	 
	public static void main(String[] args) {
         
      
      Address addr1=new Address();
      addr1.setStreet("Interlaken dr");
      addr1.setCity("Bethel Park");
      addr1.setState("PA");
      addr1.setZipcode("15102");
      
      Address addr2=new Address();
      addr2.setStreet("HighField Ct");
      addr2.setCity("Bridgeville");
      addr2.setState("PA");
      addr2.setZipcode("15058");
      
      UserDetails usr1=new UserDetails("Colin",addr1);
      UserDetails usr2=new UserDetails("Bin",addr2);
       
     SessionFactory sf=new AnnotationConfiguration().configure().buildSessionFactory();
		Session s1=sf.openSession();
		s1.beginTransaction();
		s1.save(usr1);s1.save(usr2);
      s1.getTransaction().commit();
      s1.close();sf.close();
      
	}

}

/**
 * 
 */
package org.ikane.hibernate;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.ikane.hibernate.dto.Address;
import org.ikane.hibernate.dto.Book;
import org.ikane.hibernate.dto.UserDetails;

/**
 * @author ikane
 *
 */
public class HibernateTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		UserDetails user = new UserDetails();
		
		//user.setUserId(1);
		user.setUsername("First user");
		user.setJoinDate(new Date());
		user.setDescription("First user descritpion");
		
		Address addr = new Address();
		addr.setStreet("Street name");
		addr.setCity("city name");
		addr.setPincode("1000");
		
		Address addr2 = new Address();
		addr2.setStreet("Street name 2");
		addr2.setCity("city name 2");
		addr2.setPincode("2000");
		
		Book book = new Book("book1", "ABCD", "John Doe");
		Book book2 = new Book("book2", "EFGH", "Mickel M");
		
		user.setAddress(addr);
		user.setJobAddress(addr2);
		
		user.getBooks().add(book);
		user.getBooks().add(book2);
		
		user.getAdresses().add(addr);
		user.getAdresses().add(addr2);
		
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(user);
		session.getTransaction().commit();
		
		session.close();
		
		user = null;
		session = sessionFactory.openSession();
		//session.beginTransaction();
		user = (UserDetails)session.get(UserDetails.class, 1);
		session.close();
		System.out.println(user.getAdresses().size());
		
	}
}

/**
 * 
 */
package org.ikane.hibernate;

import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.ikane.hibernate.dto.Address;
import org.ikane.hibernate.dto.Book;
import org.ikane.hibernate.dto.FourWheeler;
import org.ikane.hibernate.dto.TwoWheeler;
import org.ikane.hibernate.dto.UserDetails;
import org.ikane.hibernate.dto.Vehicle;

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
		
//		Address addr = new Address();
//		addr.setStreet("Street name");
//		addr.setCity("city name");
//		addr.setPincode("1000");
//		
//		Address addr2 = new Address();
//		addr2.setStreet("Street name 2");
//		addr2.setCity("city name 2");
//		addr2.setPincode("2000");
//		
//		Book book = new Book("book1", "ABCD", "John Doe");
//		Book book2 = new Book("book2", "EFGH", "Mickel M");
//		
//		user.setAddress(addr);
//		user.setJobAddress(addr2);
//		
//		user.getBooks().add(book);
//		user.getBooks().add(book2);
//		
//		user.getAdresses().add(addr);
//		user.getAdresses().add(addr2);
		
		Vehicle vehicle = new Vehicle();
		vehicle.setVehicleName("Car");
		
		TwoWheeler twoWheeler = new TwoWheeler();
		twoWheeler.setVehicleName("Bike");
		twoWheeler.setSteeringHandle("Bike Steering");
		
		FourWheeler fourWheeler = new FourWheeler();
		fourWheeler.setVehicleName("Jeep");
		fourWheeler.setSteeringWheel("Porshe Steering Wheel");
		
//		Vehicle vehicle2 = new Vehicle();
//		vehicle2.setVehicleName("Jeep");
//		
//		vehicle.getUsers().add(user);
//		vehicle2.getUsers().add(user);
//		
//		user.getVehicles().add(vehicle);
//		user.getVehicles().add(vehicle2);
		
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
//		Query query = session.createQuery("from UserDetails where userId > :toto");
//		query.setFirstResult(5);
//		query.setMaxResults(4);
//		query.setInteger("toto", 6);
		Query query = session.getNamedQuery("userByName");
		query.setString(0, "User 5");
		List<UserDetails> users = query.list();
		
		session.getTransaction().commit();
		session.close();
		
		//System.out.println(user.getUsername());
		for(UserDetails u: users)
			System.out.println(u.getUsername());
		
//      //user = null;
//		vehicle = null;
//		session = sessionFactory.openSession();
//		vehicle = (Vehicle)session.get(Vehicle.class, 1);
//		//session.close();
//		System.out.println(vehicle.getUser().getUsername());
	}
}

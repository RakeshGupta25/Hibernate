package hibernate.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import hibernate.pojo.Employee;



public class Hibernate_Test {

	public static void main(String[] args) {

		/*
		 * Configuration is class of hibernate API. It used read data from
		 * hibernate.cfg.xml file and create the object sessionFactory interface
		 */
		Configuration config = new Configuration().configure("hibernate.cfg.xml");

		/*
		 * SessionFactory is interface of hibernate API sessionFactory is used establish
		 * connection between Java Application and Database sessionFactory also create
		 * object session Interface
		 */

		SessionFactory sessionFactory = config.buildSessionFactory();

		/*
		 * SessionFactory is interface of hibernate API sessionFactory is used execute
		 * transaction of database so it healp to create object Transaction Interface
		 */

		Session session = sessionFactory.openSession();

		/*
		 * Create a Transaction interface object suing session interface object
		 */

		Transaction transaction = session.beginTransaction();

		// create a employee object which we want save in database
		Employee emp = new Employee();
		emp.setEmpId(102);
		emp.setEmpName("Rajesh Sharma");
		emp.setEmpSalary(1555000);

		session.save(emp);
		transaction.commit();
		System.out.println("successfully saved");
		sessionFactory.close();
		session.close();
	}

}

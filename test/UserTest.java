
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.bookstore.entity.Users;

public class UserTest {

	public static void main(String[] args) {
		Users users = new Users();
		
		users.setEmail("vaib@gmail.com");
		users.setFullName("Vaibhav");
		users.setPassword("vaibhav");
		
		EntityManagerFactory createEntityManagerFactory = Persistence.createEntityManagerFactory("bookstore");
		EntityManager createEntityManager = createEntityManagerFactory.createEntityManager();
		createEntityManager.getTransaction().begin();
		createEntityManager.persist(users);
		createEntityManager.getTransaction().commit();
		createEntityManager.close();
		createEntityManagerFactory.close();
		System.out.println("A user object was persisited");
	}

}

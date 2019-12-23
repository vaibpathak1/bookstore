
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.bookstore.entity.Category;

public class CategoryTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Category categoryTest = new Category("Core Java");
		
		EntityManagerFactory createEntityManagerFactory = Persistence.createEntityManagerFactory("bookstore");
		EntityManager createEntityManager = createEntityManagerFactory.createEntityManager();
		createEntityManager.getTransaction().begin();
		createEntityManager.persist(categoryTest);
		createEntityManager.getTransaction().commit();
		createEntityManager.close();
		createEntityManagerFactory.close();
		System.out.println("A user object was persisited");

	}

}

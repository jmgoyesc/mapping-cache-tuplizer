import com.personal.hiberante.model.Event;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Test load mappings and configuration
 * Created by juan.goyes on 2017-05-02.
 */
public class MappingTest {

	private SessionFactory sessionFactory;

	@Before
	public void setup(){
		Configuration configuration = new Configuration();
		configuration.configure();
		sessionFactory = configuration.buildSessionFactory();
	}

	@Test
	public void test() {
		Session session = sessionFactory.openSession();
		Event event = new Event("my event");
		session.save(event);
		session.close();
		assertNotNull(event.getId());
	}
}

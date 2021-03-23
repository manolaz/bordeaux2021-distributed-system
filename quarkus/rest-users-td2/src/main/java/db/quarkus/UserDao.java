package db.quarkus;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Set;
import java.util.Date;

@Singleton
public class UserDao {

    @Inject
    private EntityManager entityManager;

    public void persist(User user) {
        entityManager.persist(user);
    }

    public void delete(User user) {
        entityManager.remove(user);
    }

    public User findById(Long id) {
        return entityManager.find(User.class, id);
    }

    public List<User> findAll() {
        return entityManager.createQuery("FROM User", User.class).getResultList();
    }

    public List<User> findByName(String lastName) {
        return entityManager.createQuery("FROM User WHERE lastName = :lastName", User.class).setParameter("lastName", lastName).getResultList();
    }

    public List<User> findBornAfter(Date date) {
        return entityManager.createQuery("FROM User WHERE birth > :date", User.class).setParameter("date", date).getResultList();
    }
}
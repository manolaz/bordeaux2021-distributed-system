package db.quarkus;
import java.util.Date;
import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import io.quarkus.hibernate.orm.panache.PanacheEntity;

@Entity
@Cacheable
@Table(name="USER")
public class User extends PanacheEntity  {
    private int id;
    private String firstname;
    private String lastname;
    private Date added;
    private Date birth;

    //add the corresponding getters and setters
    public User() {
    }

    public User(String firstname, String lastname, Date added, Date birth ) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.added = added;
        this.birth = birth;
    }
}
package models;

import java.util.*;

import play.db.ebean.*;
import play.data.validation.Constraints.*;

import javax.persistence.*;

@Entity
@Table(
    name="USER", 
    uniqueConstraints=
        @UniqueConstraint(columnNames={"ID"})
)
public class User extends Model {
  
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    public Long id;

    @Required
    public String username;

    @OneToMany(mappedBy="user", cascade=CascadeType.ALL)
    public List<PurchaseOrder> orders;

    public static Finder<Long, User> find = new Finder(
        Long.class, User.class
    );

    public static List<User> all() {
        return find.all();
    }

    public static void create(User user) {
        user.save();
    }

    public static void delete(Long id) {
        find.ref(id).delete();
    }
}

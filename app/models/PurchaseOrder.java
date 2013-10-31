package models;

import java.util.*;

import play.db.ebean.*;
import play.data.validation.Constraints.*;

import javax.persistence.*;

@Entity
public class PurchaseOrder extends Model {
  
    @Id
    public Long id;

    @Required
    public String companyName;

    @Required
    public String contactPerson;

    // TODO: Add date

    @Required
    @ManyToOne
    public User user;

    public static Finder<Long, PurchaseOrder> find = new Finder(
        Long.class, PurchaseOrder.class
    );

    public static List<PurchaseOrder> all() {
        return find.all();
    }

    public static void create(PurchaseOrder order) {
        if(order.user.id == null) {
            order.user = null;
        } else {
            order.user = User.find.byId(order.user.id);
        }
      
        order.save();
    }

    public static void delete(Long id) {
        find.ref(id).delete();
    }
}

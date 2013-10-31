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


    public static Finder<Long, PurchaseOrder> find = new Finder(
        Long.class, PurchaseOrder.class
    );

    public static List<PurchaseOrder> all() {
        return find.all();
    }

    public static void create(PurchaseOrder order) {
        order.save();
    }

    public static void delete(Long id) {
        find.ref(id).delete();
    }
}

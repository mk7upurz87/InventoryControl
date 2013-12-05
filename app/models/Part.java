package models;

import java.util.*;

import play.db.ebean.*;
import play.data.validation.Constraints.*;

import javax.persistence.*;

@Entity
@Table(
    name="PART", 
    uniqueConstraints=
        @UniqueConstraint(columnNames={"ID"})
)
public class Part extends Model {
  
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    public Long id;

    @Required
    public String label;

    @Required
    public String brand;

    @Required
    public Long quantity;

    public static Finder<Long, Part> find = new Finder(
        Long.class, Part.class
    );

    public static List<Part> all() {
        return find.all();
    }

    public static void create(Part part) {
        part.save();
    }

    public static void delete(Long id) {
        find.ref(id).delete();
    }

    // public static void removeQty(Long id, int qty) {
    //     quantity -= 1;
    // }

    // public static void addQty(Long id, int qty) {
    //     quantity += 1;
    // }
}

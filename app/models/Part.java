package models;

import java.util.*;

import play.db.ebean.*;
import play.data.validation.Constraints.*;

import javax.persistence.*;

@Entity
public class Part extends Model {
  
  @Id
  public Long id;

  @Required(message="You must name a new part type.")
  public String label;

  @Required(message="You must name a new part brand.")
  public String brand;

  @Required(message="You must specify an initial quantity.")
  @Min(message="Quantity can't be negative.", value=0)
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
    
}

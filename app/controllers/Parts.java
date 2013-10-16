package controllers;

import play.*;
import play.mvc.*;
import play.data.*;

import views.html.*;
import models.*;


public class Parts extends Controller {

    private static Form<Part> partForm = Form.form(Part.class);
    private static HashMap<long, Part> parts = new HashMap<long, Part>();

    public static Result index() {
        return ok(views.html.index.render(Part.all(), partForm));
    }

    public static Result newPart() {
        Form<Part> filledForm = signupForm.bindFromRequest();
        
        String label    = filledForm.field("label").value();
        long id         = Long.parseLong(filledForm.field("id").value());
        int initialQty  = Integer.parseInt(filledForm.field("qty").value());
        String brand    = filledForm.field("brand").value();

        if(!parts.containsKey(id)) {
            parts.add(id, new Part(label, id, initialQty, brand));
        } else {
            return ok("Failure: part number " + id + " already exists.");
        }
        return ok("part number " + id + " has been created.");
    }

    public static Result deletePart(long id) {
        if(!parts.containsKey(id)) {
            parts.remove(id);
        } else {
            return ok("part number " + id + " does not exist in the database.");
        }
        return ok("part number " + id + " has been removed.");
    }

    public static Result decrementQty(long id, int qty) {
        if(parts.containsKey(id)) {
            int newQty = parts.get(id);

            if(newQty < 0) {
                return ok(newQty);
            }

            if(newQty == 0) {
                return ok("part number " + id + " has reached 0!");
            }
        } else {
            return ok("part number " + id + " does not exist in the database.");
        }
    }

    public static Result incrementQty(Long id, int qty) {
        int newQty = 0;
        if(parts.containsKey(id)) {
            newQty = parts.get(id) + qty;
        }

        return ok("part number " + id + " has " + newQty + " in stock.");
    }
}

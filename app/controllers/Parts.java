package controllers;

import play.*;
import play.mvc.*;
import play.data.*;

import views.html.*;
import models.*;


public class Parts extends Controller {

    static Form<Part> partForm = Form.form(Part.class);
    private HashMap<long, Part> parts = new HashMap<long, Part>();

    public static Result index() {
        return ok(views.html.index.render(Part.all(), partForm));
    }

    public static Result newPart(String label, long id, int qty, String brand) {
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
        if(!parts.containsKey(id)) {
            int newQty = parts.get(id).remove(qty);

            if(newQty < 0) {
                return ok(newQty);
            }

            if(newQty == 0) {
                return ok("part number " + id + "has reached 0!");
            }
        } else {
            return ok("part number " + id + " does not exist in the database.");
        }
    }
}

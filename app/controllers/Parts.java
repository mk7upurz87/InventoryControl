package controllers;

import play.*;
import play.mvc.*;
import play.data.*;

import views.html.*;
import models.*;


public class Parts extends Controller {

    static Form<Part> partForm = Form.form(Part.class);

    public static Result index() {
        return ok(views.html.index.render(Part.all(), partForm));
    }

    public static Result newPart() {
        return TODO;
    }

    public static Result deletePart(long id) {
        return TODO;
    }
}

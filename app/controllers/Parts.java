package controllers;

import play.*;
import play.mvc.*;
import play.data.*;

import views.html.*;
import models.*;


public class Parts extends Controller {

    static Form<Part> partForm = Form.form(Part.class);

    public static Result index() {
        return ok(views.html.parts_index.render(Part.all(), partForm));
    }

    public static Result newPart() {
        Form<Part> filledForm = partForm.bindFromRequest();
        if(filledForm.hasErrors()) {
            return badRequest(
              views.html.parts_index.render(Part.all(), filledForm)
            );
        } else {
            Part.create(filledForm.get());
            return redirect(routes.Parts.index());
        }
    }

    public static Result deletePart(long id) {
        Part.delete(id);
        return redirect(routes.Parts.index());
    }
}

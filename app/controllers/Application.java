package controllers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import play.*;
import play.mvc.*;

import views.html.*;

public class Application extends Controller {

    public static Result index() {
        return redirect(routes.Parts.index());
    }
}

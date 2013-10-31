package controllers;

import play.*;
import play.mvc.*;
import play.data.*;

import views.html.*;
import models.*;


public class PurchaseOrders extends Controller {

    static Form<PurchaseOrder> orderForm = Form.form(PurchaseOrder.class);

    public static Result index() {
        return ok(views.html.orders_index.render(PurchaseOrder.all(), orderForm));
    }

    public static Result newOrder() {
        Form<PurchaseOrder> filledForm = orderForm.bindFromRequest();
        if(filledForm.hasErrors()) {
            return badRequest(
              views.html.orders_index.render(PurchaseOrder.all(), filledForm)
            );
        } else {
            PurchaseOrder.create(filledForm.get());
            return redirect(routes.PurchaseOrders.index());
        }
    }

    public static Result deleteOrder(long id) {
        PurchaseOrder.delete(id);
        return redirect(routes.PurchaseOrders.index());
    }
}

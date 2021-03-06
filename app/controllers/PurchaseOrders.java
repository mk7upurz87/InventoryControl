package controllers;

import play.mvc.*;
import play.data.*;

import models.*;


public class PurchaseOrders extends Controller {

    static Form<PurchaseOrder> orderForm = Form.form(PurchaseOrder.class);

    public static Result index() {
        return ok(views.html.orders_index.render(PurchaseOrder.all(), orderForm, User.all()));
    }

    public static Result newOrder() {
      return ok(views.html.orders_new.render(Part.all(), orderForm, User.all()));
    }
 
    public static Result createOrder() {
        Form<PurchaseOrder> filledForm = orderForm.bindFromRequest();
        if(filledForm.hasErrors()) {
            return badRequest(
              views.html.orders_index.render(PurchaseOrder.all(), filledForm, User.all())
            );
        } else {
            PurchaseOrder po = filledForm.get();
            po.user = User.find.byId(po.user.id);
            PurchaseOrder.create(po);
            return redirect(routes.PurchaseOrders.index());
        }
    }

    public static Result deleteOrder(long id) {
        PurchaseOrder.delete(id);
        return redirect(routes.PurchaseOrders.index());
    }
}

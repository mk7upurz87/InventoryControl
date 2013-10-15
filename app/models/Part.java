package models;

import java.util.*;

import play.api.Play.current;

public class Part {
    
    private static Long id;
    private static String label;
    private static int qty;
    private static String brand;

    public Part(String label, long id, int qty, String brand) {
        this.label = label;
        this.id = id;
        this.qty = qty;
        this.brand = brand;
    }

    public static List<Part> all() {
        return new ArrayList<Part>();
    }

    public static void remove(int qty) {
        this.qty -= qty;
        if(this.qty <= 0) {
            MailerAPI mail = play.Play.application.plugin(MailerPlugin.class).email();
            mail.setSubject("Part #" + this.id + ", " + this.label + " is at 0 qty.");
            mail.setRecipient("");
            mail.setFrom("Inventory Control <noreply@email.com>");
            String message =
                "This part: " + this.label + "/n" +
                "brand: " + this.brand + "/n";
            if(this.brand.equals("")){
                mail.send(message);
            } else {
                mail.send("can be purchased at: " + this.brand);
            }
        }
        return this.qty;
    }
}


package com.mycompany.lab_task_14;


public class Clothing  extends Product implements Discount {
      private String size;
    
    public Clothing(String name, double price, String size) {
        super(name, price);
        this.size = size;
    }
    
    public double getDiscount() {
        return price * 0.20;
    }
    
    public void showInfo() {
        System.out.println("Clothing: " + name);
        System.out.println("Price: " + price);
        System.out.println("Size: " + size);
        System.out.println("Discount: " + getDiscount());
    }

    
    
}

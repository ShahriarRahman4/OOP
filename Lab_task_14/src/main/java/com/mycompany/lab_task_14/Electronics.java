
package com.mycompany.lab_task_14;


public class Electronics extends Product implements Discount {
        private String brand;
    
    public Electronics(String name, double price, String brand) {
        super(name, price);
        this.brand = brand;
    }
    
    public double getDiscount() {
        return price * 0.10;
    }
    
    public void showInfo() {
        System.out.println("Electronics: " + name);
        System.out.println("Price: " + price );
        System.out.println("Brand: " + brand);
        System.out.println("Discount: " + getDiscount());
        System.out.println("  ");
    }

}

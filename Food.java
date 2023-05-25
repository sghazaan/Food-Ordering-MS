import java.util.Scanner;

public class Food {
    private String foodName;
    private double foodPrice;
    private String foodDescription;

    public Food() {
    }

    public Food(String foodName, double foodPrice, String foodDescription) {
        this.foodName = foodName;
        this.foodPrice = foodPrice;
        this.foodDescription = foodDescription;
    }

    public void setFoodName() {
        String fname;
        System.out.println("Enter food name: ");
        Scanner name = new Scanner(System.in);
        fname = name.nextLine();
        this.foodName = fname;
    }

    public void setFoodPrice() {
        double fprice;
        System.out.println("Enter food price in PKR: ");
        Scanner price = new Scanner(System.in);
        fprice=price.nextDouble();
        this.foodPrice = fprice;
    }

    public void setFoodDescription() {
        String description;
        System.out.println("Enter food description: ");
        Scanner des = new Scanner(System.in);
        description = des.nextLine();
        this.foodDescription = description;    }

    public String getFoodName() {
        return this.foodName;
    }

    public double getFoodPrice() {
        return foodPrice;
    }

    public String getFoodDescription() {
        return foodDescription;
    }
}

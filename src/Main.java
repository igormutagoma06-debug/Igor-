import java.util.Locale;
import java.util.Scanner;


class Car {
    private String model;

    private String brand;
    private int year;
    private double price;
    private String color;
    private int quantity;


    public Car(String model, String brand, int year,
               double price, String color, int quantity) {
        setModel(model);
        setBrand(brand);
        setYear(year);
        setPrice(price);
        setColor(color);
        setQuantity(quantity);
    }


    public String getModel() {
        return model;
    }

    public String getBrand() {
        return brand;
    }

    public int getYear() {
        return year;
    }

    public double getPrice() {
        return price;
    }

    public String getColor() {
        return color;
    }

    public int getQuantity() {
        return quantity;
    }

    // Setters with validation
    public void setModel(String model) {
        if (model == null || model.trim().isEmpty()) {
            throw new IllegalArgumentException("Model cannot be empty.");
        }
        this.model = model.trim();
    }

    public void setBrand(String brand) {
        if (brand == null || brand.trim().isEmpty()) {
            throw new IllegalArgumentException("Brand cannot be empty.");
        }
        this.brand = brand.trim();
    }

    public void setYear(int year) {
        if (year < 1886 || year > 2100) {
            throw new IllegalArgumentException("Invalid car year.");
        }
        this.year = year;
    }

    public void setPrice(double price) {
        if (!Double.isFinite(price) || price < 0) {
            throw new IllegalArgumentException(
                    "Price must be a non-negative number."
            );
        }
        this.price = price;
    }

    public void setColor(String color) {
        if (color == null || color.trim().isEmpty()) {
            throw new IllegalArgumentException("Color cannot be empty.");
        }
        this.color = color.trim();
    }

    public void setQuantity(int quantity) {
        if (quantity < 0) {
            throw new IllegalArgumentException(
                    "Quantity cannot be negative."
            );
        }
        this.quantity = quantity;
    }


    public void delivery(int amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException(
                    "Delivery amount must be greater than zero."
            );
        }

        this.quantity = Math.addExact(this.quantity, amount);
        System.out.println(amount + " car(s) delivered successfully.");
    }


    public boolean sell() {
        if (quantity == 0) {
            System.out.println("Sale unsuccessful: no cars in stock.");
            return false;
        }

        quantity--;
        System.out.println("Car sold successfully.");
        return true;
    }


    @Override
    public String toString() {
        return String.format(
                "Car [Brand: %s, Model: %s, Year: %d, Price: $%.2f, " +
                        "Color: %s, Quantity: %d]",
                brand, model, year, price, color, quantity
        );
    }
}

public class Main {
    public static void main(String[] args) {
        try {

            Car myCar = new Car(
                    "Model S", "Tesla", 2023,
                    79999.99, "Red", 10
            );

            System.out.println("--- Initial State ---");
            System.out.println(myCar);


            myCar.sell();

            System.out.println("\n--- After Selling ---");
            System.out.println(myCar);


            myCar.delivery(3);


            myCar.setColor("Midnight Black");
            myCar.setPrice(74999.99);

            System.out.println("\n--- After Updates ---");
            System.out.println(myCar);


            System.out.println("\n--- Car Details ---");
            System.out.println("Brand: " + myCar.getBrand());
            System.out.println("Model: " + myCar.getModel());
            System.out.println("Year: " + myCar.getYear());
            System.out.printf("Price: $%.2f%n", myCar.getPrice());
            System.out.println("Color: " + myCar.getColor());
            System.out.println("Quantity: " + myCar.getQuantity());

        } catch (IllegalArgumentException | ArithmeticException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}


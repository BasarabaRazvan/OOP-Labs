public class ProductFactory {
    public ProductFactory() {
    }

    public Product factory(String type, String nameProduct, float productPrice) {
        if (type.equalsIgnoreCase("book")) {
            return new Book(nameProduct, productPrice);
        } else if (type.equalsIgnoreCase("food")) {
            return new Food(nameProduct, productPrice);
        } else if (type.equalsIgnoreCase("computer")) {
            return new Computer(nameProduct, productPrice);
        } else if (type.equalsIgnoreCase("beverage")) {
            return new Beverage(nameProduct, productPrice);
        }

        return null;
    }
}

class Book extends Product {
    public Book(String name, Float price) {
        super(name, price);
    }

    @Override
    public Float getPriceReduced() {
        return (float) (super.getPrice() - super.getPrice() * 0.15);
    }
}

class Food extends Product{
    public Food(String name, Float price) {
        super(name, price);
    }

    @Override
    public Float getPriceReduced() {
        return (float) (super.getPrice() - super.getPrice() * 0.2);
    }
}

class Beverage extends Product {
    public Beverage(String name, Float price) {
        super(name, price);
    }

    @Override
    public Float getPriceReduced() {
        return (float) (super.getPrice() - super.getPrice() * 0.05);
    }
}

class Computer extends Product{
    public Computer(String name, Float price) {
        super(name, price);
    }

    @Override
    public Float getPriceReduced() {
        return (float) (super.getPrice() - super.getPrice() * 0.1);
    }
}
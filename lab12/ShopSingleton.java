import java.util.ArrayList;

public class ShopSingleton {
    private static ShopSingleton instance;
    private String name;
    private ArrayList<Product> products;

    private ShopSingleton(String name) {
        this.name = name;
        products = new ArrayList<Product>();
    }

    public static ShopSingleton getInstance(String name) {
        if (instance == null) {
            return new ShopSingleton(name);
        }
        return instance;
    }

    public static ShopSingleton getInstance() {
        return instance;
    }

    public static void setInstance(ShopSingleton instance) {
        ShopSingleton.instance = instance;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Product> getProducts() {
        return products;
    }

    public void setProducts(ArrayList<Product> products) {
        this.products = products;
    }


    public void addProduct(Product product) {
        if(products == null) {
            ArrayList<Product> p = new ArrayList<>();
            p.add(product);
            setProducts(p);
        }
        if(products.contains(product))
            return;
        products.add(product);
    }

    public void removeProduct(Product product) {
        if(products.contains(product))
            products.remove(product);
    }

    public Product getCheapestProduct() {
        Product min = products.get(0);
        float minimum = products.get(0).getPrice();

        for (Product product : products) {
            if (product.getPrice() < minimum) {
                min = product;
                minimum = product.getPrice();
            }
        }

        return min;
    }

    @Override
    public String toString() {
        return "ShopSingleton{" +
                "name='" + name + '\'' +
                ", products=" + products +
                '}';
    }
}

class Test {
    public static void main(String[] args) {
        ShopSingleton instance = ShopSingleton.getInstance("Market");
        ProductFactory factory = new ProductFactory();

        Product prod1 = factory.factory("book","book", (float) 12.3);
        Product prod2 = factory.factory("computer","computer", (float) 12.3);
        Product prod3 = factory.factory("beverage","beverage", (float) 12.3);
        Product prod4 = factory.factory("food","food", (float) 12.3);

        instance.addProduct(prod1);
        instance.addProduct(prod2);
        instance.addProduct(prod3);
        instance.addProduct(prod4);

        instance.removeProduct(prod2);

        System.out.println(instance.getCheapestProduct().getName());
    }
}
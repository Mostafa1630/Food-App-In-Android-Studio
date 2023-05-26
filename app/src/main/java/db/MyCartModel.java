package db;

public class MyCartModel {

    int image;
    String name;
    String pricing;
    String rating;

    public MyCartModel(int image, String name, String pricing, String rating) {
        this.image = image;
        this.name = name;
        this.pricing = pricing;
        this.rating = rating;
    }

    public int getImage() {
        return image;
    }

    public String getName() {
        return name;
    }

    public String getPricing() {
        return pricing;
    }

    public String getRating() {
        return rating;
    }
}

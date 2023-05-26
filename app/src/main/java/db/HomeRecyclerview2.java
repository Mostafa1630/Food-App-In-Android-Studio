package db;

public class HomeRecyclerview2 {
    int image;
    String rating;
    String pricing;
    String timing;
    String name;

    public HomeRecyclerview2(int image, String rating, String pricing, String timing, String name) {
        this.image = image;
        this.rating = rating;
        this.pricing = pricing;
        this.timing = timing;
        this.name = name;
    }

    public int getImage() {
        return image;
    }

    public String getRating() {
        return rating;
    }

    public String getPricing() {
        return pricing;
    }

    public String getTiming() {
        return timing;
    }

    public String getName() {
        return name;
    }
}

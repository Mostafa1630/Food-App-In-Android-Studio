package db;

public class FeaturedModel {
    int image;
    String name;
    String desc;
    public FeaturedModel(int image,String name,String desc){
        this.image=image;
        this.desc=desc;
        this.name=name;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public String getDesc() {
        return desc;
    }
}

package db;

public class dailyRecyclerview {

    int image;
    String name;
    String descount;

    String description;
    String type;
    public dailyRecyclerview(int image, String name, String descount , String description,String type) {
        this.image = image;
        this.name = name;
        this.descount = descount;

        this.description = description;
        this.type=type;
    }

    public String getType() {
        return type;
    }

    public int getImage() {
        return image;
    }

    public String getName() {
        return name;
    }

    public String getDescount() {
        return descount;
    }



    public String getDescription() {
        return description;
    }
}

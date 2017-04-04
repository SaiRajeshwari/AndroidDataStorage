package rajee.sairam.androiddatastorage;

/**
 * Created by rajee on 4/3/17.
 */

public class Product {

    private String name;
    private String desc;
    private String price;
    private String review;

    public Product(String name, String desc, String price, String review){
        this.name = name;
        this.desc = desc;
        this.price = price;
        this.review = review;
    }

    @Override
    public String toString() {
        return "Item Name:     " + name + "\n" +
                "Item Desc:    " + desc + "\n" +
                "Item Price:   " + price + "\n" +
                "Item Review:  " + review + "\n";
     }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }

}

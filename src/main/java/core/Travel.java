package core;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Travel {
    private int travel_id;
    private String country;
    private String town;
    private String levelHotel;
    private String food;
    private String rating;
    private int quantity;
    private int customer;

    public Travel() {
    }

    public Travel(int travel_id, String country, String town, String levelHotel, String food, String rating, int quantity, int customer) {
        this.travel_id = travel_id;
        this.country = country;
        this.town = town;
        this.levelHotel = levelHotel;
        this.food = food;
        this.rating = rating;
        this.quantity = quantity;
        this.customer = customer;
    }

    public int getTravel_id() {
        return travel_id;
    }

    @XmlElement
    public void setTravel_id(int travel_id) {
        this.travel_id = travel_id;
    }

    public String getCountry() {
        return country;
    }

    @XmlElement
    public void setCountry(String country) {
        this.country = country;
    }

    public String getTown() {
        return town;
    }

    @XmlElement
    public void setTown(String town) {
        this.town = town;
    }

    public String getLevelHotel() {
        return levelHotel;
    }

    @XmlElement
    public void setLevelHotel(String levelHotel) {
        this.levelHotel = levelHotel;
    }

    public String getFood() {
        return food;
    }

    @XmlElement
    public void setFood(String food) {
        this.food = food;
    }

    public String getRating() {
        return rating;
    }

    @XmlElement
    public void setRating(String rating) {
        this.rating = rating;
    }

    public int getQuantity() {
        return quantity;
    }

    @XmlElement
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getCustomer() {
        return customer;
    }

    @XmlElement
    public void setCustomer(int customer) {
        this.customer = customer;
    }
}

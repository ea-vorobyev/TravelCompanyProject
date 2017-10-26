package core;

import javax.xml.bind.annotation.XmlElement;

public class Customer extends User {
    private int customer_id;
    private String contactNumber;

    public Customer() {
    }

    public Customer(int customer_id, String firstName, String nickName, String familyName, String password, String contactNumber, String town, String birthDay, String email) {
        super(firstName, nickName, familyName, password, town, birthDay, email);
        this.contactNumber = contactNumber;
        this.customer_id = customer_id;
    }

    public int getCustomer_id() {
        return customer_id;
    }

    @XmlElement
    public void setCustomer_id(int customer_id) {
        this.customer_id = customer_id;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    @XmlElement
    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

}

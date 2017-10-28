package core;

import javax.xml.bind.annotation.XmlElement;

public class Administrator extends User {
    private int admin_id;//TODO: CODE CONVENTION adminId

    public Administrator() {

    }

    public Administrator(String firstName, String nickName, String familyName, String password, String town,String birthDay, String email) {
        super(firstName, nickName, familyName, password, town, birthDay, email);
    }

    public int getAdmin_id() {
        return admin_id;
    }

    @XmlElement
    public void setAdmin_id(int admin_id) {
        this.admin_id = admin_id;
    }
}

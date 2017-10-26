package core;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlTransient;

@XmlTransient
@XmlSeeAlso({Customer.class, Administrator.class})
abstract class User {
    private String firstName;
    private String nickName;
    private String familyName;
    private String password;
    private String town;
    private String birthDay;
    private String email;

    public User() {
    }

    public User(String firstName, String nickName, String familyName, String password, String town, String birthDay, String email) {
        this.firstName = firstName;
        this.nickName = nickName;
        this.familyName = familyName;
        this.password = password;
        this.town = town;
        this.birthDay = birthDay;
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    @XmlElement
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getNickName() {
        return nickName;
    }

    @XmlElement
    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getFamilyName() {
        return familyName;
    }

    @XmlElement
    public void setFamilyName(String familyName) {
        this.familyName = familyName;
    }

    public String getPassword() {
        return password;
    }

    @XmlElement
    public void setPassword(String password) {
        this.password = password;
    }

    public String getTown() {
        return town;
    }

    @XmlElement
    public void setTown(String town) {
        this.town = town;
    }

    public String getBirthDay() {
        return birthDay;
    }

    @XmlElement
    public void setBirthDay(String birthDay) {
        this.birthDay = birthDay;
    }

    public String getEmail() {
        return email;
    }

    @XmlElement
    public void setEmail(String email) {
        this.email = email;
    }

}

package core;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "users")
@XmlAccessorType(XmlAccessType.FIELD)
public class Users<T extends User> {

    @XmlElement(name = "user")
    private List<T> usersArray ;

    public List<T> getUsersArray() {
        return usersArray;
    }

    public void setUsersArray(List<T> usersArray) {
        this.usersArray = usersArray;
    }

}
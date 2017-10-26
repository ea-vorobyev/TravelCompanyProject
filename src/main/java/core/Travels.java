package core;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "travels")
@XmlAccessorType(XmlAccessType.FIELD)
public class Travels {

    @XmlElement(name = "travel")
    private List<Travel> travelsArray ;

    public List<Travel> getTravelsArray() {
        return travelsArray;
    }

    public void setTravelsArray(List<Travel> travelsArray) {
        this.travelsArray = travelsArray;
    }

}
package controlador;

import modelo.*;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement()
public class WebFunctions {


    private Player user;

    @XmlElement

    public Player getUser() {
        return user;
    }

    public void setUser(Player user) {
        this.user = user;
    }
}

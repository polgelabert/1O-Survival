package controlador;

import modelo.clasesTablas.Usuario2;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement()
public class WebFunctions {


    private Usuario2 user;

    @XmlElement

    public Usuario2 getUser() {
        return user;
    }

    public void setUser(Usuario2 user) {
        this.user = user;
    }
}

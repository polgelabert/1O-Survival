package controlador;

import modelo.*;
import modelo.clasesTablas.Usuario;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement()
public class WebFunctions {


    private Usuario user;

    @XmlElement

    public Usuario getUser() {
        return user;
    }

    public void setUser(Usuario user) {
        this.user = user;
    }
}

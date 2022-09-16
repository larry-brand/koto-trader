package org.cryptolosers.transaq.xml.command;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Команда "disconnect" , принимаемая коннектором
 */
@XmlRootElement(name = "command")
public class Disconnect {
    private String id = "disconnect";

    public String getId() {
        return id;
    }

    @XmlAttribute
    public void setId(String id) {
        this.id = id;
    }
}

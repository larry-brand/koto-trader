package org.cryptolosers.transaq.xml.command;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "command")
public class ChangePass {
    private String id = "change_pass";
    private String oldpass;
    private String newpass;

    public String getId() {
        return id;
    }

    @XmlAttribute
    public void setId(String id) {
        this.id = id;
    }

    public String getOldpass() {
        return oldpass;
    }

    @XmlAttribute
    public void setOldpass(String oldpass) {
        this.oldpass = oldpass;
    }

    public String getNewpass() {
        return newpass;
    }

    @XmlAttribute
    public void setNewpass(String newpass) {
        this.newpass = newpass;
    }
}


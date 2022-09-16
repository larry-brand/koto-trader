package org.cryptolosers.transaq.xml.command;

import org.cryptolosers.transaq.xml.command.internal.Security;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "command")
public class GetSecuritiesInfo {
    private String id = "get_securities_info";
    private Security security;

    public String getId() {
        return id;
    }

    @XmlAttribute
    public void setId(String id) {
        this.id = id;
    }

    public Security getSecurity() {
        return security;
    }

    public void setSecurity(Security security) {
        this.security = security;
    }
}

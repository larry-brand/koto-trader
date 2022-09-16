package org.cryptolosers.transaq.xml.command;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "command")
public class GetPortfolio {
    private String id = "get_portfolio";
    private String client;

    public String getId() {
        return id;
    }

    @XmlAttribute
    public void setId(String id) {
        this.id = id;
    }

    public String getClient() {
        return client;
    }

    @XmlAttribute
    public void setClient(String client) {
        this.client = client;
    }
}

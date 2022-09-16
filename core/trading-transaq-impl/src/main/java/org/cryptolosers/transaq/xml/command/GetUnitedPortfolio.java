package org.cryptolosers.transaq.xml.command;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "command")
public class GetUnitedPortfolio {
    private String id = "get_united_portfolio";
    private String client;
    private String union;

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

    public String getUnion() {
        return union;
    }

    @XmlAttribute
    public void setUnion(String union) {
        this.union = union;
    }
}

package org.cryptolosers.transaq.xml.callback;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "client")
public class Client {
    private String id;
    private Boolean remove;
    private Long market;
    private String currency;
    private String type;
    private String union;
    private String forts_acc;

    public String getId() {
        return id;
    }

    @XmlAttribute
    public void setId(String id) {
        this.id = id;
    }

    public Boolean getRemove() {
        return remove;
    }

    @XmlAttribute
    public void setRemove(Boolean remove) {
        this.remove = remove;
    }

    public Long getMarket() {
        return market;
    }

    public void setMarket(Long market) {
        this.market = market;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUnion() {
        return union;
    }

    public void setUnion(String union) {
        this.union = union;
    }

    public String getForts_acc() {
        return forts_acc;
    }

    public void setForts_acc(String forts_acc) {
        this.forts_acc = forts_acc;
    }
}

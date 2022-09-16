package org.cryptolosers.transaq.xml.command;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "command")
public class GetUnitedEquity {
    private String id = "get_united_equity";
    private String union;

    public String getId() {
        return id;
    }

    @XmlAttribute
    public void setId(String id) {
        this.id = id;
    }

    public String getUnion() {
        return union;
    }

    @XmlAttribute
    public void setUnion(String union) {
        this.union = union;
    }
}

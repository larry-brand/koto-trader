package org.cryptolosers.transaq.xml.command;


import org.cryptolosers.transaq.xml.command.internal.Security;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "command")
public class GetMaxBuySellTplus {
    private String id = "get_max_buy_sell_tplus";
    private String client;
    private List<Security> security;

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

    public List<Security> getSecurity() {
        return security;
    }

    public void setSecurity(List<Security> security) {
        this.security = security;
    }
}

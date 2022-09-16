package org.cryptolosers.transaq.xml.command;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "command")
public class GetFortsPosition {
    private String id = "get_forts_positions";
    /**  Если не указать клиента, запрос будет выполнен по всем доступным клиентам. */
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
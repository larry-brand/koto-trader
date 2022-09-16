package org.cryptolosers.transaq.xml.command;


import org.cryptolosers.transaq.xml.command.internal.Security;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Выдать последние N свечей заданного периода, по заданному инструменту
 */
@XmlRootElement(name = "command")
public class GetHistoryData {
    private String id = "gethistorydata";
    private Security security;
    private String period;
    private Long count;
    private Boolean reset;

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

    public String getPeriod() {
        return period;
    }

    public void setPeriod(String period) {
        this.period = period;
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }

    public Boolean getReset() {
        return reset;
    }

    public void setReset(Boolean reset) {
        this.reset = reset;
    }
}

package org.cryptolosers.transaq.xml.command;

import org.cryptolosers.transaq.xml.command.internal.Security;
import org.cryptolosers.transaq.xml.command.internal.Stoploss;
import org.cryptolosers.transaq.xml.command.internal.Takeprofit;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "command")
public class NewStopOrder {
    private String id = "newstoporder";
    private Security security;
    /** клиент */
    private String client;
    /** union code */
    private String union;
    /** "B" - покупка, или "S" – продажа */
    private String buysell;
    /** номер связной заявки */
    private String linkedorderno;
    /** заявка действительно до, необязательно */
    private String validfor;
    /** дата экспирации (только для ФОРТС), задается в формате 23.07.2012 00:00:00 (не обязательно) */
    private String expdate;
    private Stoploss stoploss;
    private Takeprofit takeprofit;

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

    public String getClient() {
        return client;
    }

    public void setClient(String client) {
        this.client = client;
    }

    public String getUnion() {
        return union;
    }

    public void setUnion(String union) {
        this.union = union;
    }

    public String getBuysell() {
        return buysell;
    }

    public void setBuysell(String buysell) {
        this.buysell = buysell;
    }

    public String getLinkedorderno() {
        return linkedorderno;
    }

    public void setLinkedorderno(String linkedorderno) {
        this.linkedorderno = linkedorderno;
    }

    public String getValidfor() {
        return validfor;
    }

    public void setValidfor(String validfor) {
        this.validfor = validfor;
    }

    public String getExpdate() {
        return expdate;
    }

    public void setExpdate(String expdate) {
        this.expdate = expdate;
    }

    public Stoploss getStoploss() {
        return stoploss;
    }

    public void setStoploss(Stoploss stoploss) {
        this.stoploss = stoploss;
    }

    public Takeprofit getTakeprofit() {
        return takeprofit;
    }

    public void setTakeprofit(Takeprofit takeprofit) {
        this.takeprofit = takeprofit;
    }
}

package org.cryptolosers.transaq.xml.command;

import org.cryptolosers.transaq.xml.command.internal.Security;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "command")
public class NewOrder {
    private String id = "neworder";
    private Security security;
    /** клиент */
    private String client;
    /** union code */
    private String union;
    /** цена */
    private String price;
    /** скрытое количество в лотах */
    private Long hidden;
    /** количество в лотах */
    private Long quantity;
    /** "B" - покупка, или "S" – продажа */
    private String buysell;
    /** <bymarket/> */
    private String bymarket;
    /** примечание, будет возвращено в составе структур order и trade */
    private String brokerref;
    /** "PutInQueue", другие возможные значения: FOK, IOC */
    private String unfilled;
    /** <usecredit/> */
    private String usecredit;
    /** <nosplit/> */
    private String nosplit;
    /** дата экспирации (только для ФОРТС), задается в формате 23.07.2012 00:00:00 (не обязательно) */
    private String expdate;

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

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public Long getHidden() {
        return hidden;
    }

    public void setHidden(Long hidden) {
        this.hidden = hidden;
    }

    public Long getQuantity() {
        return quantity;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }

    public String getBuysell() {
        return buysell;
    }

    public void setBuysell(String buysell) {
        this.buysell = buysell;
    }

    public String getBymarket() {
        return bymarket;
    }

    public void setBymarket(String bymarket) {
        this.bymarket = bymarket;
    }

    public String getBrokerref() {
        return brokerref;
    }

    public void setBrokerref(String brokerref) {
        this.brokerref = brokerref;
    }

    public String getUnfilled() {
        return unfilled;
    }

    public void setUnfilled(String unfilled) {
        this.unfilled = unfilled;
    }

    public String getUsecredit() {
        return usecredit;
    }

    public void setUsecredit(String usecredit) {
        this.usecredit = usecredit;
    }

    public String getNosplit() {
        return nosplit;
    }

    public void setNosplit(String nosplit) {
        this.nosplit = nosplit;
    }

    public String getExpdate() {
        return expdate;
    }

    public void setExpdate(String expdate) {
        this.expdate = expdate;
    }
}

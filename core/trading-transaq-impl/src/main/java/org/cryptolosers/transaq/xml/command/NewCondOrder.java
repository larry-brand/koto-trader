package org.cryptolosers.transaq.xml.command;

import org.cryptolosers.transaq.xml.command.internal.Security;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "command")
public class NewCondOrder {
    private String id = "newcondorder";
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
    /** тип условия */
    private String cond_type;
    /** значение условия */
    private String cond_value;
    /** <validafter></validafter> */
    private String validafter;
    /** <validbefore></validbefore> */
    private String validbefore;
    /** <nosplit/> */
    private String nosplit;
    /** <usecredit/> */
    private String usecredit;
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

    public String getCond_type() {
        return cond_type;
    }

    public void setCond_type(String cond_type) {
        this.cond_type = cond_type;
    }

    public String getCond_value() {
        return cond_value;
    }

    public void setCond_value(String cond_value) {
        this.cond_value = cond_value;
    }

    public String getValidafter() {
        return validafter;
    }

    public void setValidafter(String validafter) {
        this.validafter = validafter;
    }

    public String getValidbefore() {
        return validbefore;
    }

    public void setValidbefore(String validbefore) {
        this.validbefore = validbefore;
    }

    public String getNosplit() {
        return nosplit;
    }

    public void setNosplit(String nosplit) {
        this.nosplit = nosplit;
    }

    public String getUsecredit() {
        return usecredit;
    }

    public void setUsecredit(String usecredit) {
        this.usecredit = usecredit;
    }

    public String getExpdate() {
        return expdate;
    }

    public void setExpdate(String expdate) {
        this.expdate = expdate;
    }
}

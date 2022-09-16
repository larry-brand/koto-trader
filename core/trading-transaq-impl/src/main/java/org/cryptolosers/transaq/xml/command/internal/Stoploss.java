package org.cryptolosers.transaq.xml.command.internal;

public class Stoploss {
    /** Цена активации */
    private String activationprice;
    /** Цена заявки */
    private String orderprice;
    /** <bymarket/> , Выставить заявку по рынку, (в этом случае orderprice игнорируется) */
    private String bymarket;
    /** Объем */
    private Long quantity;
    /** <usecredit/> , использование кредита */
    private String usecredit;
    /** Защитное время , (не обязательно) */
    private String guardtime;
    /** Примечание брокера, (не обязательно) */
    private String brokerref;

    public String getActivationprice() {
        return activationprice;
    }

    public void setActivationprice(String activationprice) {
        this.activationprice = activationprice;
    }

    public String getOrderprice() {
        return orderprice;
    }

    public void setOrderprice(String orderprice) {
        this.orderprice = orderprice;
    }

    public String getBymarket() {
        return bymarket;
    }

    public void setBymarket(String bymarket) {
        this.bymarket = bymarket;
    }

    public Long getQuantity() {
        return quantity;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }

    public String getUsecredit() {
        return usecredit;
    }

    public void setUsecredit(String usecredit) {
        this.usecredit = usecredit;
    }

    public String getGuardtime() {
        return guardtime;
    }

    public void setGuardtime(String guardtime) {
        this.guardtime = guardtime;
    }

    public String getBrokerref() {
        return brokerref;
    }

    public void setBrokerref(String brokerref) {
        this.brokerref = brokerref;
    }
}

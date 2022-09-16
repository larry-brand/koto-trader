package org.cryptolosers.transaq.xml.command.internal;

public class Takeprofit {
    /** Цена активации */
    private String activationprice;
    /** Объем */
    private Long quantity;
    /** <usecredit/> , использование кредита */
    private String usecredit;
    /** Защитное время , (не обязательно) */
    private String guardtime;
    /** Примечание брокера, (не обязательно) */
    private String brokerref;
    /** Коррекция */
    private String correction;
    /** Защитный спрэд */
    private String spread;
    /** <bymarket/> , Выставить заявку по рынку, (в этом случае orderprice игнорируется) */
    private String bymarket;

    public String getActivationprice() {
        return activationprice;
    }

    public void setActivationprice(String activationprice) {
        this.activationprice = activationprice;
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

    public String getCorrection() {
        return correction;
    }

    public void setCorrection(String correction) {
        this.correction = correction;
    }

    public String getSpread() {
        return spread;
    }

    public void setSpread(String spread) {
        this.spread = spread;
    }

    public String getBymarket() {
        return bymarket;
    }

    public void setBymarket(String bymarket) {
        this.bymarket = bymarket;
    }
}

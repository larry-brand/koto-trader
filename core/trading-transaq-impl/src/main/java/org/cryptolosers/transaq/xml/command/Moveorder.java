package org.cryptolosers.transaq.xml.command;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "command")
public class Moveorder {
    private String id = "moveorder";
    /** идентификатор заменяемой заявки FORTS */
    private String transactionid;
    private String price;
    /** способ замены */
    private String moveflag;
    /** количество, лот */
    private Long quantity;

    public String getId() {
        return id;
    }

    @XmlAttribute
    public void setId(String id) {
        this.id = id;
    }

    public String getTransactionid() {
        return transactionid;
    }

    public void setTransactionid(String transactionid) {
        this.transactionid = transactionid;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getMoveflag() {
        return moveflag;
    }

    public void setMoveflag(String moveflag) {
        this.moveflag = moveflag;
    }

    public Long getQuantity() {
        return quantity;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }
}

package org.cryptolosers.transaq.xml.misc;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "result")
public class Result {
    private Boolean success;
    private String message;
    private Long transactionid;

    public Boolean getSuccess() {
        return success;
    }

    @XmlAttribute
    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Long getTransactionid() {
        return transactionid;
    }

    @XmlAttribute
    public void setTransactionid(Long transactionid) {
        this.transactionid = transactionid;
    }
}

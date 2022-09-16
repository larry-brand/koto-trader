package org.cryptolosers.transaq.xml.command;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Команда "unsubscribe" , прекратить получение котировок, сделок и глубины рынка (стакана) по
 * одному или нескольким инструментам. */
@XmlRootElement(name = "command")
public class Unsubscribe {
    private String id = "unsubscribe";
    /** подписка на сделки рынка */
    private Subscrube.Alltrades alltrades;
    /** подписка на изменения показателей торгов */
    private Subscrube.Quotations quotations;
    /** подписка на изменения «стакана» */
    private Subscrube.Quotes quotes;

    public String getId() {
        return id;
    }

    @XmlAttribute
    public void setId(String id) {
        this.id = id;
    }

    public Subscrube.Alltrades getAlltrades() {
        return alltrades;
    }

    public void setAlltrades(Subscrube.Alltrades alltrades) {
        this.alltrades = alltrades;
    }

    public Subscrube.Quotations getQuotations() {
        return quotations;
    }

    public void setQuotations(Subscrube.Quotations quotations) {
        this.quotations = quotations;
    }

    public Subscrube.Quotes getQuotes() {
        return quotes;
    }

    public void setQuotes(Subscrube.Quotes quotes) {
        this.quotes = quotes;
    }
}

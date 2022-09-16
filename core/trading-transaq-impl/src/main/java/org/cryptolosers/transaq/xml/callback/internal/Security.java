package org.cryptolosers.transaq.xml.callback.internal;

import javax.xml.bind.annotation.XmlAttribute;
import java.math.BigDecimal;

/**
 * Инструмент
 */
public class Security {
    /** внутренний код */
    private Long secid;
    /** true/false */
    private Boolean active;
    /** Код инструмента */
    private String seccode;
    /** Символ категории (класса) инструмента */
    private String instrclass;
    /** Идентификатор режима торгов по умолчанию */
    private String board;
    /** Идентификатор рынка */
    private String market;
    /** Наименование бумаги */
    private String shortname;
    /** Количество десятичных знаков в цене */
    private Long decimals;
    /** Шаг цены */
    private BigDecimal minstep;
    /** Размер лота */
    private Long lotsize;
    /** Стоимость пункта цены */
    private BigDecimal point_cost;
    // TODO
    //private Opmask opmask;
    /** Тип бумаги */
    private String sectype;
    /** имя таймзоны инструмента (типа "Russian Standard Time", "USA=Eastern Standard Time"), содержит секцию CDATA */
    private String sec_tz;
    /** 0 - без стакана; 1 - стакан типа OrderBook; 2 - стакан типа Level2 */
    private Long quotestype;

    public Long getSecid() {
        return secid;
    }

    @XmlAttribute
    public void setSecid(Long secid) {
        this.secid = secid;
    }

    public Boolean getActive() {
        return active;
    }

    @XmlAttribute
    public void setActive(Boolean active) {
        this.active = active;
    }

    public String getSeccode() {
        return seccode;
    }

    public void setSeccode(String seccode) {
        this.seccode = seccode;
    }

    public String getInstrclass() {
        return instrclass;
    }

    public void setInstrclass(String instrclass) {
        this.instrclass = instrclass;
    }

    public String getBoard() {
        return board;
    }

    public void setBoard(String board) {
        this.board = board;
    }

    public String getMarket() {
        return market;
    }

    public void setMarket(String market) {
        this.market = market;
    }

    public String getShortname() {
        return shortname;
    }

    public void setShortname(String shortname) {
        this.shortname = shortname;
    }

    public Long getDecimals() {
        return decimals;
    }

    public void setDecimals(Long decimals) {
        this.decimals = decimals;
    }

    public BigDecimal getMinstep() {
        return minstep;
    }

    public void setMinstep(BigDecimal minstep) {
        this.minstep = minstep;
    }

    public Long getLotsize() {
        return lotsize;
    }

    public void setLotsize(Long lotsize) {
        this.lotsize = lotsize;
    }

    public BigDecimal getPoint_cost() {
        return point_cost;
    }

    public void setPoint_cost(BigDecimal point_cost) {
        this.point_cost = point_cost;
    }

    public String getSectype() {
        return sectype;
    }

    public void setSectype(String sectype) {
        this.sectype = sectype;
    }

    public String getSec_tz() {
        return sec_tz;
    }

    public void setSec_tz(String sec_tz) {
        this.sec_tz = sec_tz;
    }

    public Long getQuotestype() {
        return quotestype;
    }

    public void setQuotestype(Long quotestype) {
        this.quotestype = quotestype;
    }
}

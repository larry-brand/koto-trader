package org.cryptolosers.transaq.xml.callback.internal;

import java.math.BigDecimal;

public class SecPosition {
    private Long secid;
    private Long market;
    private String seccode;
    private String register;
    private String client;
    private String union;
    private String shortname;
    private Long saldoin;
    private Long saldomin;
    private Long bought;
    private Long sold;
    private Long saldo;
    private Long ordbuy;
    private Long ordsell;
    private BigDecimal amount;
    private BigDecimal equity;

    public Long getSecid() {
        return secid;
    }

    public void setSecid(Long secid) {
        this.secid = secid;
    }

    public Long getMarket() {
        return market;
    }

    public void setMarket(Long market) {
        this.market = market;
    }

    public String getSeccode() {
        return seccode;
    }

    public void setSeccode(String seccode) {
        this.seccode = seccode;
    }

    public String getRegister() {
        return register;
    }

    public void setRegister(String register) {
        this.register = register;
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

    public String getShortname() {
        return shortname;
    }

    public void setShortname(String shortname) {
        this.shortname = shortname;
    }

    public Long getSaldoin() {
        return saldoin;
    }

    public void setSaldoin(Long saldoin) {
        this.saldoin = saldoin;
    }

    public Long getSaldomin() {
        return saldomin;
    }

    public void setSaldomin(Long saldomin) {
        this.saldomin = saldomin;
    }

    public Long getBought() {
        return bought;
    }

    public void setBought(Long bought) {
        this.bought = bought;
    }

    public Long getSold() {
        return sold;
    }

    public void setSold(Long sold) {
        this.sold = sold;
    }

    public Long getSaldo() {
        return saldo;
    }

    public void setSaldo(Long saldo) {
        this.saldo = saldo;
    }

    public Long getOrdbuy() {
        return ordbuy;
    }

    public void setOrdbuy(Long ordbuy) {
        this.ordbuy = ordbuy;
    }

    public Long getOrdsell() {
        return ordsell;
    }

    public void setOrdsell(Long ordsell) {
        this.ordsell = ordsell;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public BigDecimal getEquity() {
        return equity;
    }

    public void setEquity(BigDecimal equity) {
        this.equity = equity;
    }
}

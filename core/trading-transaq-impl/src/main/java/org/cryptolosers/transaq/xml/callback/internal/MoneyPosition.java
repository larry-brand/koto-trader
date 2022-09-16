package org.cryptolosers.transaq.xml.callback.internal;

import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlValue;
import java.math.BigDecimal;
import java.util.List;

public class MoneyPosition {
    private String client;
    private String union;
    private Markets markets;
    private String register;
    private String asset;
    private String shortname;
    private BigDecimal saldoin;
    private BigDecimal bought;
    private BigDecimal sold;
    private BigDecimal saldo;
    private BigDecimal ordbuy;
    private BigDecimal ordbuycond;
    private BigDecimal comission;

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

    public Markets getMarkets() {
        return markets;
    }

    public void setMarkets(Markets markets) {
        this.markets = markets;
    }

    public String getRegister() {
        return register;
    }

    public void setRegister(String register) {
        this.register = register;
    }

    public String getAsset() {
        return asset;
    }

    public void setAsset(String asset) {
        this.asset = asset;
    }

    public String getShortname() {
        return shortname;
    }

    public void setShortname(String shortname) {
        this.shortname = shortname;
    }

    public BigDecimal getSaldoin() {
        return saldoin;
    }

    public void setSaldoin(BigDecimal saldoin) {
        this.saldoin = saldoin;
    }

    public BigDecimal getBought() {
        return bought;
    }

    public void setBought(BigDecimal bought) {
        this.bought = bought;
    }

    public BigDecimal getSold() {
        return sold;
    }

    public void setSold(BigDecimal sold) {
        this.sold = sold;
    }

    public BigDecimal getSaldo() {
        return saldo;
    }

    public void setSaldo(BigDecimal saldo) {
        this.saldo = saldo;
    }

    public BigDecimal getOrdbuy() {
        return ordbuy;
    }

    public void setOrdbuy(BigDecimal ordbuy) {
        this.ordbuy = ordbuy;
    }

    public BigDecimal getOrdbuycond() {
        return ordbuycond;
    }

    public void setOrdbuycond(BigDecimal ordbuycond) {
        this.ordbuycond = ordbuycond;
    }

    public BigDecimal getComission() {
        return comission;
    }

    public void setComission(BigDecimal comission) {
        this.comission = comission;
    }

    @XmlType(name="MoneyPosition.Markets")
    public static class Markets {
        private List<Market> market;

        public List<Market> getMarket() {
            return market;
        }

        public void setMarket(List<Market> market) {
            this.market = market;
        }
    }

    @XmlType(name="MoneyPosition.Market")
    public static class Market {
        private Long market;

        public Long getMarket() {
            return market;
        }

        @XmlValue
        public void setMarket(Long market) {
            this.market = market;
        }
    }
}

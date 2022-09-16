package org.cryptolosers.transaq.xml.callback.internal;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlValue;
import java.math.BigDecimal;
import java.util.List;

@XmlRootElement(name = "forts_position")
public class FortsPosition {
    private Long secid;
    private Markets markets;
    private String seccode;
    private String client;
    private String union;
    private Long startnet;
    private Long openbuys;
    private Long opensells;
    private Long totalnet;
    private Long todaybuy;
    private Long todaysell;
    private BigDecimal optmargin;
    private BigDecimal varmargin;
    private Long expirationpos;
    private BigDecimal usedsellspotlimit;
    private BigDecimal sellspotlimit;
    private BigDecimal netto;
    private BigDecimal kgo;

    public Long getSecid() {
        return secid;
    }

    public void setSecid(Long secid) {
        this.secid = secid;
    }

    public Markets getMarkets() {
        return markets;
    }

    public void setMarkets(Markets markets) {
        this.markets = markets;
    }

    public String getSeccode() {
        return seccode;
    }

    public void setSeccode(String seccode) {
        this.seccode = seccode;
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

    public Long getStartnet() {
        return startnet;
    }

    public void setStartnet(Long startnet) {
        this.startnet = startnet;
    }

    public Long getOpenbuys() {
        return openbuys;
    }

    public void setOpenbuys(Long openbuys) {
        this.openbuys = openbuys;
    }

    public Long getOpensells() {
        return opensells;
    }

    public void setOpensells(Long opensells) {
        this.opensells = opensells;
    }

    public Long getTotalnet() {
        return totalnet;
    }

    public void setTotalnet(Long totalnet) {
        this.totalnet = totalnet;
    }

    public Long getTodaybuy() {
        return todaybuy;
    }

    public void setTodaybuy(Long todaybuy) {
        this.todaybuy = todaybuy;
    }

    public Long getTodaysell() {
        return todaysell;
    }

    public void setTodaysell(Long todaysell) {
        this.todaysell = todaysell;
    }

    public BigDecimal getOptmargin() {
        return optmargin;
    }

    public void setOptmargin(BigDecimal optmargin) {
        this.optmargin = optmargin;
    }

    public BigDecimal getVarmargin() {
        return varmargin;
    }

    public void setVarmargin(BigDecimal varmargin) {
        this.varmargin = varmargin;
    }

    public Long getExpirationpos() {
        return expirationpos;
    }

    public void setExpirationpos(Long expirationpos) {
        this.expirationpos = expirationpos;
    }

    public BigDecimal getUsedsellspotlimit() {
        return usedsellspotlimit;
    }

    public void setUsedsellspotlimit(BigDecimal usedsellspotlimit) {
        this.usedsellspotlimit = usedsellspotlimit;
    }

    public BigDecimal getSellspotlimit() {
        return sellspotlimit;
    }

    public void setSellspotlimit(BigDecimal sellspotlimit) {
        this.sellspotlimit = sellspotlimit;
    }

    public BigDecimal getNetto() {
        return netto;
    }

    public void setNetto(BigDecimal netto) {
        this.netto = netto;
    }

    public BigDecimal getKgo() {
        return kgo;
    }

    public void setKgo(BigDecimal kgo) {
        this.kgo = kgo;
    }

    @XmlType(name="FortsPosition.Markets")
    public static class Markets {
        private List<Market> markets;

        public List<Market> getMarkets() {
            return markets;
        }

        public void setMarkets(List<Market> markets) {
            this.markets = markets;
        }
    }

    @XmlType(name="FortsPosition.Market")
    public static class Market {
        private Long markets;

        public Long getMarkets() {
            return markets;
        }

        @XmlValue
        public void setMarkets(Long markets) {
            this.markets = markets;
        }
    }
}

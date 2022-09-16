package org.cryptolosers.transaq.xml.callback.internal;

import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlValue;
import java.math.BigDecimal;
import java.util.List;

public class FortsMoney {
    private String client;
    private String union;
    private Markets markets;
    private String shortname;
    private BigDecimal current;
    private BigDecimal blocked;
    private BigDecimal free;
    private BigDecimal varmargin;

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

    public String getShortname() {
        return shortname;
    }

    public void setShortname(String shortname) {
        this.shortname = shortname;
    }

    public BigDecimal getCurrent() {
        return current;
    }

    public void setCurrent(BigDecimal current) {
        this.current = current;
    }

    public BigDecimal getBlocked() {
        return blocked;
    }

    public void setBlocked(BigDecimal blocked) {
        this.blocked = blocked;
    }

    public BigDecimal getFree() {
        return free;
    }

    public void setFree(BigDecimal free) {
        this.free = free;
    }

    public BigDecimal getVarmargin() {
        return varmargin;
    }

    public void setVarmargin(BigDecimal varmargin) {
        this.varmargin = varmargin;
    }

    @XmlType(name="FortsMoney.Markets")
    public static class Markets {
        private List<Market> markets;

        public List<Market> getMarkets() {
            return markets;
        }

        public void setMarkets(List<Market> markets) {
            this.markets = markets;
        }
    }

    @XmlType(name="FortsMoney.Market")
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

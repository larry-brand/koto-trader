package org.cryptolosers.transaq.xml.callback;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.math.BigDecimal;
import java.util.List;

@XmlRootElement(name = "portfolio_tplus")
public class PortfolioTplus {
    private String client;
    private BigDecimal coverage_fact;
    private BigDecimal coverage_plan;
    private BigDecimal coverage_crit;
    private BigDecimal open_equity;
    private BigDecimal equity;
    private BigDecimal cover;
    private BigDecimal init_margin;
    private BigDecimal pnl_income;
    private BigDecimal pnl_intraday;
    private BigDecimal leverage;
    private BigDecimal margin_level;
    private List<Security> security;

    public String getClient() {
        return client;
    }

    public void setClient(String client) {
        this.client = client;
    }

    public BigDecimal getCoverage_fact() {
        return coverage_fact;
    }

    public void setCoverage_fact(BigDecimal coverage_fact) {
        this.coverage_fact = coverage_fact;
    }

    public BigDecimal getCoverage_plan() {
        return coverage_plan;
    }

    public void setCoverage_plan(BigDecimal coverage_plan) {
        this.coverage_plan = coverage_plan;
    }

    public BigDecimal getCoverage_crit() {
        return coverage_crit;
    }

    public void setCoverage_crit(BigDecimal coverage_crit) {
        this.coverage_crit = coverage_crit;
    }

    public BigDecimal getOpen_equity() {
        return open_equity;
    }

    public void setOpen_equity(BigDecimal open_equity) {
        this.open_equity = open_equity;
    }

    public BigDecimal getEquity() {
        return equity;
    }

    public void setEquity(BigDecimal equity) {
        this.equity = equity;
    }

    public BigDecimal getCover() {
        return cover;
    }

    public void setCover(BigDecimal cover) {
        this.cover = cover;
    }

    public BigDecimal getInit_margin() {
        return init_margin;
    }

    public void setInit_margin(BigDecimal init_margin) {
        this.init_margin = init_margin;
    }

    public BigDecimal getPnl_income() {
        return pnl_income;
    }

    public void setPnl_income(BigDecimal pnl_income) {
        this.pnl_income = pnl_income;
    }

    public BigDecimal getPnl_intraday() {
        return pnl_intraday;
    }

    public void setPnl_intraday(BigDecimal pnl_intraday) {
        this.pnl_intraday = pnl_intraday;
    }

    public BigDecimal getLeverage() {
        return leverage;
    }

    public void setLeverage(BigDecimal leverage) {
        this.leverage = leverage;
    }

    public BigDecimal getMargin_level() {
        return margin_level;
    }

    public void setMargin_level(BigDecimal margin_level) {
        this.margin_level = margin_level;
    }

    public List<Security> getSecurity() {
        return security;
    }

    public void setSecurity(List<Security> security) {
        this.security = security;
    }

    @XmlType(name="PortfolioTplus.Security")
    public static class Security extends org.cryptolosers.transaq.xml.callback.internal.Security {
        private BigDecimal price;
        //TODO

        public BigDecimal getPrice() {
            return price;
        }

        public void setPrice(BigDecimal price) {
            this.price = price;
        }
    }
}

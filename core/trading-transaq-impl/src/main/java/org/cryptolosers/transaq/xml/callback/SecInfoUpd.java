package org.cryptolosers.transaq.xml.callback;

import javax.xml.bind.annotation.XmlRootElement;
import java.math.BigDecimal;

@XmlRootElement(name = "sec_info_upd")
public class SecInfoUpd {
    private Long secid;
    private Long market;
    private String seccode;
    private BigDecimal minprice;
    private BigDecimal maxprice;
    private BigDecimal buy_deposit;
    private BigDecimal sell_deposit;
    private BigDecimal bgo_c;
    private BigDecimal bgo_nc;
    private BigDecimal bgo_buy;
    private BigDecimal point_cost;

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

    public BigDecimal getMinprice() {
        return minprice;
    }

    public void setMinprice(BigDecimal minprice) {
        this.minprice = minprice;
    }

    public BigDecimal getMaxprice() {
        return maxprice;
    }

    public void setMaxprice(BigDecimal maxprice) {
        this.maxprice = maxprice;
    }

    public BigDecimal getBuy_deposit() {
        return buy_deposit;
    }

    public void setBuy_deposit(BigDecimal buy_deposit) {
        this.buy_deposit = buy_deposit;
    }

    public BigDecimal getSell_deposit() {
        return sell_deposit;
    }

    public void setSell_deposit(BigDecimal sell_deposit) {
        this.sell_deposit = sell_deposit;
    }

    public BigDecimal getBgo_c() {
        return bgo_c;
    }

    public void setBgo_c(BigDecimal bgo_c) {
        this.bgo_c = bgo_c;
    }

    public BigDecimal getBgo_nc() {
        return bgo_nc;
    }

    public void setBgo_nc(BigDecimal bgo_nc) {
        this.bgo_nc = bgo_nc;
    }

    public BigDecimal getBgo_buy() {
        return bgo_buy;
    }

    public void setBgo_buy(BigDecimal bgo_buy) {
        this.bgo_buy = bgo_buy;
    }

    public BigDecimal getPoint_cost() {
        return point_cost;
    }

    public void setPoint_cost(BigDecimal point_cost) {
        this.point_cost = point_cost;
    }
}

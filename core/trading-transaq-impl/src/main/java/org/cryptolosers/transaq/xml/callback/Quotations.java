package org.cryptolosers.transaq.xml.callback;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.math.BigDecimal;

@XmlRootElement(name = "quotations")
public class Quotations {

    private Quotation quotation;

    public Quotation getQuotation() {
        return quotation;
    }

    public void setQuotation(Quotation quotation) {
        this.quotation = quotation;
    }

    @XmlType(name="Quotations.Quotation")
    public static class Quotation {
        private Long secId;
        private String board;
        private String seccode;
        private BigDecimal point_cost;
        private BigDecimal accruedintvalue;
        private BigDecimal open;
        private BigDecimal waprice;
        private Long biddepth;
        private Long biddeptht;
        private Long numbids;
        private Long offerdepth;
        private Long offerdeptht;
        private BigDecimal bid;
        private BigDecimal offer;
        private Long numoffers;
        private Long numtrades;
        private Long voltoday;
        private Long openpositions;
        private Long deltapositions;
        private BigDecimal last;
        private Long quantity;
        private String time;
        private BigDecimal change;
        private BigDecimal priceminusprevwaprice;
        private BigDecimal valtoday;
        private BigDecimal yield;
        private BigDecimal yieldatwaprice;
        private BigDecimal marketpricetoday;
        private BigDecimal highbid;
        private BigDecimal lowoffer;
        private BigDecimal high;
        private BigDecimal low;
        private BigDecimal closeprice;
        private BigDecimal closeyield;
        private String status;
        private String tradingstatus;
        private BigDecimal buydeposit;
        private BigDecimal selldeposit;
        private BigDecimal volatility;
        private BigDecimal theoreticalprice;
        private BigDecimal bgo_buy;
        private BigDecimal lcurrentprice;

        public Long getSecId() {
            return secId;
        }

        @XmlAttribute
        public void setSecId(Long secId) {
            this.secId = secId;
        }

        public String getBoard() {
            return board;
        }

        public void setBoard(String board) {
            this.board = board;
        }

        public String getSeccode() {
            return seccode;
        }

        public void setSeccode(String seccode) {
            this.seccode = seccode;
        }

        public BigDecimal getPoint_cost() {
            return point_cost;
        }

        public void setPoint_cost(BigDecimal point_cost) {
            this.point_cost = point_cost;
        }

        public BigDecimal getAccruedintvalue() {
            return accruedintvalue;
        }

        public void setAccruedintvalue(BigDecimal accruedintvalue) {
            this.accruedintvalue = accruedintvalue;
        }

        public BigDecimal getOpen() {
            return open;
        }

        public void setOpen(BigDecimal open) {
            this.open = open;
        }

        public BigDecimal getWaprice() {
            return waprice;
        }

        public void setWaprice(BigDecimal waprice) {
            this.waprice = waprice;
        }

        public Long getBiddepth() {
            return biddepth;
        }

        public void setBiddepth(Long biddepth) {
            this.biddepth = biddepth;
        }

        public Long getBiddeptht() {
            return biddeptht;
        }

        public void setBiddeptht(Long biddeptht) {
            this.biddeptht = biddeptht;
        }

        public Long getNumbids() {
            return numbids;
        }

        public void setNumbids(Long numbids) {
            this.numbids = numbids;
        }

        public Long getOfferdepth() {
            return offerdepth;
        }

        public void setOfferdepth(Long offerdepth) {
            this.offerdepth = offerdepth;
        }

        public Long getOfferdeptht() {
            return offerdeptht;
        }

        public void setOfferdeptht(Long offerdeptht) {
            this.offerdeptht = offerdeptht;
        }

        public BigDecimal getBid() {
            return bid;
        }

        public void setBid(BigDecimal bid) {
            this.bid = bid;
        }

        public BigDecimal getOffer() {
            return offer;
        }

        public void setOffer(BigDecimal offer) {
            this.offer = offer;
        }

        public Long getNumoffers() {
            return numoffers;
        }

        public void setNumoffers(Long numoffers) {
            this.numoffers = numoffers;
        }

        public Long getNumtrades() {
            return numtrades;
        }

        public void setNumtrades(Long numtrades) {
            this.numtrades = numtrades;
        }

        public Long getVoltoday() {
            return voltoday;
        }

        public void setVoltoday(Long voltoday) {
            this.voltoday = voltoday;
        }

        public Long getOpenpositions() {
            return openpositions;
        }

        public void setOpenpositions(Long openpositions) {
            this.openpositions = openpositions;
        }

        public Long getDeltapositions() {
            return deltapositions;
        }

        public void setDeltapositions(Long deltapositions) {
            this.deltapositions = deltapositions;
        }

        public BigDecimal getLast() {
            return last;
        }

        public void setLast(BigDecimal last) {
            this.last = last;
        }

        public Long getQuantity() {
            return quantity;
        }

        public void setQuantity(Long quantity) {
            this.quantity = quantity;
        }

        public String getTime() {
            return time;
        }

        public void setTime(String time) {
            this.time = time;
        }

        public BigDecimal getChange() {
            return change;
        }

        public void setChange(BigDecimal change) {
            this.change = change;
        }

        public BigDecimal getPriceminusprevwaprice() {
            return priceminusprevwaprice;
        }

        public void setPriceminusprevwaprice(BigDecimal priceminusprevwaprice) {
            this.priceminusprevwaprice = priceminusprevwaprice;
        }

        public BigDecimal getValtoday() {
            return valtoday;
        }

        public void setValtoday(BigDecimal valtoday) {
            this.valtoday = valtoday;
        }

        public BigDecimal getYield() {
            return yield;
        }

        public void setYield(BigDecimal yield) {
            this.yield = yield;
        }

        public BigDecimal getYieldatwaprice() {
            return yieldatwaprice;
        }

        public void setYieldatwaprice(BigDecimal yieldatwaprice) {
            this.yieldatwaprice = yieldatwaprice;
        }

        public BigDecimal getMarketpricetoday() {
            return marketpricetoday;
        }

        public void setMarketpricetoday(BigDecimal marketpricetoday) {
            this.marketpricetoday = marketpricetoday;
        }

        public BigDecimal getHighbid() {
            return highbid;
        }

        public void setHighbid(BigDecimal highbid) {
            this.highbid = highbid;
        }

        public BigDecimal getLowoffer() {
            return lowoffer;
        }

        public void setLowoffer(BigDecimal lowoffer) {
            this.lowoffer = lowoffer;
        }

        public BigDecimal getHigh() {
            return high;
        }

        public void setHigh(BigDecimal high) {
            this.high = high;
        }

        public BigDecimal getLow() {
            return low;
        }

        public void setLow(BigDecimal low) {
            this.low = low;
        }

        public BigDecimal getCloseprice() {
            return closeprice;
        }

        public void setCloseprice(BigDecimal closeprice) {
            this.closeprice = closeprice;
        }

        public BigDecimal getCloseyield() {
            return closeyield;
        }

        public void setCloseyield(BigDecimal closeyield) {
            this.closeyield = closeyield;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public String getTradingstatus() {
            return tradingstatus;
        }

        public void setTradingstatus(String tradingstatus) {
            this.tradingstatus = tradingstatus;
        }

        public BigDecimal getBuydeposit() {
            return buydeposit;
        }

        public void setBuydeposit(BigDecimal buydeposit) {
            this.buydeposit = buydeposit;
        }

        public BigDecimal getSelldeposit() {
            return selldeposit;
        }

        public void setSelldeposit(BigDecimal selldeposit) {
            this.selldeposit = selldeposit;
        }

        public BigDecimal getVolatility() {
            return volatility;
        }

        public void setVolatility(BigDecimal volatility) {
            this.volatility = volatility;
        }

        public BigDecimal getTheoreticalprice() {
            return theoreticalprice;
        }

        public void setTheoreticalprice(BigDecimal theoreticalprice) {
            this.theoreticalprice = theoreticalprice;
        }

        public BigDecimal getBgo_buy() {
            return bgo_buy;
        }

        public void setBgo_buy(BigDecimal bgo_buy) {
            this.bgo_buy = bgo_buy;
        }

        public BigDecimal getLcurrentprice() {
            return lcurrentprice;
        }

        public void setLcurrentprice(BigDecimal lcurrentprice) {
            this.lcurrentprice = lcurrentprice;
        }
    }

}

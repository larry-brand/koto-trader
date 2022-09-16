package org.cryptolosers.transaq.xml.callback;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.math.BigDecimal;
import java.util.List;

@XmlRootElement(name = "quotes")
public class Quotes {
    private List<Quote> quote;

    public List<Quote> getQuote() {
        return quote;
    }

    public void setQuote(List<Quote> quote) {
        this.quote = quote;
    }

    @XmlType(name="Quotes.Quote")
    public static class Quote {
        private Long secid;
        private String board;
        private String seccode;
        private BigDecimal price;
        private String source;
        private Long yield;
        private Long buy;
        private Long sell;

        public Long getSecid() {
            return secid;
        }

        @XmlAttribute
        public void setSecid(Long secid) {
            this.secid = secid;
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

        public BigDecimal getPrice() {
            return price;
        }

        public void setPrice(BigDecimal price) {
            this.price = price;
        }

        public String getSource() {
            return source;
        }

        public void setSource(String source) {
            this.source = source;
        }

        public Long getYield() {
            return yield;
        }

        public void setYield(Long yield) {
            this.yield = yield;
        }

        public Long getBuy() {
            return buy;
        }

        public void setBuy(Long buy) {
            this.buy = buy;
        }

        public Long getSell() {
            return sell;
        }

        public void setSell(Long sell) {
            this.sell = sell;
        }
    }
}

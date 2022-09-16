package org.cryptolosers.transaq.xml.callback.internal;

import javax.xml.bind.annotation.XmlAttribute;
import java.math.BigDecimal;

public class StopOrder {
    private Long transactionid;
    private Long activeorderno;
    private Long secid;
    private String board;
    private String seccode;
    private String client;
    private String buysell;
    private String canceller;
    private Long alltradeno;
    private String validbefore;
    private String author;
    private String accepttime;
    private Long linkedorderno;
    private String expdate;
    private String status;
    private Stoploss stoploss;
    private Takeprofit takeprofit;
    private String withdrawtime;
    private String result;

    public Long getTransactionid() {
        return transactionid;
    }

    @XmlAttribute
    public void setTransactionid(Long transactionid) {
        this.transactionid = transactionid;
    }

    public Long getActiveorderno() {
        return activeorderno;
    }

    public void setActiveorderno(Long activeorderno) {
        this.activeorderno = activeorderno;
    }

    public Long getSecid() {
        return secid;
    }

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

    public String getClient() {
        return client;
    }

    public void setClient(String client) {
        this.client = client;
    }

    public String getBuysell() {
        return buysell;
    }

    public void setBuysell(String buysell) {
        this.buysell = buysell;
    }

    public String getCanceller() {
        return canceller;
    }

    public void setCanceller(String canceller) {
        this.canceller = canceller;
    }

    public Long getAlltradeno() {
        return alltradeno;
    }

    public void setAlltradeno(Long alltradeno) {
        this.alltradeno = alltradeno;
    }

    public String getValidbefore() {
        return validbefore;
    }

    public void setValidbefore(String validbefore) {
        this.validbefore = validbefore;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getAccepttime() {
        return accepttime;
    }

    public void setAccepttime(String accepttime) {
        this.accepttime = accepttime;
    }

    public Long getLinkedorderno() {
        return linkedorderno;
    }

    public void setLinkedorderno(Long linkedorderno) {
        this.linkedorderno = linkedorderno;
    }

    public String getExpdate() {
        return expdate;
    }

    public void setExpdate(String expdate) {
        this.expdate = expdate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Stoploss getStoploss() {
        return stoploss;
    }

    public void setStoploss(Stoploss stoploss) {
        this.stoploss = stoploss;
    }

    public Takeprofit getTakeprofit() {
        return takeprofit;
    }

    public void setTakeprofit(Takeprofit takeprofit) {
        this.takeprofit = takeprofit;
    }

    public String getWithdrawtime() {
        return withdrawtime;
    }

    public void setWithdrawtime(String withdrawtime) {
        this.withdrawtime = withdrawtime;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public static class Stoploss {
        private String usecredit;
        private BigDecimal activationprice;
        private String guardtime;
        private String brokerref;
        /** :integer или :double (в случае %) */
        private String quantity;
        private BigDecimal orderprice;

        public String getUsecredit() {
            return usecredit;
        }

        @XmlAttribute
        public void setUsecredit(String usecredit) {
            this.usecredit = usecredit;
        }

        public BigDecimal getActivationprice() {
            return activationprice;
        }

        public void setActivationprice(BigDecimal activationprice) {
            this.activationprice = activationprice;
        }

        public String getGuardtime() {
            return guardtime;
        }

        public void setGuardtime(String guardtime) {
            this.guardtime = guardtime;
        }

        public String getBrokerref() {
            return brokerref;
        }

        public void setBrokerref(String brokerref) {
            this.brokerref = brokerref;
        }

        public String getQuantity() {
            return quantity;
        }

        public void setQuantity(String quantity) {
            this.quantity = quantity;
        }

        public BigDecimal getOrderprice() {
            return orderprice;
        }

        public void setOrderprice(BigDecimal orderprice) {
            this.orderprice = orderprice;
        }
    }

    public static class Takeprofit {
        private BigDecimal activationprice;
        private String guardtime;
        private String brokerref;
        private String quantity;
        private BigDecimal extremum;
        private BigDecimal level;
        private BigDecimal correction;
        private BigDecimal guardspread;

        public BigDecimal getActivationprice() {
            return activationprice;
        }

        public void setActivationprice(BigDecimal activationprice) {
            this.activationprice = activationprice;
        }

        public String getGuardtime() {
            return guardtime;
        }

        public void setGuardtime(String guardtime) {
            this.guardtime = guardtime;
        }

        public String getBrokerref() {
            return brokerref;
        }

        public void setBrokerref(String brokerref) {
            this.brokerref = brokerref;
        }

        public String getQuantity() {
            return quantity;
        }

        public void setQuantity(String quantity) {
            this.quantity = quantity;
        }

        public BigDecimal getExtremum() {
            return extremum;
        }

        public void setExtremum(BigDecimal extremum) {
            this.extremum = extremum;
        }

        public BigDecimal getLevel() {
            return level;
        }

        public void setLevel(BigDecimal level) {
            this.level = level;
        }

        public BigDecimal getCorrection() {
            return correction;
        }

        public void setCorrection(BigDecimal correction) {
            this.correction = correction;
        }

        public BigDecimal getGuardspread() {
            return guardspread;
        }

        public void setGuardspread(BigDecimal guardspread) {
            this.guardspread = guardspread;
        }
    }
}

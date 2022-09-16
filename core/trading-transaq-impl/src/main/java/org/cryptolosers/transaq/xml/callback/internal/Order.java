package org.cryptolosers.transaq.xml.callback.internal;

import javax.xml.bind.annotation.XmlAttribute;
import java.math.BigDecimal;

public class Order {
    private Long transactionid;
    private Long orderno;
    private Long secid;
    private String board;
    private String seccode;
    private String client;
    private String union;
    private String status;
    private String buysell;
    private String time;
    private String expdate;
    private Long origin_orderno;
    private String accepttime;
    private String brokerref;
    private BigDecimal value;
    private BigDecimal accruedint;
    private String settlecode;
    private Long balance;
    private BigDecimal price;
    private Long quantity;
    private Long hidden;
    private BigDecimal yield;
    private String withdrawtime;
    private String condition;
    private BigDecimal conditionvalue;
    private String validafter;
    private String validbefore;
    private BigDecimal maxcomission;
    private String result;

    public Long getTransactionid() {
        return transactionid;
    }

    @XmlAttribute
    public void setTransactionid(Long transactionid) {
        this.transactionid = transactionid;
    }

    public Long getOrderno() {
        return orderno;
    }

    public void setOrderno(Long orderno) {
        this.orderno = orderno;
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

    public String getUnion() {
        return union;
    }

    public void setUnion(String union) {
        this.union = union;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getBuysell() {
        return buysell;
    }

    public void setBuysell(String buysell) {
        this.buysell = buysell;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getExpdate() {
        return expdate;
    }

    public void setExpdate(String expdate) {
        this.expdate = expdate;
    }

    public Long getOrigin_orderno() {
        return origin_orderno;
    }

    public void setOrigin_orderno(Long origin_orderno) {
        this.origin_orderno = origin_orderno;
    }

    public String getAccepttime() {
        return accepttime;
    }

    public void setAccepttime(String accepttime) {
        this.accepttime = accepttime;
    }

    public String getBrokerref() {
        return brokerref;
    }

    public void setBrokerref(String brokerref) {
        this.brokerref = brokerref;
    }

    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }

    public BigDecimal getAccruedint() {
        return accruedint;
    }

    public void setAccruedint(BigDecimal accruedint) {
        this.accruedint = accruedint;
    }

    public String getSettlecode() {
        return settlecode;
    }

    public void setSettlecode(String settlecode) {
        this.settlecode = settlecode;
    }

    public Long getBalance() {
        return balance;
    }

    public void setBalance(Long balance) {
        this.balance = balance;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Long getQuantity() {
        return quantity;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }

    public Long getHidden() {
        return hidden;
    }

    public void setHidden(Long hidden) {
        this.hidden = hidden;
    }

    public BigDecimal getYield() {
        return yield;
    }

    public void setYield(BigDecimal yield) {
        this.yield = yield;
    }

    public String getWithdrawtime() {
        return withdrawtime;
    }

    public void setWithdrawtime(String withdrawtime) {
        this.withdrawtime = withdrawtime;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public BigDecimal getConditionvalue() {
        return conditionvalue;
    }

    public void setConditionvalue(BigDecimal conditionvalue) {
        this.conditionvalue = conditionvalue;
    }

    public String getValidafter() {
        return validafter;
    }

    public void setValidafter(String validafter) {
        this.validafter = validafter;
    }

    public String getValidbefore() {
        return validbefore;
    }

    public void setValidbefore(String validbefore) {
        this.validbefore = validbefore;
    }

    public BigDecimal getMaxcomission() {
        return maxcomission;
    }

    public void setMaxcomission(BigDecimal maxcomission) {
        this.maxcomission = maxcomission;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }
}

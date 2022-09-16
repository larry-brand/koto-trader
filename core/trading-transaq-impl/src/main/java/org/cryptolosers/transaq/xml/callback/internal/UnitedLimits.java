package org.cryptolosers.transaq.xml.callback.internal;

import javax.xml.bind.annotation.XmlAttribute;
import java.math.BigDecimal;

public class UnitedLimits {
    private String union;
    private BigDecimal open_equity;
    private BigDecimal equity;
    private BigDecimal requirements;
    private BigDecimal free;
    private BigDecimal vm;
    private BigDecimal finres;
    private BigDecimal go;

    public String getUnion() {
        return union;
    }

    @XmlAttribute
    public void setUnion(String union) {
        this.union = union;
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

    public BigDecimal getRequirements() {
        return requirements;
    }

    public void setRequirements(BigDecimal requirements) {
        this.requirements = requirements;
    }

    public BigDecimal getFree() {
        return free;
    }

    public void setFree(BigDecimal free) {
        this.free = free;
    }

    public BigDecimal getVm() {
        return vm;
    }

    public void setVm(BigDecimal vm) {
        this.vm = vm;
    }

    public BigDecimal getFinres() {
        return finres;
    }

    public void setFinres(BigDecimal finres) {
        this.finres = finres;
    }

    public BigDecimal getGo() {
        return go;
    }

    public void setGo(BigDecimal go) {
        this.go = go;
    }
}

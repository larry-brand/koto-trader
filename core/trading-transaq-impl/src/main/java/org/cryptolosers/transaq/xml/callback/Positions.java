package org.cryptolosers.transaq.xml.callback;

import org.cryptolosers.transaq.xml.callback.internal.*;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "positions")
public class Positions {
    private List<MoneyPosition> money_position;
    private List<SecPosition> sec_position;
    private List<FortsPosition> forts_position;
    private List<FortsMoney> forts_money;
    private List<UnitedLimits> united_limits;
    //TODO: etc postion

    public List<MoneyPosition> getMoney_position() {
        return money_position;
    }

    public void setMoney_position(List<MoneyPosition> money_position) {
        this.money_position = money_position;
    }

    public List<SecPosition> getSec_position() {
        return sec_position;
    }

    public void setSec_position(List<SecPosition> sec_position) {
        this.sec_position = sec_position;
    }

    public List<FortsPosition> getForts_position() {
        return forts_position;
    }

    public void setForts_position(List<FortsPosition> forts_position) {
        this.forts_position = forts_position;
    }

    public List<FortsMoney> getForts_money() {
        return forts_money;
    }

    public void setForts_money(List<FortsMoney> forts_money) {
        this.forts_money = forts_money;
    }

    public List<UnitedLimits> getUnited_limits() {
        return united_limits;
    }

    public void setUnited_limits(List<UnitedLimits> united_limits) {
        this.united_limits = united_limits;
    }
}

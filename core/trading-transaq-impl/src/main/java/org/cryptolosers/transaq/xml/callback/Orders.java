package org.cryptolosers.transaq.xml.callback;

import org.cryptolosers.transaq.xml.callback.internal.Order;
import org.cryptolosers.transaq.xml.callback.internal.StopOrder;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "orders")
public class Orders {
    private List<Order> order;
    private List<StopOrder> stoporder;

    public List<Order> getOrder() {
        return order;
    }

    public void setOrder(List<Order> order) {
        this.order = order;
    }

    public List<StopOrder> getStoporder() {
        return stoporder;
    }

    public void setStoporder(List<StopOrder> stoporder) {
        this.stoporder = stoporder;
    }
}

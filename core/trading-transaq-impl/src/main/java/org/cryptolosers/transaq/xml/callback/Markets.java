package org.cryptolosers.transaq.xml.callback;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlValue;
import java.util.List;

@XmlRootElement(name = "markets")
public class Markets {

    private List<Market> market;

    public List<Market> getMarket() {
        return market;
    }

    public void setMarket(List<Market> market) {
        this.market = market;
    }

    @XmlType(name="Markets.Market")
    public static class Market {
        /** внутренний код рынка */
        private Long id;
        /** название рынка */
        private String market;

        public Long getId() {
            return id;
        }

        @XmlAttribute
        public void setId(Long id) {
            this.id = id;
        }

        public String getMarket() {
            return market;
        }

        @XmlValue
        public void setMarket(String market) {
            this.market = market;
        }
    }

}

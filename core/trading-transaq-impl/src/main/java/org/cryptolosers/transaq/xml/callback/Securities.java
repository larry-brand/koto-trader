package org.cryptolosers.transaq.xml.callback;


import org.cryptolosers.transaq.xml.callback.internal.Security;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

/**
 *  Список инструментов
 */
@XmlRootElement(name = "securities")
public class Securities {
    private List<Security> security;

    public List<Security> getSecurity() {
        return security;
    }

    public void setSecurity(List<Security> security) {
        this.security = security;
    }
}

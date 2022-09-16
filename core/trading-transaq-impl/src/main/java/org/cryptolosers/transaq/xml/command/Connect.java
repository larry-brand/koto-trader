package org.cryptolosers.transaq.xml.command;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Команда "connect" , принимаемая коннектором
 */
@XmlRootElement(name = "command")
public class Connect {
    private String id = "connect";
    private String login;
    private String password;
    private String host;
    private String port;
    private String language;
    private Boolean autopos;
    private Boolean micex_registers;
    private Boolean milliseconds;
    private Boolean utc_time;
    private Proxy proxy;
    private Long rqdelay;
    private Long session_timeout;
    private Long request_timeout;
    private Long push_u_limits;
    private Long push_pos_equity;

    public String getId() {
        return id;
    }

    @XmlAttribute
    public void setId(String id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public Boolean getAutopos() {
        return autopos;
    }

    public void setAutopos(Boolean autopos) {
        this.autopos = autopos;
    }

    public Boolean getMicex_registers() {
        return micex_registers;
    }

    public void setMicex_registers(Boolean micex_registers) {
        this.micex_registers = micex_registers;
    }

    public Boolean getMilliseconds() {
        return milliseconds;
    }

    public void setMilliseconds(Boolean milliseconds) {
        this.milliseconds = milliseconds;
    }

    public Boolean getUtc_time() {
        return utc_time;
    }

    public void setUtc_time(Boolean utc_time) {
        this.utc_time = utc_time;
    }

    public Proxy getProxy() {
        return proxy;
    }

    public void setProxy(Proxy proxy) {
        this.proxy = proxy;
    }

    public Long getRqdelay() {
        return rqdelay;
    }

    public void setRqdelay(Long rqdelay) {
        this.rqdelay = rqdelay;
    }

    public Long getSession_timeout() {
        return session_timeout;
    }

    public void setSession_timeout(Long session_timeout) {
        this.session_timeout = session_timeout;
    }

    public Long getRequest_timeout() {
        return request_timeout;
    }

    public void setRequest_timeout(Long request_timeout) {
        this.request_timeout = request_timeout;
    }

    public Long getPush_u_limits() {
        return push_u_limits;
    }

    public void setPush_u_limits(Long push_u_limits) {
        this.push_u_limits = push_u_limits;
    }

    public Long getPush_pos_equity() {
        return push_pos_equity;
    }

    public void setPush_pos_equity(Long push_pos_equity) {
        this.push_pos_equity = push_pos_equity;
    }

    static class Proxy {
        private String type;
        private String addr;
        private String port;
        private String login;
        private String password;

        public String getType() {
            return type;
        }

        @XmlAttribute
        public void setType(String type) {
            this.type = type;
        }

        public String getAddr() {
            return addr;
        }

        @XmlAttribute
        public void setAddr(String addr) {
            this.addr = addr;
        }

        public String getPort() {
            return port;
        }

        @XmlAttribute
        public void setPort(String port) {
            this.port = port;
        }

        public String getLogin() {
            return login;
        }

        @XmlAttribute
        public void setLogin(String login) {
            this.login = login;
        }

        public String getPassword() {
            return password;
        }

        @XmlAttribute
        public void setPassword(String password) {
            this.password = password;
        }
    }
}

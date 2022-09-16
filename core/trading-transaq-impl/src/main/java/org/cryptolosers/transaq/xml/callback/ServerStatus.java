package org.cryptolosers.transaq.xml.callback;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "server_status")
public class ServerStatus {
    /** "ID сервера */
    private Long id;
    /** true/false/error */
    private String connected;
    /** true/атрибут отсутствует , необязательный параметр */
    private String recover;
    /** имя таймзоны сервера */
    private String server_tz;

    public Long getId() {
        return id;
    }

    @XmlAttribute
    public void setId(Long id) {
        this.id = id;
    }

    public String getConnected() {
        return connected;
    }

    @XmlAttribute
    public void setConnected(String connected) {
        this.connected = connected;
    }

    public String getRecover() {
        return recover;
    }

    @XmlAttribute
    public void setRecover(String recover) {
        this.recover = recover;
    }

    public String getServer_tz() {
        return server_tz;
    }

    @XmlAttribute
    public void setServer_tz(String server_tz) {
        this.server_tz = server_tz;
    }

    @Override
    public String toString() {
        return "ServerStatus{" +
                "id=" + id +
                ", connected='" + connected + '\'' +
                ", recover='" + recover + '\'' +
                ", server_tz='" + server_tz + '\'' +
                '}';
    }
}

package org.cryptolosers.transaq.xml.callback;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "boards")
public class Boards {
    private List<Board> board;

    public List<Board> getBoard() {
        return board;
    }

    public void setBoard(List<Board> board) {
        this.board = board;
    }

    public static class Board {
        private String id;
        private String name;
        private Long market;
        private Long type;

        public String getId() {
            return id;
        }

        @XmlAttribute
        public void setId(String id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Long getMarket() {
            return market;
        }

        public void setMarket(Long market) {
            this.market = market;
        }

        public Long getType() {
            return type;
        }

        public void setType(Long type) {
            this.type = type;
        }
    }
}
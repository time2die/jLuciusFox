package org.time2die.LuciusFox.dao;

/**
 * @author Aleksandr Karpov AV.Karpov@bssys.com
 */
public class RawMessage extends RawTextEntity {

    private Long tId ;

    public RawMessage(String text) {
        super(text);
    }

    public RawMessage(String text, Long tId) {
        super(text);
        this.tId = tId;
    }

    public Long gettId() {
        return tId;
    }

    public void settId(Long tId) {
        this.tId = tId;
    }

    @Override
    public String toString() {
        return "RawMessage[" +
                "tId=" + tId +
                ']' + super.toString() ;
    }
}
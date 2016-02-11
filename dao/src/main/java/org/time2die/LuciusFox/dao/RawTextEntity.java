package org.time2die.LuciusFox.dao;

/**
 * @author Aleksandr Karpov AV.Karpov@bssys.com
 */


public class RawTextEntity {
    private long id ;

    private String text ;

    public RawTextEntity(String text) {
        this.text = text;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "RawTextEntity[" + "id=" + id + ", text='" + text + '\'' + ']';
    }
}
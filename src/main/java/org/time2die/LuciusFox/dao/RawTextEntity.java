package org.time2die.LuciusFox.dao;

import javax.persistence.Entity;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @author Aleksandr Karpov AV.Karpov@bssys.com
 */

@Entity
public class RawTextEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
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
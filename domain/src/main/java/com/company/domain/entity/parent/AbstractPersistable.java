package com.company.domain.entity.parent;

import org.springframework.data.domain.Persistable;
import org.springframework.util.ClassUtils;

import javax.persistence.*;
import java.io.Serializable;

@MappedSuperclass
public class AbstractPersistable<PK extends Serializable>
        implements Persistable<PK> {

    private static final long serialVersionUID = 229471878283470265L;

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
//    @GenericGenerator(name="gen",strategy="increment")
//    @GeneratedValue(generator="gen")
    private PK id;

    public AbstractPersistable() {
    }

    public PK getId() {
        return this.id;
    }

    protected void setId(PK id) {
        this.id = id;
    }

    @Transient
    public boolean isNew() {
        return null == this.getId();
    }

    public String toString() {
        return String.format("Entity of type %s with id: %s", this.getClass().getName(), this.getId());
    }

    public boolean equals(Object obj) {
        if (null == obj) {
            return false;
        } else if (this == obj) {
            return true;
        } else if (!this.getClass().equals(ClassUtils.getUserClass(obj))) {
            return false;
        } else {
            org.springframework.data.jpa.domain.AbstractPersistable<?> that = (org.springframework.data.jpa.domain.AbstractPersistable)obj;
            return null == this.getId() ? false : this.getId().equals(that.getId());
        }
    }

    public int hashCode() {
        int hashCode = 17;
        hashCode = hashCode + (null == this.getId() ? 0 : this.getId().hashCode() * 31);
        return hashCode;
    }
}

package com.company.domain.entity.parent;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.domain.Persistable;
import org.springframework.util.ClassUtils;

import javax.persistence.*;
import java.io.Serializable;

@MappedSuperclass
public abstract class AbstractPersistableGenerationUUID<PK extends Serializable>
        implements Persistable<PK> {
    private static final long serialVersionUID = 4850642056072900789L;

    @Id
    @GeneratedValue(generator = "uuid", strategy = GenerationType.AUTO)
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @Column(name = "id")
    private PK id;

    @Version
    private Long version;

    public AbstractPersistableGenerationUUID() {
    }

    @Override
    public PK getId() {
        return this.id;
    }

    public void setId(PK pk) {
        this.id = pk;
    }

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

    @Transient
    public boolean isNew() {
        return null == this.getId();
    }

    public boolean equals(Object obj) {
        if (null == obj) {
            return false;
        } else if (this == obj) {
            return true;
        } else if (!this.getClass().equals(ClassUtils.getUserClass(obj))) {
            return false;
        } else {
            try {
                AbstractPersistableGenerationUUID<PK> that = (AbstractPersistableGenerationUUID<PK>) obj;
                return null != this.getId() && this.getId().equals(that.getId());
            } catch (ClassCastException e) {
                return false;
            }
        }
    }

    public int hashCode() {
        byte hashCode = 17;
        return hashCode + (null == this.getId() ? 0 : this.getId().hashCode() * 31);
    }

    public String toString() {
        return String.format("Entity of type %s with id: %s", this.getClass().getName(), this.getId());
    }
}
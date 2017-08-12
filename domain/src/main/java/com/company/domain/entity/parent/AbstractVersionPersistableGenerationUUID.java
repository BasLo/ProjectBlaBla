package com.company.domain.entity.parent;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;
import org.springframework.data.domain.Persistable;
import org.springframework.util.ClassUtils;

import javax.persistence.*;
import java.util.UUID;

@MappedSuperclass
public abstract class AbstractVersionPersistableGenerationUUID
        implements Persistable<UUID> {
    private static final long serialVersionUID = 4850642056072900789L;

    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "id", columnDefinition = "BINARY(16)")
    @Type(type = "org.hibernate.type.UUIDBinaryType")
    @Id
    private UUID id;

    @Version
    private Long version;

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }
    @Override
    public UUID getId() {
        return this.id;
    }

    public void setId(UUID pk) {
        this.id = pk;
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
                AbstractVersionPersistableGenerationUUID that = (AbstractVersionPersistableGenerationUUID) obj;
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
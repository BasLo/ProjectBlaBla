package com.company.domain.entity.parent;

import javax.persistence.MappedSuperclass;
import javax.persistence.Version;
import java.io.Serializable;

@MappedSuperclass
public abstract class AbstractVersionPersistable <PK extends Serializable>
        extends AbstractPersistable<PK>{

    private static final long serialVersionUID = -3139560999205965068L;

    @Version
    private Long version;

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }
}
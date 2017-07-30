package com.company.domain.entity;

import com.company.domain.entity.parent.AbstractPersistableGenerationUUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity(name = "comment")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Comment
        extends AbstractPersistableGenerationUUID<String> {
    private static final long serialVersionUID = 2552394031961457052L;

    @Column(name = "body")
    private String body;

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

}

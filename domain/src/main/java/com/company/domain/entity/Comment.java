package com.company.domain.entity;

import com.company.domain.entity.parent.AbstractVersionPersistableGenerationUUID;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity(name = "comment")
public class Comment
        extends AbstractVersionPersistableGenerationUUID {

    private static final long serialVersionUID = 2552394031961457052L;

    @Column(name = "body")
    private String body;

    public Comment(){}

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

}
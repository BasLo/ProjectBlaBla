package com.company.domain.entity;

import com.company.domain.entity.parent.AbstractVersionPersistable;
import com.company.domain.entity.role.Role;

import javax.persistence.*;
import java.util.Collection;

@Entity(name = "privilege")
public class Privilege
        extends AbstractVersionPersistable<Long>{

    @Column(name = "name")
    private String name;

    @ManyToMany(mappedBy = "role", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Collection<Role> roles ;

    public Privilege(){
        super();
    }

    public Privilege(String name){
        super();
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Collection<Role> getRoles() {
        return roles;
    }

    public void setRoles(Collection<Role> roles) {
        this.roles = roles;
    }
}
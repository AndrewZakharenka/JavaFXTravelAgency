package com.dao.entity;

import javax.persistence.*;

@MappedSuperclass
public abstract class Entity implements IEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    protected long id;

    public Entity() {
    }

    public Entity(long id) {
        this.id = id;
    }

    @Override
    public long getId() {
        return id;
    }

    @Override
    public void setID(long id) {
        this.id = id;
    }
}

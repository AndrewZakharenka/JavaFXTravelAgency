package com.service.dto;

public abstract class EntityDTO {
    protected long id;

    public EntityDTO(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}

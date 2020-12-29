package com.service.dto.roles;

import com.service.dto.EntityDTO;

public class RoleDTO extends EntityDTO {
    private String name;

    public RoleDTO(long id, String name) {
        super(id);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

package com.tomasbozzo.hea.infrastructure.adapter.repository.jpa.model;

import org.springframework.data.annotation.Transient;
import org.springframework.data.domain.Persistable;

public abstract class AbstractJpaEntity implements Persistable<String> {

    @Transient
    private boolean newEntity;

    public void setAsNew() {
        newEntity = true;
    }

    @Override
    public boolean isNew() {
        return newEntity;
    }
}

package com.tomasbozzo.hea.infrastructure.adapter.repository.jpa.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@EqualsAndHashCode(callSuper = false)
@Entity
@Table(name = "things")
public class ThingJpaEntity extends AbstractJpaEntity {
    @Id
    @Column(name = "thing_id")
    private String id;

    @Column(name = "thing_name")
    private String name;
}


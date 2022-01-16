package com.tomasbozzo.hea.infrastructure.adapter.repository.jpa.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Data
@EqualsAndHashCode(callSuper = false)
@Table("things")
public class ThingJpaEntity extends AbstractJpaEntity {
    @Id
    @Column("thing_id")
    private String id;

    @Column("thing_name")
    private String name;
}


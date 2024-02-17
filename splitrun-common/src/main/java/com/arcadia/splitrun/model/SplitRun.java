package com.arcadia.splitrun.model;


import jakarta.persistence.*;
import lombok.Data;

import java.math.BigInteger;
import java.sql.Timestamp;
import java.time.Instant;

@Data
@Entity
@Table(name = "split_run", schema = "reports")
public class SplitRun {

    @Id
    @SequenceGenerator(name = "split_run_id_seq", sequenceName = "split_run_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "split_run_id_seq")
    @Column(columnDefinition = "serial")
    BigInteger id;

    String name;

    String customerId;

    Timestamp createdAt;
    String createdBy;

    Timestamp updatedAt;
    String updatedBy;

    @PrePersist
    void setCreatedAt(){
        createdAt = Timestamp.from(Instant.now());
    }

    @PreUpdate
    void setUpdatedAt(){
        updatedAt = Timestamp.from(Instant.now());
    }
}

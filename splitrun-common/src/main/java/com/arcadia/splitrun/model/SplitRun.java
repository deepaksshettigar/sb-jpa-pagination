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
    private BigInteger id;

    private String name;

    private String customerId;

    private Timestamp createdAt;
    private String createdBy;

    private Timestamp updatedAt;
    private String updatedBy;

    private Timestamp deletedAt;
    private String deletedBy;

    @PrePersist
    public void setCreatedAt(SplitRun sr){
        createdAt = (Timestamp.from(Instant.now()));
    }

    @PreUpdate
    public void setUpdatedAt(){
        updatedAt = Timestamp.from(Instant.now());
    }

}

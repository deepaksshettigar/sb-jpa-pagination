package com.arcadia.splitrun.model;


import jakarta.persistence.*;
import jakarta.persistence.Table;
import lombok.Data;
import org.hibernate.Remove;
import org.hibernate.annotations.*;

import java.math.BigInteger;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.BitSet;

@Data
@Entity
@SQLDelete(sql = "UPDATE reports.split_run SET is_active = false, deleted_at = NOW() WHERE id = ?")
@SQLRestriction(value = "is_active = true")
@Table(name = "split_run", schema = "reports")
public class SplitRun {

    @Id
    @SequenceGenerator(name = "split_run_id_seq", sequenceName = "split_run_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "split_run_id_seq")
    @Column(columnDefinition = "serial")
    private BigInteger id;

    private String name;
    private String dashboardId;

    private String customerId;

    private boolean isActive = Boolean.TRUE;

    @CreationTimestamp
    private Timestamp createdAt;
    private String createdBy;

    @UpdateTimestamp
    private Timestamp updatedAt;
    private String updatedBy;

    private Timestamp deletedAt;
    private String deletedBy;

}

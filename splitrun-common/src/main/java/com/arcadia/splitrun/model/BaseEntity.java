package com.arcadia.splitrun.model;

import jakarta.annotation.PreDestroy;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigInteger;
import java.sql.Timestamp;
@Data
@MappedSuperclass
public abstract class BaseEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private BigInteger id;

  @Column(nullable = false)
  private String userId = "system";

  @Column(nullable = false) private String customerId = "system";

  @Column(nullable = false)
  private boolean isActive = Boolean.TRUE;

  @CreationTimestamp
  @Column(nullable = false) private Timestamp createdAt;
  @Column(nullable = false) private String createdBy = "system";

  @UpdateTimestamp
  @Column(nullable = false) private Timestamp updatedAt;
  @Column(nullable = false) private String updatedBy = "system";

  @Column(nullable = true) private Timestamp deletedAt;
  @Column(nullable = true) private String deletedBy;

  @PreRemove
  @PreUpdate
  void updateOnDelete() {
    this.deletedBy = this.userId;
  }

}


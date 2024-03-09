package com.arcadia.splitrun.model;

import com.arcadia.splitrun.util.JsonNodeConverter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.JsonNode;
import jakarta.persistence.*;
import org.hibernate.annotations.ColumnTransformer;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.SQLRestriction;


import java.sql.Timestamp;


@Entity
@SQLDelete(sql = "UPDATE split_run_bursts srb SET deleted_at = NOW(), deleted_by = (SELECT user_id FROM split_run_bursts WHERE id = srb.id) WHERE id = ?")
@SQLRestriction(value = " deleted_at IS NULL")
@Table(name = "split_run_bursts")
public class SplitRunBurst extends AuditAttributes {

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "split_run_id", nullable = false)
  @JsonIgnore
  private SplitRun splitRun;

  @Column(nullable = false)
  private Integer burstNumber;

  @ColumnTransformer(write = "?::jsonb")
  @Convert(converter = JsonNodeConverter.class)
  @Column(columnDefinition = "jsonb", nullable = false)
  private JsonNode jsonConfig;

  @Column(nullable = true)
  private String dashboardName;

  @Column(nullable = true)
  private String storageFolder;

  @Column(nullable = true)
  private String executedBy;

  @Column(nullable = true)
  private Timestamp executedAt;

  // Setter Getters
  public SplitRun getSplitRun() {
    return splitRun;
  }

  public void setSplitRun(SplitRun splitRun) {
    this.splitRun = splitRun;
  }

  public Integer getBurstNumber() {
    return burstNumber;
  }

  public void setBurstNumber(Integer burstNumber) {
    this.burstNumber = burstNumber;
  }

  public JsonNode getJsonConfig() {
    return jsonConfig;
  }

  public void setJsonConfig(JsonNode jsonConfig) {
    this.jsonConfig = jsonConfig;
  }

  public String getDashboardName() {
    return dashboardName;
  }

  public void setDashboardName(String dashboardName) {
    this.dashboardName = dashboardName;
  }

  public String getStorageFolder() {
    return storageFolder;
  }

  public void setStorageFolder(String storageFolder) {
    this.storageFolder = storageFolder;
  }

  public String getExecutedBy() {
    return executedBy;
  }

  public void setExecutedBy(String executedBy) {
    this.executedBy = executedBy;
  }

  public Timestamp getExecutedAt() {
    return executedAt;
  }

  public void setExecutedAt(Timestamp executedAt) {
    this.executedAt = executedAt;
  }

}

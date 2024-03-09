package com.arcadia.splitrun.model;


import jakarta.persistence.*;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Table;
import org.hibernate.annotations.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@SQLDelete(sql = "UPDATE split_runs sr SET deleted_at = NOW(), deleted_by = (SELECT user_id FROM split_runs WHERE id = sr.id) WHERE id = ?;")
@SQLRestriction(value = "deleted_at IS NULL")
@Table(name = "split_runs")
public class SplitRun extends AuditAttributes {

  @Column(nullable = false)
  private String name;

  @OneToMany(mappedBy = "splitRun", cascade = CascadeType.ALL)
  private List<SplitRunBurst> splitRunBursts = new ArrayList<>();

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public List<SplitRunBurst> getSplitRunBursts() {
    return splitRunBursts;
  }

  public void setSplitRunBursts(List<SplitRunBurst> splitRunBursts) {
    this.splitRunBursts = splitRunBursts;
  }
}

package com.arcadia.splitrun.model;


import jakarta.persistence.*;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.*;
import org.springframework.lang.NonNull;

import java.math.BigInteger;
import java.sql.Timestamp;

@Data
@EqualsAndHashCode(callSuper=false)
@Entity
@SQLDelete(sql = "UPDATE split_run sr SET is_active = false, deleted_at = NOW(), deleted_by = (SELECT user_id FROM split_run WHERE id = sr.id) WHERE id = ?")
@SQLRestriction(value = "is_active = true")
@Table(name = "split_run")
public class SplitRuns extends BaseEntity{

    private String name;

}

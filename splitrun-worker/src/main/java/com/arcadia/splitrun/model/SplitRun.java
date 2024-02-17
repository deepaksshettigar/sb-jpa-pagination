package com.arcadia.splitrun.model;


import com.arcadia.splitrun.listener.SplitRunJobListener;
import jakarta.persistence.*;
import lombok.Data;

import java.math.BigInteger;

@Entity
@EntityListeners(value = {SplitRunJobListener.class})
@Data
@Table(name = "split_run", schema = "reports")
public class SplitRun {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(columnDefinition = "serial")
    BigInteger id;

    String name;
}

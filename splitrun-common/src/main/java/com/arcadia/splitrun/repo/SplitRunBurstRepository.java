package com.arcadia.splitrun.repo;

import com.arcadia.splitrun.model.SplitRunBurst;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.math.BigInteger;

public interface SplitRunBurstRepository extends JpaRepository<SplitRunBurst, BigInteger> {

  @Query(value = "SELECT coalesce(MAX(srb.burst_number), null, 0) FROM public.split_run_bursts srb WHERE split_run_id = ?", nativeQuery = true)
  Integer findMaxBurstNumBySplitRunId(BigInteger splitRunId);
}

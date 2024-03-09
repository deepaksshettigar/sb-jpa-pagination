package com.arcadia.splitrun.model;

import com.arcadia.splitrun.repo.SplitRunBurstRepository;
import jakarta.persistence.PostPersist;

public class SplitRunBurstListener {

  private SplitRunBurstRepository splitRunBurstRepository;
  public SplitRunBurstListener(SplitRunBurstRepository splitRunBurstRepository) {
    this.splitRunBurstRepository = splitRunBurstRepository;
  }

  @PostPersist
  void onPostPersist(SplitRunBurst splitRunBurst) {
    Integer lastBurstNumber = splitRunBurstRepository.findMaxBurstNumBySplitRunId(splitRunBurst.getSplitRun().getId());
    splitRunBurst.setBurstNumber(Integer.sum(lastBurstNumber , 1));
  }
}

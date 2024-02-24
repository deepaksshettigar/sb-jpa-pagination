package com.arcadia.splitrun.service;

import com.arcadia.splitrun.model.SplitRun;
import com.arcadia.splitrun.repo.SplitRunRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class SplitRunService {

  private SplitRunRepository splitRunRepository;

  public SplitRunService(SplitRunRepository splitRunRepository) {
    this.splitRunRepository = splitRunRepository;
  }

  public Page<SplitRun> findAll(Pageable pageable, String searchTerm){
    return splitRunRepository.findByNameOrDashboardIdIgnoreCaseContaining(searchTerm, searchTerm, pageable);
  }

}

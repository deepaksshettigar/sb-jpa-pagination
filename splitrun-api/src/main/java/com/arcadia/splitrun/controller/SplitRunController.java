package com.arcadia.splitrun.controller;


import com.arcadia.splitrun.model.SplitRun;
import com.arcadia.splitrun.service.SplitRunService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.data.web.SortDefault;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/splitruns")
public class SplitRunController {

  private SplitRunService splitRunService;

  public SplitRunController(SplitRunService splitRunService) {
    this.splitRunService = splitRunService;
  }

  @GetMapping
  public ResponseEntity<Page<SplitRun>> findAll(@SortDefault(sort = "createdAt", direction = Sort.Direction.DESC) @PageableDefault(size = 10, page = 0) final Pageable pageable, @RequestParam(name = "search", required = false, defaultValue = "") String searchTerm) {
    return ResponseEntity.ok(splitRunService.findAll(pageable, searchTerm));
  }

}

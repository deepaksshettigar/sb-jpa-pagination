package com.arcadia.splitrun.data;

import com.arcadia.splitrun.model.SplitRun;
import com.arcadia.splitrun.model.SplitRunBurst;
import com.arcadia.splitrun.repo.SplitRunRepository;
import lombok.extern.slf4j.Slf4j;
import org.apache.logging.log4j.util.Strings;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.IntStream;

@Configuration
@Slf4j
public class SplitRunDataMock {

    SplitRunRepository splitRunRepository;

    SplitRunDataMock(SplitRunRepository repository) {
        this.splitRunRepository = repository;
    }

    @Bean
    public String setupMockData() {
        splitRunRepository.deleteAll();
      List<SplitRun> splitRuns = new ArrayList<>();
      List<SplitRunBurst> splitRunBursts = new ArrayList<>();

      IntStream.iterate(1, i -> ++i)
        .limit(1)
        .forEach(j -> {
          SplitRun splitRun = new SplitRun();
          splitRun.setName("Mock Name " + j);
          splitRunRepository.save(splitRun);

          // Setup Bursts data
          IntStream.iterate(1, k -> ++k)
            .limit(5)
            .forEach(l -> {
              SplitRunBurst splitRunBurst = new SplitRunBurst();
              splitRunBurst.setBurstNumber(l);
              UUID dashboardId = UUID.randomUUID();
              splitRunBurst.setJsonConfig("{\"dashboardId\": \""+ dashboardId.toString()+"\"}");
              splitRunBurst.setSplitRun(splitRun);
              splitRunBursts.add(splitRunBurst);
            });
          splitRun.setSplitRunBursts(splitRunBursts);
          // Add Bursts
          splitRuns.add(splitRun);
        });

      splitRunRepository.saveAll(splitRuns);

      Pageable pagination = PageRequest.of(0, 10);

      String searchTerm = "Name";
      Page<SplitRun> results = splitRunRepository.findByNameIgnoreCaseContaining(searchTerm, pagination);
      results.forEach(sr ->
          log.debug("Retrieved mock data: {} - {}", sr.getId(), sr.getName())
      );

      return Strings.EMPTY;
    }

}

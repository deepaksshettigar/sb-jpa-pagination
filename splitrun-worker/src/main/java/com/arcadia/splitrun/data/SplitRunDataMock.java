package com.arcadia.splitrun.data;

import com.arcadia.splitrun.model.SplitRun;
import com.arcadia.splitrun.repo.SplitRunRepository;
import lombok.extern.slf4j.Slf4j;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@Slf4j
public class SplitRunDataMock {

    @Autowired
    SplitRunRepository repository;

    @Bean
    public String setupMockData() {
        repository.deleteAll();

        SplitRun sr = new SplitRun();
        sr.setName("Mock Name 1");
        repository.save(sr);

        log.debug("Saved mock data");

        return Strings.EMPTY;
    }

}

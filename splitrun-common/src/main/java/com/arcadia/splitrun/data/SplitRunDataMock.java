package com.arcadia.splitrun.data;

import com.arcadia.splitrun.model.SplitRun;
import com.arcadia.splitrun.repo.SplitRunRepository;
import lombok.extern.slf4j.Slf4j;
import org.apache.logging.log4j.util.Strings;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

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

        SplitRun sr1 = new SplitRun();
        sr1.setName("Name Some mock 0" );
        splitRunRepository.save(sr1);

        SplitRun sr2 = new SplitRun();
        sr2.setName("Name Some mock 1" );
        splitRunRepository.save(sr2);

        IntStream.iterate(1, i -> ++i)
            .limit(20)
            .forEach(j -> {
                SplitRun sr = new SplitRun();
                sr.setName("Mock Name " + j);
                splitRunRepository.save(sr);
            });

        Pageable pagination = PageRequest.of(0, 10);
        Page<SplitRun> results = splitRunRepository.findByNameIgnoreCaseContaining("Mock", pagination);
        results.forEach(sr -> 
            log.debug("Retrieved mock data: {} - {}", sr.getId(), sr.getName())
        );

        return Strings.EMPTY;
    }

}

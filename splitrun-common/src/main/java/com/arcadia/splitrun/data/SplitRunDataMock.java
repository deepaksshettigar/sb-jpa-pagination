package com.arcadia.splitrun.data;

import com.arcadia.splitrun.model.SplitRuns;
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

        SplitRuns sr1 = new SplitRuns();
        sr1.setName("Some mock NM 0" );
        splitRunRepository.save(sr1);

        IntStream.iterate(1, i -> ++i)
            .limit(20)
            .forEach(j -> {
                SplitRuns sr = new SplitRuns();
                sr.setName("Mock Name " + j);
                splitRunRepository.save(sr);
            });

        Pageable pagination = PageRequest.of(0, 10);

        String searchTerm = "name";
        Page<SplitRuns> results = splitRunRepository.findByNameIgnoreCaseContaining(searchTerm, pagination);
        results.forEach(sr -> 
            log.debug("Retrieved mock data: {} - {}", sr.getId(), sr.getName())
        );

        return Strings.EMPTY;
    }

}

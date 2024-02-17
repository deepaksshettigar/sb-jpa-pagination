package com.arcadia.splitrun.repo;

import com.arcadia.splitrun.model.SplitRun;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.math.BigInteger;

public interface SplitRunRepository extends PagingAndSortingRepository<SplitRun, BigInteger>, CrudRepository<SplitRun, BigInteger> {
    Page<SplitRun> findByNameIgnoreCaseContaining(String name, Pageable pageable);

}

package com.arcadia.splitrun.repo;

import com.arcadia.splitrun.model.SplitRuns;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigInteger;

public interface SplitRunRepository extends JpaRepository<SplitRuns, BigInteger> {
    Page<SplitRuns> findByNameIgnoreCaseContaining(String name, Pageable pageable);

}

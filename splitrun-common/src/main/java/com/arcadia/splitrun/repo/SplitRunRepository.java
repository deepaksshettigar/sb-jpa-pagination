package com.arcadia.splitrun.repo;

import com.arcadia.splitrun.model.SplitRun;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigInteger;

public interface SplitRunRepository extends JpaRepository<SplitRun, BigInteger> {
    Page<SplitRun> findByNameOrDashboardIdIgnoreCaseContaining(String name, String dashboardId,Pageable pageable);

}

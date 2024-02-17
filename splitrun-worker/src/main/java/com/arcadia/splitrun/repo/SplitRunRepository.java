package com.arcadia.splitrun.repo;

import com.arcadia.splitrun.model.SplitRun;
import org.springframework.data.repository.CrudRepository;

import java.math.BigInteger;

public interface SplitRunRepository extends CrudRepository<SplitRun, BigInteger> {
}

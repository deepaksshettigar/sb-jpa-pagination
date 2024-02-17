package com.arcadia.splitrun.listener;

import com.arcadia.splitrun.model.SplitRun;
import jakarta.persistence.*;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SplitRunJobListener {

    @PrePersist
    @PreUpdate
    @PreRemove
    private void beforeAnyUpdate(SplitRun sr) {
        if (sr.getId().equals(0)) {
            log.info("[AUDIT] About to add");
        } else {
            log.info("[AUDIT] About to update/delete: " + sr.getId());
        }
    }

    @PostPersist
    @PostUpdate
    @PostRemove
    private void afterAnyUpdate(SplitRun sr) {
        log.info("[AUDIT] add/update/delete complete: " + sr.getId());
    }

    @PostLoad
    private void afterLoad(SplitRun sr) {
        log.info("[AUDIT] user loaded from database: " + sr.getId());
    }
}
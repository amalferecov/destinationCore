package com.crag.destinationCore.db.repo.interval;

import com.crag.destinationCore.db.domains.GroupLogs;
import org.springframework.data.jpa.repository.JpaRepository;

import java.io.Serializable;

/**
 * Created by heisenberg on 7/9/18.
 */
public interface GroupLogsRepo<T, ID extends Serializable> extends JpaRepository<GroupLogs,Integer> {
}

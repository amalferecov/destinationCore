package com.crag.destinationCore.db.repo.interval;

import com.crag.destinationCore.db.domains.Group1;
import org.springframework.data.jpa.repository.JpaRepository;

import java.io.Serializable;

/**
 * Created by heisenberg on 7/9/18.
 */
public interface GroupsRepo<T, ID extends Serializable> extends JpaRepository<Group1,Integer> {
}

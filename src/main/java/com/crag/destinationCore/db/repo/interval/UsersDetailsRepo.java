package com.crag.destinationCore.db.repo.interval;

import com.crag.destinationCore.db.domains.UsersDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

/**
 * Created by heisenberg on 7/9/18.
 */
@Repository
public interface UsersDetailsRepo<T, ID extends Serializable> extends JpaRepository<UsersDetails,Integer>{

    UsersDetails findUsersDetailsByNickNameAndPassword(String Nickname,String Password);

}

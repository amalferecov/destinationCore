package com.crag.destinationCore.db;

import com.crag.destinationCore.db.repo.RepoServiceType;
import com.crag.destinationCore.db.repo.interval.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

/**
 * Created by heisenberg on 7/9/18.
 */
@Component
public class RepoService {
    @Autowired
    GroupDetailsRepo groupDetailsRepo;
    @Autowired
    GroupLogsRepo groupLogsRepo;
    @Autowired
    GroupsRepo groupsRepo;
    @Autowired
    GroupsUsersRepo groupsUsersRepo;
    @Autowired
    UsersDetailsRepo usersDetailsRepo;

    public JpaRepository getRepo(RepoServiceType type){
        switch (type){
            case GROUP: return groupsRepo;
            case GROUP_LOGS: return  groupLogsRepo;
            case GROUP_USERS: return  groupsUsersRepo;
            case USERS_DETAILS: return  usersDetailsRepo;
            case GROUP_DETAILS: return  groupDetailsRepo;
        }
        return usersDetailsRepo;
    }


}

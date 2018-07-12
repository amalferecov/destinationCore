package com.crag.destinationCore.api;

import com.crag.destinationCore.db.RepoService;
import com.crag.destinationCore.db.domains.UsersDetails;
import com.crag.destinationCore.db.repo.RepoServiceType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by heisenberg on 7/5/18.
 */
@RestController
public class Controller {


    @Autowired
    RepoService repoService;


    @GetMapping("/destination/creatingUser/",RequestMethod.POST)
    public ResponseEntity<UsersDetails> createNewUser(@RequestBody UsersDetails usersDetails){
        repoService.getRepo(RepoServiceType.USERS_DETAILS).save(usersDetails);
        return new ResponseEntity<UsersDetails>(usersDetails, HttpStatus.OK);
    }


}

package com.example.demo;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface AccountRepository extends CrudRepository<Account, Integer> {

    /*@Query("select amount+change as newamount from transact")
    List<Account> findByChange(float newamount);*/
}

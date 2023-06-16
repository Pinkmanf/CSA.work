package com.example;

import com.example.pojo.Account;
import com.example.service.AccountService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Service;


import javax.annotation.Resource;
import java.io.IOException;
import java.util.Date;

@SpringBootTest
class Work61ApplicationTests {

    @Autowired
    AccountService accountService;

    @Test
    public void testFindAll(){
        accountService.findAll();
    }

    @Test
    public void testDeleteByID(){
        accountService.deleteByID(2);
    }



    @Test
    public void testInsert() throws IOException {

        Date date = new Date();
        Account account = new Account(1,"bob", 1200, date, date);
        accountService.insert(account);

    }

    @Test
    public void testSelectByID(){
        accountService.selectByID(3);
    }

    @Test
    public void testUpdateByID(){
        Date date = new Date();
        Account account = new Account(5,"htf", 1600, date, date);
        accountService.updateByID(account);
    }

    @Test
    public void testTransfer(){
        accountService.transfer(5,1,100);
    }

}

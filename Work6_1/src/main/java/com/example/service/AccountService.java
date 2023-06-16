package com.example.service;

import com.example.dao.AccountDao;
import com.example.pojo.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Service
public class AccountService {
    @Autowired
    AccountDao accountDao;

    public List<Account> findAll(){
        return accountDao.findAll();
    }

    public void deleteByID(Integer id){
        accountDao.deleteByID(id);
    }

    public void insert(Account record){
        Date date=new Date();
        date.toString();
        record.setCreateTime(date);
        record.setUpdateTime(date);
        accountDao.insert(record);
    }

    public Account selectByID(Integer id){
        return accountDao.selectByID(id);
    }

    public void updateByID(Account record){
        Date date=new Date();
        date.toString();
        record.setUpdateTime(date);
        accountDao.updateByID(record);
    }

    @Transactional(rollbackFor =Exception.class)//    事务回滚所有异常
    public void transfer(Integer remitterId,Integer remittedId,int money){
        Account remitterAccount;
        Account remittedAccount;
        remittedAccount= accountDao.selectByID(remittedId);
        remitterAccount= accountDao.selectByID(remitterId);
        int remittedMoney = remittedAccount.getMoney();
        int remitterMoney = remitterAccount.getMoney();
        remittedMoney+=money;
        remitterMoney-=money;
        remittedAccount.setMoney(remittedMoney);
        remitterAccount.setMoney(remitterMoney);
        accountDao.updateByID(remittedAccount);
        accountDao.updateByID(remitterAccount);

    }
}

package com.example.dao;

import com.example.pojo.Account;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface AccountDao {

    @Select("select id, name, money, update_time, create_time from work6.account")
    List<Account> findAll();

    @Delete("delete from work6.account where id=#{id}")
    int deleteByID(Integer id);

    @Insert("insert into work6.account(name, money, update_time, create_time) value(#{name},#{money},#{updateTime},#{createTime}) ")
    int insert(Account record);

    @Select("select id, name, money, update_time, create_time from work6.account where id=#{id}")
    Account selectByID(Integer id);

    @Update("update work6.account set name=#{name},money=#{money},update_time=#{updateTime} where id=#{id}")
    int updateByID(Account record);
}

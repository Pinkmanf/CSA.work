package com.example.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Account {
    private Integer id;
    private String name;
    private int money;
    private Date createTime;
    private Date updateTime;

}

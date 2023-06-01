package com.example.demos;


import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@org.apache.ibatis.annotations.Mapper
public interface Mapper {

    @Insert("insert into work5.student(SNO, Name, Age, College) values(#{SNO},#{Name},#{Age},#{College})")
    void insert(Student student);

    List<Student> select(List<String> SNOs);

    @Delete("delete from work5.student where SNO=#{SNO}")
    void delete(String SNO);

    @Update("update student set Name=#{Name},Age=#{Age},College=#{College} where SNO=#{SNO}")
    void update(Student student);

    @Select("select * from student")
    List<Student> list();
}

package com.cc.dao;

import com.cc.bean.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by changc on 2019/3/6.
 */
//泛型中第一个参数是实体类，第二个是id类型
public interface StudentDao extends JpaRepository<Student,Long> {
    //根据学生姓名查询数据
    public List<Student> findByName(String name);
}
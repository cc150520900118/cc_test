package com.cc.service.impl;

import com.cc.bean.Student;
import com.cc.dao.StudentDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by changc on 2019/3/6.
 */
@Service
//方法（或者类）加上 @Transactional 注解，就自动纳入 Spring 的事务管理了
@Transactional
public class StudentService {
    @Autowired
    private StudentDao studentDao;
    //插入一个学生
    public void addStudent(Student student){
        studentDao.save(student);
    }

    //修改一个学生(jpa是根据id来修改的)
    public void  updateStudent(Student student){
        studentDao.save(student);
    }
    //根据id删除一条数据
    public void deleteStudentById(Long id){
        studentDao.deleteById(id);
    }

    //查询所有
    public List<Student> findAll(){
        return studentDao.findAll();
    }
    //根据id查询一条数据(2.0后不能使用findOne了)
    public Student findStudentById(Long id){
        return studentDao.findById(id).get();
    }
    //根据学生姓名查询多条数据
    public List<Student> findStudentByName(String name){
        return studentDao.findByName(name);
    }
}

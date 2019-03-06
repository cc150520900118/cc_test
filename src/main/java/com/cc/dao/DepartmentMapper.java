package com.cc.dao;
import com.cc.bean.Department;
import org.apache.ibatis.annotations.*;



//指定这是一个操作数据库的mapper
@Mapper
public interface DepartmentMapper {

    @Select("select * from department where id=#{id}")
    public Department getDeptById(Integer id);

    @Delete("delete from department where id=#{id}")
    public int deleteDeptById(Integer id);


    //   @Options(useGeneratedKeys = true, keyProperty = "instanceId", keyColumn = "instance_id")

    //这个注解的意思就是，从instance_id这个字段里面把数据放到传入对象的instanceId成员变量里面。

    @Options(useGeneratedKeys = true,keyProperty = "id")
    @Insert("insert into department(department_name) values(#{departmentName})")
    public int insertDept(Department department);

    @Update("update department set department_name=#{departmentName} where id=#{id}")
    public int updateDept(Department department);
}

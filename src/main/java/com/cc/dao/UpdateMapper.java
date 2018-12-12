package com.cc.dao;
import com.cc.bean.Department;
import com.cc.bean.SysAfisclient;
import com.cc.bean.SysClientVp;
import org.apache.ibatis.annotations.*;

import java.util.List;


//指定这是一个操作数据库的mapper
@Mapper
public interface UpdateMapper {

    @Select("select * from sys_client_vp where id=#{id}")
    public SysClientVp getDeptById(String id);
    @Select("select * from sys_client_vp")
    public List<SysClientVp> getSysClientVpAll();
    @Update("update sys_client_vp set vid=#{vid},pid=#{pid} where id=#{id}")
    public int updateSysClientVpAll(SysClientVp sysClientVp);

    @Select("select * from sys_afisclient")
    public List<SysAfisclient> getSysAfisclientAll();
    @Update("update sys_afisclient set clientip=#{clientip} where cid=#{cid}")
    public int updateSysAfisclientAll(SysAfisclient sysAfisclient);

    @Delete("delete from department where id=#{id}")
    public int deleteDeptById(String id);

    @Options(useGeneratedKeys = true,keyProperty = "id")
    @Insert("insert into department(department_name) values(#{departmentName})")
    public int insertDept(Department department);


}

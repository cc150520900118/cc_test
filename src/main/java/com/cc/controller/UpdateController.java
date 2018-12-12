package com.cc.controller;


import com.cc.bean.SysClientVp;
import com.cc.bean.XzxtRestResult;
import com.cc.service.UpdateSysClientVp;
import com.cc.util.TestTask;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UpdateController {
    @Autowired
    private TestTask asyncTask;
    @Autowired
    private UpdateSysClientVp updateSysClientVp;
    //服务修改
    @GetMapping("/updateSysClientVp")
    @ResponseBody
    public XzxtRestResult updateSysClientVp(String id){
        return updateSysClientVp.update(id);
    }
    //服务修改
    @GetMapping("/updateSysClientVpAll")
    @ResponseBody
    public XzxtRestResult updateSysClientVp(){
        return updateSysClientVp.updateSysClientVpAll();
    }
    //服务修改
    @GetMapping("/updateSysAfisclientAll")
    @ResponseBody
    public XzxtRestResult updateSysAfisclient(){
        return updateSysClientVp.updateSysAfisclientAll();
    }
}
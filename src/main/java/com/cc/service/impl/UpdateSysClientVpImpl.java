package com.cc.service.impl;

import com.cc.bean.SysAfisclient;
import com.cc.bean.SysClientVp;
import com.cc.bean.XzxtRestResult;
import com.cc.dao.UpdateMapper;
import com.cc.service.UpdateSysClientVp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

import static com.cc.utls.Base64Util.xzxtdecode;
import static com.cc.utls.Base64Util.xzxtencode;


/**
 * Created by libin on 2018/4/12.
 */
@Service
public class UpdateSysClientVpImpl implements UpdateSysClientVp {
    @Autowired
    private  UpdateMapper updateMapper;
    @Override
    public XzxtRestResult update(String id) {
        SysClientVp sysClientVp=updateMapper.getDeptById(id);
        if(!StringUtils.isEmpty(sysClientVp)){
            //加密算法（自定义）
            sysClientVp.setPid(xzxtencode(sysClientVp.getPid()));
            sysClientVp.setVid(xzxtencode(sysClientVp.getVid()));
            int num=updateMapper.updateSysClientVpAll(sysClientVp);
            if(num==1){
                return XzxtRestResult.build(201,"更新成功");
            }else{
                return XzxtRestResult.build(202,"更新失败");
            }
        }else{
            return XzxtRestResult.build(202,"读取失败","");
        }
    }

    @Override
    public XzxtRestResult updateSysClientVpAll() {
        List<SysClientVp> sysClientVplist=updateMapper.getSysClientVpAll();
        int num=0;
        if(!StringUtils.isEmpty(sysClientVplist)){
            for(SysClientVp sysClientVp :sysClientVplist){
                //加密算法（自定义）
                if(sysClientVp.getPid().length()<24&&sysClientVp.getVid().length()<24){
                    sysClientVp.setPid(xzxtencode(sysClientVp.getPid()));
                    sysClientVp.setVid(xzxtencode(sysClientVp.getVid()));
                    num+=updateMapper.updateSysClientVpAll(sysClientVp);
                }
            }
            if(num>=1){
                return XzxtRestResult.build(201,"更新成功",num);
            }else{
                return XzxtRestResult.build(202,"更新失败");
            }
        }else{
            return XzxtRestResult.build(202,"读取失败","");
        }
    }

    @Override
    public XzxtRestResult updateSysAfisclientAll() {
        List<SysAfisclient> SysAfisclientlist=updateMapper.getSysAfisclientAll();
        int num=0;
        if(!StringUtils.isEmpty(SysAfisclientlist)){
            for(SysAfisclient sysAfisclient :SysAfisclientlist){
                //加密算法（自定义）
                if(sysAfisclient.getClientip().length()<24){
                    sysAfisclient.setClientip(xzxtencode(sysAfisclient.getClientip()));
                    num+=updateMapper.updateSysAfisclientAll(sysAfisclient);
                }
            }
            if(num>=1){
                return XzxtRestResult.build(201,"更新成功",num);
            }else{
                return XzxtRestResult.build(202,"更新失败");
            }
        }else{
            return XzxtRestResult.build(202,"读取失败","");
        }
    }
}

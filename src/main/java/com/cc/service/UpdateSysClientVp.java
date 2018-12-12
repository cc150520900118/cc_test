package com.cc.service;

import com.cc.bean.SysClientVp;
import com.cc.bean.XzxtRestResult;

public interface UpdateSysClientVp {
    XzxtRestResult update(String id);
    XzxtRestResult updateSysClientVpAll();
    XzxtRestResult updateSysAfisclientAll();
}

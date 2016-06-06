package com.stq.modelVo.system;

import com.stq.model.SysUser;

/**
 * Created by Administrator on 2016/6/6.
 */
public class SysUserVo extends SysUser {
    //是否自动登录
    private boolean remeberMe = false;

    public boolean isRemeberMe() {
        return remeberMe;
    }

    public void setRemeberMe(boolean remeberMe) {
        this.remeberMe = remeberMe;
    }
}

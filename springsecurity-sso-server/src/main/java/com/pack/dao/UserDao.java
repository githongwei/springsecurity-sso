package com.pack.dao;

import com.pack.model.SysPermission;
import com.pack.model.SysRole;
import com.pack.model.SysUser;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.Arrays;

@Slf4j
@Repository
public class UserDao {

    private Logger logger = LoggerFactory.getLogger(UserDao.class);

    private SysRole admin = new SysRole("ADMIN", "管理员");
    private SysRole developer = new SysRole("DEVELOPER", "开发者");

    {
        SysPermission p1 = new SysPermission();
        p1.setCode("memberExport");
        p1.setName("会员列表导出");
        p1.setUrl("/member/export");

        SysPermission p2 = new SysPermission();
        p2.setCode("BookList");
        p2.setName("图书列表");
        p2.setUrl("/book/list");


        admin.setPermissionList(Arrays.asList(p1, p2));
        developer.setPermissionList(Arrays.asList(p1));

    }

    public SysUser selectByName(String username) {
        logger.info("从数据库中查询用户");
        if ("zhangsan".equals(username)) {
            SysUser sysUser = new SysUser("zhangsan", "$2a$10$aZDOWYEvK06TrxN6g0Mta.X3gtnj1sHPReRic5YRcOiXl4yMctwS6");
            sysUser.setRoleList(Arrays.asList(admin, developer));
            return sysUser;
        }else if ("lisi".equals(username)) {
            SysUser sysUser = new SysUser("lisi", "$2a$10$aZDOWYEvK06TrxN6g0Mta.X3gtnj1sHPReRic5YRcOiXl4yMctwS6");
            sysUser.setRoleList(Arrays.asList(developer));
            return sysUser;
        }
        return null;
    }

}

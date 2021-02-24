package com.qi.shiro.config;

import com.qi.shiro.pojo.UserDIY;
import com.qi.shiro.service.UserDIYService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;

// 作用域类,在配置类中进行实体化不用交给Spring托管了就.
public class UserRealm extends AuthorizingRealm {

    @Autowired
    UserDIYService userDIYService;

    UserDIY userDIY;

    @Override   //  授权
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        System.out.println("Accredit ===> running");
        // 授权类型
        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
        simpleAuthorizationInfo.addStringPermission("user:add");
        // 要return 我们的授权类型.
        Subject subject = SecurityUtils.getSubject();
        // 取出来的是一个userDIY pojo
        UserDIY principal = (UserDIY)subject.getPrincipal();

        simpleAuthorizationInfo.addStringPermission(principal.getPerms());
        return simpleAuthorizationInfo;
    }

    @Override   //  认证
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        System.out.println("Authenticate ===> running");
// 连接真实的数据库
        // 内存中写入用户名 密码
//        String name = "root";
//        String password = "008778";
        //  强转一下,转化为我们认识的token. 这些token是一个全局的关系.
        UsernamePasswordToken token = (UsernamePasswordToken)authenticationToken;
        if(!token.getUsername().equals(userDIYService.queryUserByName(token.getUsername()).getName()))
        {
            // 用户名错误则返回异常
            return null;
        }
        // 授权认证 密码shiro会自己进行使用.
        // 在principal中传入我们的实体类,我们在授权处就可以拿到这个类型中的数据了
        // 我们的授权方案是把实体类中的字段进行授权操作.
        return new SimpleAuthenticationInfo(userDIY,userDIYService.queryUserByName(token.getUsername()).getPwd(),"");
    }
}

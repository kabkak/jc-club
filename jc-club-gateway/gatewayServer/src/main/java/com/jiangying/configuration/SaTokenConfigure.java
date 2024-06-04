package com.jiangying.configuration;

import cn.dev33.satoken.context.SaHolder;
import cn.dev33.satoken.exception.DisableServiceException;
import cn.dev33.satoken.exception.NotLoginException;
import cn.dev33.satoken.exception.NotPermissionException;
import cn.dev33.satoken.exception.NotRoleException;
import cn.dev33.satoken.reactor.filter.SaReactorFilter;
import cn.dev33.satoken.router.SaRouter;
import cn.dev33.satoken.stp.StpUtil;
import cn.dev33.satoken.util.SaResult;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * [Sa-Token 权限认证] 配置类
 *
 * @author click33
 */
@Configuration
public class SaTokenConfigure {
    // 注册 Sa-Token全局过滤器
    @Bean
    public SaReactorFilter getSaReactorFilter() {
        return new SaReactorFilter()
                // 拦截地址
                .addInclude("/**")    /* 拦截全部path */
                // 鉴权方法：每次访问进入
                .setAuth(obj -> {
                    System.out.println("-------- 前端访问path：" + SaHolder.getRequest().getRequestPath());
                    // 登录校验 -- 拦截所有路由，并排除/user/doLogin 用于开放登录
                    SaRouter.match("/**", "/subject/user/doLogin", r -> StpUtil.checkLogin());


                    // 权限认证 -- 不同模块, 校验不同权限
                    SaRouter.match("/user1/**", r -> StpUtil.checkRole("admin"));
                    SaRouter.match("/user/**", r -> StpUtil.checkPermission("user"));
                    SaRouter.match("/admin/**", r -> StpUtil.checkPermission("admin"));
                    SaRouter.match("/goods/**", r -> StpUtil.checkPermission("goods"));
                    SaRouter.match("/orders/**", r -> StpUtil.checkPermission("orders"));

                })
//                 异常处理方法：每次setAuth函数出现异常时进入
                .setError(e -> {
                    if (e instanceof NotLoginException) {
                        // 返回给前端的数据
                        return SaResult.error("当前会话未登录").setCode(401);
                    }
                    if (e instanceof NotRoleException) {
                        return SaResult.error("没有用户权限访问").setCode(403);
                    }
                    if (e instanceof NotPermissionException) {
                        return SaResult.error("没有权限访问").setCode(403);
                    }
                    if (e instanceof DisableServiceException) {
                        return SaResult.error("账号已被封禁").setCode(403);
                    }
                    return SaResult.error(e.getMessage());
                })
                ;
    }
}


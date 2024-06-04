package com.jiangying.configuration;

import cn.dev33.satoken.stp.StpInterface;
import com.jiangying.Util.RedisUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.*;
import java.util.stream.Collectors;

/**
 * 自定义权限验证接口扩展
 */
@Component
@Slf4j
public class StpInterfaceImpl implements StpInterface {
    @Resource
    private RedisTemplate redisTemplate;
    private final String USER_PERMISSION_KEY = "user:permission:";
    private final String USER_ROLE_KEY = "user:role:";

    @Override
    public List<String> getPermissionList(Object loginId, String loginType) {

        String key = USER_PERMISSION_KEY + loginId;
        if (!redisTemplate.hasKey(key)) {
            throw new RuntimeException("用户不存在");
        }

        log.debug("key:{}", key);

        List<Object> getPermissions = redisTemplate.opsForList().range(key, 0, -1);

       List<String> permissionList =  getPermissions.stream().map(Object::toString).collect(Collectors.toList());

        log.debug("permissionList:{}", permissionList);

        if (CollectionUtils.isEmpty(permissionList)) {
            return Collections.emptyList();
        }
        return permissionList;
    }

    @Override
    public List<String> getRoleList(Object loginId, String loginType) {
        String key = USER_ROLE_KEY + loginId;
        if (!redisTemplate.hasKey(key)) {
            throw new RuntimeException("用户不存在");
        }
        List<Object> getPermissions = redisTemplate.opsForList().range(key, 0, -1);

        List<String> roleList =  getPermissions.stream().map(Object::toString).collect(Collectors.toList());
        log.debug("roleList:{}", roleList);
        if (CollectionUtils.isEmpty(roleList)) {
            return Collections.emptyList();
        }
        return roleList;
    }

}

package com.github.web.shiro;


import com.github.web.shiro.CustomizedRealm;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.mgt.SessionsSecurityManager;
import org.apache.shiro.session.mgt.eis.MemorySessionDAO;
import org.apache.shiro.session.mgt.eis.SessionDAO;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.session.mgt.DefaultWebSessionManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.Resource;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author Zer01ne
 * @version 1.0
 * @date 2019/7/8 17:26
 */
@Configuration
public class ShiroConfig {


    @Resource
    private CustomizedRealm customizedRealm;
    @Resource
    private SessionDAO sessionDAO;

    /**
     * 自定义身份认证 realm;
     * 必须写这个类，并加上 @Bean 注解，目的是注入 CustomizedRealm，
     * 否则会影响 CustomizedRealm类 中其他类的依赖注入
     */
    @Bean
    public CustomizedRealm customizedRealm() {
        CustomizedRealm customizedRealm = new CustomizedRealm();
        customizedRealm.setCredentialsMatcher(sha256Matcher());
        return customizedRealm;
    }
    /**
     * 凭证验证器
     * 这里也可以配置一些其他的加盐处理
     * */
    @Bean
    public HashedCredentialsMatcher sha256Matcher() {
        HashedCredentialsMatcher hashedCredentialsMatcher = new HashedCredentialsMatcher();
        // 散列算法
        hashedCredentialsMatcher.setHashAlgorithmName("md5");
        //散列的次数，比如散列两次，相当于 md5(md5(""));
        hashedCredentialsMatcher.setHashIterations(1);
        return hashedCredentialsMatcher;
    }
    /**
     * 权限管理，配置主要是Realm的管理认证
     */
    @Bean
    public SessionsSecurityManager securityManager() {
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        // 将自己的验证方式加入容器
        securityManager.setRealm(customizedRealm());
        securityManager.setSessionManager(defaultWebSessionManager());
        return securityManager;
    }

    /**
     * 可以配置sessionDAO来做不允许同一账号，重复登录的功能，但总感觉这不是一个好方法
     * 一般都是用数据库记录token的方式来做避免重复登录，每次登录，对比数据库的token，如果不一样，就更新一下，那么之前登录的信息就失效了，如果一样，则不做什么，
     * 这个token，可以自己生成，也可以用JWT，也可以使用shiro的JSESSIONID
     */
    @Bean
    public SessionDAO sessionDAO(){
        return new MemorySessionDAO();
    }
    @Bean
    public DefaultWebSessionManager defaultWebSessionManager() {
        DefaultWebSessionManager defaultWebSessionManager = new DefaultWebSessionManager();
        defaultWebSessionManager.setSessionDAO(sessionDAO());
        return defaultWebSessionManager;
    }
    //@Bean
    //public ShiroFilterChainDefinition shiroFilterChainDefinition() {
    //    DefaultShiroFilterChainDefinition chainDefinition = new DefaultShiroFilterChainDefinition();
    //
    //    ////可以匿名访问
    //    //chainDefinition.addPathDefinition("/user/login", "anon");
    //    //
    //    //// logged in users with the 'admin' role
    //    //chainDefinition.addPathDefinition("/admin/**", "authc, roles[admin]");
    //    //
    //    //// logged in users with the 'document:read' permission
    //    //chainDefinition.addPathDefinition("/docs/**", "authc, perms[document:read]");
    //    //
    //    //// all other paths require a logged in user
    //    //chainDefinition.addPathDefinition("/**", "authc");
    //
    //    return chainDefinition;
    //}


    @Bean
    public ShiroFilterFactoryBean shiroFilter(SessionsSecurityManager securityManager) {
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        // 必须设置SecuritManager
        shiroFilterFactoryBean.setSecurityManager(securityManager);
        //Map<String, Filter> filters = shiroFilterFactoryBean.getFilters();
        //配置拦截器,实现无权限返回401,而不是跳转到登录页
        //filters.put("authc", new FormLoginFilter());
        // 如果不设置默认会自动寻找Web工程根目录下的"/login.jsp"页面
        shiroFilterFactoryBean.setLoginUrl("/user/login");
        // 登录成功后要跳转的链接
        shiroFilterFactoryBean.setSuccessUrl("/user/index");
        // 未授权界面;
        shiroFilterFactoryBean.setUnauthorizedUrl("/403");
        // 拦截器
        Map<String, String> filterChainDefinitionMap = new LinkedHashMap<>();
        // 过滤链定义，从上向下顺序执行，一般将 /**放在最为下边
        // authc:所有url都必须认证通过才可以访问; anon:所有url都都可以匿名访问
        //filterChainDefinitionMap.put("/**", "authc");
        //测试阶段，可以先放开
        filterChainDefinitionMap.put("/**", "anon");
        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainDefinitionMap);
        //shiroFilterFactoryBean.setFilterChainDefinitionMap(shiroFilterChainDefinition().getFilterChainMap());
        return shiroFilterFactoryBean;
    }


}

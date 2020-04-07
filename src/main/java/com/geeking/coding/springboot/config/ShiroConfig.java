package com.geeking.coding.springboot.config;

import org.apache.shiro.cache.CacheManager;
import org.apache.shiro.cache.MemoryConstrainedCacheManager;
import org.apache.shiro.cache.ehcache.EhCacheManager;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * User: devils
 * Date: 2018/12/5
 */
@Configuration
public class ShiroConfig {



    @Bean
    public CacheManager ehCacheManager(){
        CacheManager cacheManager = new MemoryConstrainedCacheManager();
        return cacheManager;
    }


    @Bean
    public UserRealm userRealm(){
        UserRealm userRealm = new UserRealm();
        userRealm.setName("myRealm");
        return userRealm;
    }

    @Bean(name="securityManager")
    public SecurityManager securityManager(){
        DefaultWebSecurityManager webSecurityManager = new DefaultWebSecurityManager();
        webSecurityManager.setRealm(userRealm());
        webSecurityManager.setCacheManager(ehCacheManager());
        return webSecurityManager;
    }

    @Bean(name = "shiroFilter")
    public ShiroFilterFactoryBean shiroFilterFactoryBean() {
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        shiroFilterFactoryBean.setSecurityManager(securityManager());
        Map<String, String> filterChainDefinitionManager = new LinkedHashMap<>();

        filterChainDefinitionManager.put("/user/logout", "logout");
        filterChainDefinitionManager.put("/index", "anon");
        filterChainDefinitionManager.put("/user/login", "anon");// anon 可以理解为不拦截
        filterChainDefinitionManager.put("/unauth","anon");
        // 可以理解为不拦截
        filterChainDefinitionManager.put("/druid/*", "anon");// druid

        filterChainDefinitionManager.put("/static/**", "anon");// 静态资源不拦截
        filterChainDefinitionManager.put("/**/*.js", "anon");// 静态资源不拦截
        filterChainDefinitionManager.put("/**/*.css", "anon");// 静态资源不拦截
        filterChainDefinitionManager.put("/**/*.png", "anon");// 静态资源不拦截
        filterChainDefinitionManager.put("/**/*.img", "anon");// 静态资源不拦截

        //不拦截关于swagger的资源
        filterChainDefinitionManager.put("/swagger-ui.html", "anon");
        filterChainDefinitionManager.put("/swagger-resources", "anon");
        filterChainDefinitionManager.put("/v2/api-docs", "anon");
        filterChainDefinitionManager.put("/webjars/springfox-swagger-ui/**", "anon");


        filterChainDefinitionManager.put("/**", "authc");// 其他资源全部拦截(需登陆后才能查看)
        shiroFilterFactoryBean
                .setFilterChainDefinitionMap(filterChainDefinitionManager);

        shiroFilterFactoryBean.setLoginUrl("/unauth");
        shiroFilterFactoryBean.setSuccessUrl("/hello");
        shiroFilterFactoryBean.setUnauthorizedUrl("/403");

        return shiroFilterFactoryBean;
    }


}

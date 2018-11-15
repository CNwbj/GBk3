package cn.sz.zl.util;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.Filter;

import org.apache.shiro.spring.LifecycleBeanPostProcessor;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.filter.authc.LogoutFilter;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.apache.shiro.mgt.SecurityManager;
@Configuration
public class ShiroConfigration {
	    /**
	     * LifecycleBeanPostProcessor，这是个DestructionAwareBeanPostProcessor的子类，
	     * 负责org.apache.shiro.util.Initializable类型bean的生命周期的，初始化和销毁。
	     * 主要是AuthorizingRealm类的子类，以及EhCacheManager类。
	     */
	    @Bean
	    public LifecycleBeanPostProcessor lifecycleBeanPostProcessor() {
	        return new LifecycleBeanPostProcessor();
	    }

	    /**
	     * ShiroRealm，这是个自定义的认证类，继承自AuthorizingRealm，
	     * 负责用户的认证和权限的处理，可以参考JdbcRealm的实现。
	     */
	    @Bean
	    @DependsOn("lifecycleBeanPostProcessor")
	    public UserPriRealm shiroRealm() {
	        UserPriRealm realm = new UserPriRealm();
	        return realm;
	    }

	    /**
	     * SecurityManager，权限管理，这个类组合了登陆，登出，权限，session的处理，是个比较重要的类。
	     * //
	     */
	    @Bean
	    public SecurityManager securityManager(){
	    	DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
	        //设置realm.
	    	securityManager.setRealm(shiroRealm());
	        return securityManager;
	    }
	    /**
	     * ShiroFilterFactoryBean，是个factorybean，为了生成ShiroFilter。
	     * 它主要保持了三项数据，securityManager，filters，filterChainDefinitionManager。
	     */
	    @Bean
	    public ShiroFilterFactoryBean shiroFilterFactoryBean() {
	        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
	        shiroFilterFactoryBean.setSecurityManager(securityManager());
	        //配置登录的url和登录成功的url
	        shiroFilterFactoryBean.setLoginUrl("/index.jsp");
	        shiroFilterFactoryBean.setSuccessUrl("/main.jsp");
	        shiroFilterFactoryBean.setUnauthorizedUrl("/403.jsp");
	        Map<String, Filter> filters = new LinkedHashMap<String, Filter>();
	        LogoutFilter logoutFilter = new LogoutFilter();
	        logoutFilter.setRedirectUrl("/index.jsp");
	        shiroFilterFactoryBean.setFilters(filters);

	        Map<String, String> filterChainDefinitionManager = new LinkedHashMap<String, String>();
	        filterChainDefinitionManager.put("/js/**", "anon");
	        filterChainDefinitionManager.put("/css/**", "anon");
	        filterChainDefinitionManager.put("/fonts/**", "anon");
	        filterChainDefinitionManager.put("/tupian/**", "anon");
	        filterChainDefinitionManager.put("/img/**", "anon");
	        filterChainDefinitionManager.put("/images/**", "anon");
	        filterChainDefinitionManager.put("/user2/**", "anon");
	        filterChainDefinitionManager.put("/uc/islogin", "anon");
	        filterChainDefinitionManager.put("/uc/getVerifyCode","anon");
	        filterChainDefinitionManager.put("/uc/checkCode", "anon");//
	        filterChainDefinitionManager.put("/My97DatePicker/**", "anon");
	        
	        filterChainDefinitionManager.put("/Forehome.html", "anon");//主页面
	        filterChainDefinitionManager.put("/register.html", "anon");//注册页面
	        filterChainDefinitionManager.put("/cate_pencil.html", "anon");//毛笔详情页面
	        filterChainDefinitionManager.put("/customerDetails.html", "anon");//客户详情页面
	        filterChainDefinitionManager.put("/login_in.html", "anon");//客户登录页面
	        filterChainDefinitionManager.put("/ordersMsg.html", "anon");//购买历史订单
	        filterChainDefinitionManager.put("/purchase.html", "anon");//客户购买页面
	        
	        filterChainDefinitionManager.put("/Forehome.jsp", "anon");//主页面
	        filterChainDefinitionManager.put("/register.jsp", "anon");//注册页面
	        filterChainDefinitionManager.put("/cate_pencil.jsp", "anon");//毛笔
	        filterChainDefinitionManager.put("/customerDetails.jsp", "anon");//客户详情页面
	        filterChainDefinitionManager.put("/login_in.jsp", "anon");//客户登录页面
	        filterChainDefinitionManager.put("/Customer_pwd_back.jsp", "anon");//客户密码找回页面
	        filterChainDefinitionManager.put("/ordersMsg.jsp", "anon");//购买历史订单
	        filterChainDefinitionManager.put("/purchase.jsp", "anon");//客户购买页面
	        filterChainDefinitionManager.put("/cate_pencil.jsp", "anon");//客户购买页面
	        filterChainDefinitionManager.put("/loginpwd_back.jsp", "anon");//客户购买页面
	        
	        filterChainDefinitionManager.put("/ca/**", "anon");
	        filterChainDefinitionManager.put("/ml/**", "anon");
	        filterChainDefinitionManager.put("/pc/**", "anon");
	        
	        filterChainDefinitionManager.put("/uc/**", "authc");
	        filterChainDefinitionManager.put("/**", "authc");
	        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainDefinitionManager);

	        return shiroFilterFactoryBean;
	    }

	    /**
	     * DefaultAdvisorAutoProxyCreator，Spring的一个bean，由Advisor决定对哪些类的方法进行AOP代理。
	     */
	    @Bean
	    @ConditionalOnMissingBean
	    @DependsOn("lifecycleBeanPostProcessor")
	    public DefaultAdvisorAutoProxyCreator defaultAdvisorAutoProxyCreator() {
	        DefaultAdvisorAutoProxyCreator defaultAAP = new DefaultAdvisorAutoProxyCreator();
	        defaultAAP.setProxyTargetClass(true);
	        return defaultAAP;
	    }

	    /**
	     * AuthorizationAttributeSourceAdvisor，shiro里实现的Advisor类，
	     * 内部使用AopAllianceAnnotationsAuthorizingMethodInterceptor来拦截用以下注解的方法。
	     */
	    @Bean
	    public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor() {
	        AuthorizationAttributeSourceAdvisor aASA = new AuthorizationAttributeSourceAdvisor();
	        aASA.setSecurityManager(securityManager());
	        return aASA;
	    }

}

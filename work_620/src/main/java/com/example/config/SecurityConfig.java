//package com.example.config;
//
//import com.example.service.UserDetailsServiceImpl;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;
//import javax.sql.DataSource;
//
//import static com.sun.org.apache.xalan.internal.xsltc.compiler.sym.error;
//
//@EnableWebSecurity  // 开启MVC security安全支持
//public class SecurityConfig extends WebSecurityConfigurerAdapter {
//    @Autowired
//    private DataSource dataSource;
//    @Autowired
//    private UserDetailsService userDetailsService;
//
//    /**
//     * 用户授权管理自定义配置
//     * @param http
//     * @throws Exception
//     */
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        // 自定义用户授权管理
//        http.authorizeRequests()
////                .antMatchers("/").permitAll()
//                // 需要对static文件夹下静态资源进行统一放行
//                .antMatchers("/login/**").permitAll()
//                .antMatchers("/teacher/**").hasRole("TEACHER")
//                .antMatchers("/student/**").hasRole("STUDENT")
//                .anyRequest().authenticated();
//
//        // 自定义用户登录控制
//        http.formLogin()
//                .loginPage("/user/login").permitAll()
//                .usernameParameter("account").passwordParameter("password")
//                .defaultSuccessUrl("/")
//                .failureUrl("/user/login?error");
////        System.out.println(error);
//        http.formLogin();
//        // 自定义用户退出控制
//        http.logout()
//                .logoutUrl("/user/logout")
//                .logoutSuccessUrl("/login");
//
//        // 定制Remember-me记住我功能
//        http.rememberMe()
//                .rememberMeParameter("rememberme")
//                .tokenValiditySeconds(200)
//                // 对cookie信息进行持久化管理
//                .tokenRepository(tokenRepository());
//
//        // 可以关闭Spring Security默认开启的CSRF防护功能
////        http.csrf().disable();
//
//    }
//    /**
//     * 持久化Token存储
//     * @return
//     */
//    @Bean
//    public JdbcTokenRepositoryImpl tokenRepository(){
//        JdbcTokenRepositoryImpl jr=new JdbcTokenRepositoryImpl();
//        jr.setDataSource(dataSource);
//        return jr;
//    }
//
//    /**
//     * 用户身份认证自定义配置
//     * @param auth
//     * @throws Exception
//     */
//
////    @Override
////    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
////        //数据正常在数据库中被读取
////        auth.inMemoryAuthentication().passwordEncoder(new BCryptPasswordEncoder())
////                .withUser("yal").password(new BCryptPasswordEncoder().encode("123456")).roles("TEACHER")
////                .and()
////                .withUser("yal01").password(new BCryptPasswordEncoder().encode("123456")).roles("TEACHER")
////                .and()
////                .withUser("admin").password(new BCryptPasswordEncoder().encode("123456")).roles("TEACHER","TEACHER","ADMIN");
////    }
//
////    @Override
////    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
////        //  密码需要设置编码器
////        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
////        // 1、使用内存用户信息，作为测试使用
////        /*auth.inMemoryAuthentication().passwordEncoder(encoder)
////                .withUser("shitou").password(encoder.encode("123456")).roles("common")
////                .and()
////                .withUser("李四").password(encoder.encode("123456")).roles("vip");*/
////
////        // 2、使用JDBC进行身份认证
////        /*String userSQL ="select username,password,valid from t_customer " +
////                "where username = ?";
////        String authoritySQL="select c.username,a.authority from t_customer c,t_authority a,"+
////                "t_customer_authority ca where ca.customer_id=c.id " +
////                "and ca.authority_id=a.id and c.username =?";
////        auth.jdbcAuthentication().passwordEncoder(encoder)
////                .dataSource(dataSource)
////                .usersByUsernameQuery(userSQL)
////                .authoritiesByUsernameQuery(authoritySQL);*/
////
////        // 3、使用UserDetailsService进行身份认证
////        auth.userDetailsService(userDetailsService).passwordEncoder(encoder);
////        System.out.println(auth);
////    }
//
//}
//

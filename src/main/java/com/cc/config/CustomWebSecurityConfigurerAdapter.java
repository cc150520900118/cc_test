package com.cc.config;




/**
 * Created by changchao on 2019/5/16.
 * Spring Security 会拦截swagger-ui.html 同样也会拦截api，这里将或略掉/api/下的所有子路径
 */
/*public class CustomWebSecurityConfigurerAdapter extends WebSecurityConfigurerAdapter {
    @Override
    public void configure(WebSecurity web) throws Exception {
        super.configure(web);
        web.ignoring().antMatchers("/v2*//**");  //http://localhost:8050/v2/api-docs
        web.ignoring().antMatchers("/form*//**");
    }*/
//}

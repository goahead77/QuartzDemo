package cn.quartz.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @author wenqi
 */

@Configuration
@EnableWebMvc
public class MvcConfig extends WebMvcConfigurerAdapter {
    @Override
    public void configureViewResolvers(ViewResolverRegistry registry) {
        super.configureViewResolvers(registry);
        registry.jsp("/pages/",".jsp");
    }
}

package cn.quartz.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;

/**
 * @author wenqi
 */

@Configuration
@Import(value = {MvcConfig.class})
@ComponentScan(value ={"cn.quartz"} )
@ImportResource(locations = "classpath:spring-setting.xml")
public class RootConfig {

}

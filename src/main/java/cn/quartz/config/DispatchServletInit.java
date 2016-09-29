package cn.quartz.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * @author wenqi
 */
public class DispatchServletInit extends AbstractAnnotationConfigDispatcherServletInitializer {
    protected Class<?>[] getRootConfigClasses() {
        return new Class<?>[]{RootConfig.class};
    }

    protected Class<?>[] getServletConfigClasses() {
        return null;
    }

    protected String[] getServletMappings() {
        return new String[]{"/"};
    }
}

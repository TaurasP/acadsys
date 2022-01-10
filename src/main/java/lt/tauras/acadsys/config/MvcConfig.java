package lt.tauras.acadsys.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MvcConfig implements WebMvcConfigurer {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("login");
        registry.addViewController("/index").setViewName("index");
        registry.addViewController("/admin").setViewName("admin");
        registry.addViewController("/login").setViewName("login");
        registry.addViewController("/students").setViewName("students");
        registry.addViewController("/lecturers").setViewName("lecturers");
        registry.addViewController("/courses").setViewName("courses");
        registry.addViewController("/groups").setViewName("groups");
        registry.addViewController("/group_students").setViewName("group_students");
    }
}

package com.example.customphonevalidation.configuration;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
@Configuration
public class AppConfiguration implements WebMvcConfigurer, ApplicationContextAware {
    private ApplicationContext applicationContext;
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    @Bean
    public MessageSource messageSource() {
        ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
        messageSource.setBasename("validation-message");
        return messageSource;
    }
    //@Configuration
    //public class AppConfig implements WebMvcConfigurer {
    //    @Bean
    //    public MessageSource messageSource() {
    //        ReloadableResourceBundleMessageSource messageSource
    //                = new ReloadableResourceBundleMessageSource();
    //        messageSource.setBasename("classpath:validation_msg");
    //        messageSource.setDefaultEncoding("UTF-8");
    //        return messageSource;
    //    }
    //
    //    @Bean
    //    public LocalValidatorFactoryBean getValidator() {
    //        LocalValidatorFactoryBean bean = new LocalValidatorFactoryBean();
    //        bean.setValidationMessageSource(messageSource());
    //        return bean;
    //    }
    //}
}

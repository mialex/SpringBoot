package com.spring.app.springapp2.service;

import com.spring.app.springapp2.controller.MyController;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Service;

@Service
public class LifeCycleBean implements
        InitializingBean,
        DisposableBean,
        BeanNameAware,
        BeanFactoryAware,
        ApplicationContextAware,
        BeanPostProcessor {

    private String javaVer;

    public LifeCycleBean() {
        System.out.println(" # In LifeCycleBean Constructor");
    }

    @Value("${java.specification.version}")
    public void setJavaVer(String javaVer) {
        this.javaVer = javaVer;

        System.out.println(" # 1 Property javaVer set: " + this.javaVer);
    }

    @Override
    public void setBeanName(String name) {
        System.out.println(" # 2 BeanNameAware, name: " + name);
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        System.out.println(" # 3 BeanFactoryAware has been set");
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println(" # 4 ApplicationContextAware has been set");
    }

    @PostConstruct
    public void postConstruct() {
        System.out.println(" # 6 postConstruct has been called");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println(" # 7 InitializingBean::afterPropertiesSet");
    }

    @PreDestroy
    public void preDestroy() throws Exception {
        System.out.println(" # 8 preDestroy has been called");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println(" # 9 DisposableBean::destroy");
    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println(" # 10 postProcessBeforeInitialization: " + beanName);

        if (bean instanceof MyController) {
            MyController controller = (MyController) bean;
            System.out.println(" # Calling beforeInit");
            controller.beforeInit();
        }

        return BeanPostProcessor.super.postProcessBeforeInitialization(bean, beanName);
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println(" # 11 postProcessAfterInitialization: " + beanName);

        if (bean instanceof MyController) {
            MyController controller = (MyController) bean;
            System.out.println(" # Calling afterInit");
            controller.afterInit();
        }

        return BeanPostProcessor.super.postProcessAfterInitialization(bean, beanName);
    }
}

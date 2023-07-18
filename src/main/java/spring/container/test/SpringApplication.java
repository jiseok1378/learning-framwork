package spring.container.test;


import org.reflections.Reflections;
import spring.container.test.context.ApplicationContext;
import spring.container.test.context.ApplicationContextProvider;
import spring.container.test.instance.ClassInstanceMaker;
import spring.container.test.targets.Component;

import java.util.Set;
import java.util.stream.Collectors;

public class SpringApplication {

    public static ApplicationContext run(Class<?> loaderClass){

        ApplicationContextProvider context = (ApplicationContextProvider) ApplicationContextProvider.getContext();

        Reflections reflections = new Reflections(loaderClass.getPackage().getName());

        Set<Class<?>> classes =  reflections.getTypesAnnotatedWith(Component.class);

        for(Class<?> clazz : classes){
            context.setBean(clazz.getName(), ClassInstanceMaker.make(clazz));


        }

        return context;
    }
}

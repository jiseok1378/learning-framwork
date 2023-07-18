package com.test.main;

import com.test.main.component.TestBeanComponent;
import com.test.main.component.TestBeanComponent2;
import spring.container.test.SpringApplication;
import spring.container.test.context.ApplicationContextProvider;

public class Main {
    public static void main(String[] args) {
        ApplicationContextProvider provider = (ApplicationContextProvider) SpringApplication.run(Main.class);
        TestBeanComponent component = provider.getBean(TestBeanComponent.class);
        TestBeanComponent2 component2 = provider.getBean(TestBeanComponent2.class);
        component.println();
        component2.println();
    }
}

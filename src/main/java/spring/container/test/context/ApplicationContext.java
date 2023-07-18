package spring.container.test.context;

import java.util.Map;

public interface ApplicationContext {
    Object getBean(String name);
    <R> R getBean(String name, Class<R> clazz);
    <R> R getBean(Class<R> clazz);
}

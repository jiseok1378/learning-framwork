package spring.container.test.context;


import java.util.HashMap;
import java.util.Map;

public class ApplicationContextProvider implements ApplicationContext{
    private static Map<String, Object> beans;
    private static ApplicationContext context;

    private ApplicationContextProvider(){
        beans = new HashMap<>();
    }

    public static ApplicationContext getContext(){
        if(context == null){
            context = new ApplicationContextProvider();
        }
        return context;
    }

    public <R> void setBean(String name, R clazz){
        if(beans.get(name) == null){
            beans.put(name, clazz);
        }
        else{
            System.out.println("해당 이름["+name+"]으로 등록된 빈이 존재합니다.");
        }
    }

    @Override
    public Object getBean(String name) {
        return beans.get(name);
    }

    @Override
    public <R> R getBean(String name, Class<R> clazz) {
        return (R) this.getBean(name);
    }

    @Override
    public <R> R getBean(Class<R> clazz) {
        return this.getBean(clazz.getName(), clazz);
    }
}

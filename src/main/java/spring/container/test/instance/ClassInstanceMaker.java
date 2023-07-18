package spring.container.test.instance;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ClassInstanceMaker {

    public static Object make(Class<?> value){
        Constructor<?>[] constructors = value.getDeclaredConstructors();
        try{
            if (constructors.length == 1) {
                Constructor<?> constructor = constructors[0];
                System.out.println(value.getName());
                Class<?>[] paramsTargets = constructor.getParameterTypes();
                if (paramsTargets.length == 0) {
                    return constructor.newInstance();
                } else {
                    Object[] inputParam = new Object[ paramsTargets.length ];
                    for (int i = 0; i < paramsTargets.length; i++) {
                        inputParam[i] =  make( paramsTargets[i] );
                    }
                    return constructor.newInstance( inputParam );
                }
            }
            System.err.println("Bean 으로 등록 가능한 클래스는 하나의 생성자만을 가지고 있어야만 합니다.");
            return null;
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
            System.err.println("클래스 인스턴스 생성중 문제가 발생했습니다.");
            return null;
        }
    }
}

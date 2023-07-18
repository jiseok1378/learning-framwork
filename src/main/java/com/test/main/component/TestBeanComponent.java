package com.test.main.component;

import spring.container.test.targets.Component;

@Component
public class TestBeanComponent {

    public TestBeanComponent(ComponentParam1 p1, ComponentParam2 p2){

    }

    public void println(){
        System.out.println("내가 만든 스프링 컨테이너에서 인스턴스를 생성하고 호출됐습니다.");
    }
}

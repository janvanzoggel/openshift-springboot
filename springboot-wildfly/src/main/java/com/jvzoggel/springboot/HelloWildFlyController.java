package com.jvzoggel.springboot;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWildFlyController
{
    @RequestMapping("hello")
    public String sayHello()
    {
        return ("Hi, this is SpringBoot on WildFly with OpenShift S2I");
    }
}
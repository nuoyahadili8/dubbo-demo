package com.teradata.dubbo.consumer.controller;

import com.teradata.dubbo.api.FindWordService;
import com.teradata.dubbo.api.SayHelloService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Project:
 * @Description:
 * @Version 1.0.0
 * @Throws SystemException:
 * @Author: <li>2018/12/11/011 Administrator Create 1.0
 * @Copyright ©2018-2019 al.github
 * @Modified By:
 */
@RestController
@RequestMapping("/dubbo")
public class TestDubboController {

    @Reference(version = "1.0.0",
            application = "${dubbo.application.id}",
//            url = "dubbo://localhost:12345",
            loadbalance = "roundrobin", //负载均衡
            retries = 2, //失败重试次数
            mock = "true"    //服务降级
    )
    private SayHelloService sayHelloService;

    @Reference(version = "1.0.0",
            application = "${dubbo.application.id}",
//            url = "dubbo://localhost:12345",
            loadbalance = "roundrobin", //负载均衡
            retries = 2 //失败重试次数
    )
    private FindWordService findWordService;

    @RequestMapping("say")
    public String hello(String name){
        String s = sayHelloService.sayHello(name);
        return s;
    }


    @RequestMapping("find")
    public String find(String str){
        String string = findWordService.findString(str);
        return string;
    }
}

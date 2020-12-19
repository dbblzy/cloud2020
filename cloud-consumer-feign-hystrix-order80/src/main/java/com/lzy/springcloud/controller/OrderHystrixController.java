package com.lzy.springcloud.controller;

import com.lzy.springcloud.service.PaymentHystrixService;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@Slf4j
@DefaultProperties(defaultFallback = "payment_Global_FallbackMethod")
public class OrderHystrixController {

    @Resource
    private PaymentHystrixService paymentHystrixService;

    @GetMapping("/consumer/payment/hystrix/ok/{id}")
    public String paymentInfo_OK(@PathVariable("id")Integer id){
        String result=paymentHystrixService.paymentInfo_OK(id);
        log.info("*****result:"+result);
        return result;
    }




    //异常的方法
//    @HystrixCommand(fallbackMethod = "paymentInfo_TimeOutHandler",commandProperties = {
//            @HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds",value = "1500")
//    })
    @HystrixCommand
    @GetMapping("/consumer/payment/hystrix/timeout/{id}")
    public String paymentInfo_TimeOut(@PathVariable("id")Integer id){
        int age=10/0;
        String result=paymentHystrixService.paymentInfo_TimeOut(id);
        log.info("*****result:"+result);
        return result;
    }

    public String paymentInfo_TimeOutHandler(Integer id){
        return "线程池："+Thread.currentThread().getName()
                +"我是消费者80 系统繁忙或运行错误,请稍后再试,id:"+id+"\t"+"dengyideng  ";
    }

    //全局fallback
    public String payment_Global_FallbackMethod(){
        return "Global异常处理信息，请稍后再试，/global/";
    }

}

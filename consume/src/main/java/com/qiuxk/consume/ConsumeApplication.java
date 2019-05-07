package com.qiuxk.consume;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
/**@EnableEurekaClient 只只适用于Eureka作为注册中心，@EnableDiscoveryClient 可以是其他注册中心。**/
@EnableDiscoveryClient
/**开启熔断器**/
@EnableHystrix
/**开启hystri仪表盘 显示Hystri各项指标信息**/
@EnableHystrixDashboard
public class ConsumeApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConsumeApplication.class, args);
    }

    @Bean
    /**  此注解可以让RestTemplate在请求时拥有客户端负载均衡的能力**/
    @LoadBalanced
    RestTemplate restTemplate(){

        return  new RestTemplate();
    }

}

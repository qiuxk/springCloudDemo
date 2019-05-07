package com.qiuxk.consume.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class HelloService {

    @Autowired
    private RestTemplate restTemplate;


    public  String hiService(String name){

        /**消费SERVICE-FIRST 中的hello服务**/

     return     restTemplate.getForObject("http://SERVICE-FIRST/hello?name=" + name,String.class);
    }
}

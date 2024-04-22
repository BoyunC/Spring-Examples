package com.example.jpa.springexamples;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
public class SecondController {

    /*
     *  [ 조건 ]
     *  - RestController 어노테이션 이용
     *  - RequestMapping을 이용해 주소 매핑
     *  - HTTP 메소드 : GET
     *  - 리턴값 : "hello spring"
     *  - url 주소 : /hello-spring
     */
    @RequestMapping(value = "/hello-spring", method = RequestMethod.GET)
    public String helloSpring() {

        return "hello Spring";
    }

    /*
     *  [ 조건 ]
     *  - RestController 어노테이션 이용
     *  - Rest을 이용해 주소 매핑
     *  - HTTP 메소드 : GET
     *  - 리턴값 : "hello rest"
     *  - url 주소 : /hello-rest
     */
    @GetMapping("/hello-rest")
    public String helloRest() {

        return "hello Rest";
    }

    /*
     *  [ 조건 ]
     *  - RestController 어노테이션 이용
     *  - Rest을 이용해 주소 매핑
     *  - HTTP 메소드 : GET
     *  - 리턴값 : "hello rest api"
     *  - url 주소 : /api/hello-world
     */
    @GetMapping("/api/hello-world")
    public String helloRestApi() {
        return "hello rest api";
    }

}

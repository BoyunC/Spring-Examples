package com.example.jpa.springexamples;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class FirstController {

    /*
    *  [ 조건 ]
    *  - Controller 어노테이션 이용
    *  - RequestMapping을 이용해 주소 매핑
    *  - HTTP 메소드 : GET
    *  - 리턴값 없음
    *  - url 주소 : /first-url
    */
    @RequestMapping(value = "/first-url", method = RequestMethod.GET)
    public void first() {
    }

    /*
     *  [ 조건 ]
     *  - Controller 어노테이션 이용
     *  - RequestMapping을 이용해 주소 매핑
     *  - HTTP 메소드 : GET
     *  - 리턴값 : "hello world"
     *  - url 주소 : /hello-world
     */
    @ResponseBody
    @RequestMapping("/hello-world")
    public String helloWorld() {

        return "hello world";
    }

    /*
     *  [ 조건 ]
     *  - Controller 어노테이션 이용
     *  - Rest을 이용해 주소 매핑
     *  - HTTP 메소드 : GET
     *  - 리턴값 : "hello spring"
     *  - url 주소 : /hello-spring
     */

}

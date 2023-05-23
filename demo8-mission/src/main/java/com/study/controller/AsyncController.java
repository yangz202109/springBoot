package com.study.controller;

import com.study.Service.AsyncService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Map;

/**
 * @author yangz
 * @create 2021-11-13-8:57
 * 使用线程
 */
@RestController
public class AsyncController {
    AsyncService asyncService;

    public AsyncController(AsyncService asyncService) {
        this.asyncService = asyncService;
    }

    @RequestMapping("/hello")
    public String hello() {
        asyncService.hello();
        return "ok";
    }

    @GetMapping("/tt/{id}/{name}")
    public void tt(@PathVariable Map<String, String> pv, @PathVariable String id, @PathVariable String name) {
        System.out.println(pv.get("id"));
        System.out.println(pv.get("name"));
    }

}

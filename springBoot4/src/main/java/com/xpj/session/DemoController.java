package com.xpj.session;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@RestController
public class DemoController {
    @Autowired
    DemoService demoService;

    @RequestMapping("testcache")
    public String testCache(@RequestParam String key) {
        String s = demoService.testCache(key);
        return s;
    }

    @RequestMapping("/getseansession")
    public Map<String, String> getSession(HttpServletRequest request) {
        Map<String, String> attributeMap = new HashMap<String, String>();
        request.getSession().setAttribute("message", request.getRequestURI());
        attributeMap.put("message", request.getRequestURI());
        System.out.println("sessionID:" + request.getSession().getId());
        return attributeMap;
    }
}
package com.github.zhanglp92.controllers;

import com.github.zhanglp92.service.MemoService;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

@Controller
@Log4j2
public class MemoController {

    @Resource(name = "memoServiceImpl")
    private MemoService memoService;

    @Resource(name = "memoServiceImpl2")
    private MemoService memoService2;

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> hello() {
        Map<String, Object> map = new HashMap<>();
        map.put("hello", "world");
        return map;
    }

    @RequestMapping(value = "/memo", method = RequestMethod.GET)
    @ResponseBody
    public String memo() {
        // return this.memoService.notInterfaceMethod();
        return this.memoService.memo();
    }
}

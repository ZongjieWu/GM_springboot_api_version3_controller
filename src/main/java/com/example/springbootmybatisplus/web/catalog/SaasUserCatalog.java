package com.example.springbootmybatisplus.web.catalog;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/saasUser")
public class SaasUserCatalog {
    @GetMapping("/jumpPaging")
    public String jumpManage(){
        return "/admin/permission/saasuser";
    }
}

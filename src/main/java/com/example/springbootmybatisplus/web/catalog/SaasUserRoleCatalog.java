package com.example.springbootmybatisplus.web.catalog;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/saasUserRoleType")
public class SaasUserRoleCatalog {
    @GetMapping("/jumpPaging")
    public String jumpManage(){
        return "/admin/permission/saasUserRoleType";
    }
    @GetMapping("/jumpSetPermission")
    public String jumpSetPermission(Long id, HttpServletRequest request){
        request.setAttribute("roleId",id);
        return "/admin/permission/setPermission";
    }
}

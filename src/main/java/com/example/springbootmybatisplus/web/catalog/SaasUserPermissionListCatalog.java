package com.example.springbootmybatisplus.web.catalog;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/saasUserPermissionList")
public class SaasUserPermissionListCatalog {
    @GetMapping("/jumpPaging")
    public String jumpManage(HttpServletRequest request){
        request.setAttribute("parentId",0);
        return "/admin/permission/saasUserPermissionListPaging";
    }

    @GetMapping("/jumpDetail")
    public String jumpDetail(Long id, HttpServletRequest request){
        request.setAttribute("parentId",id);
        return "/admin/permission/saasUserPermissionListPaging";
    }
}

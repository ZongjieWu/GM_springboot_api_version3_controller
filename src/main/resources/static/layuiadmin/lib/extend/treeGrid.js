/**

 @Name：treeGrid树状表格
 @Author：lrd
 */
layui.config({
    base: getRootPath()+"/static/layuiadmin/lib/extend/"
}).extend({
    dltable:'dltable'
}).define(['laytpl', 'laypage','dltable', 'layer', 'form'], function(exports){
    "use strict";
    var $ = layui.jquery;
    var layer = layui.layer;
    var dltable = layui.dltable;
    var MOD_NAME='treeGrid';
    var treeGrid=$.extend({},dltable);
    treeGrid._render=treeGrid.render;
    treeGrid.render=function(param){//重写渲染方法
        param.isTree=true;//是树表格
        treeGrid._render(param);
    };
    exports(MOD_NAME, treeGrid);
});


//js获取项目根路径，如： http://localhost:8083/uimcardprj
function getRootPath(){
    //获取当前网址，如： http://localhost:8083/uimcardprj/share/meun.jsp
    var curWwwPath=window.document.location.href;
    //获取主机地址之后的目录，如： uimcardprj/share/meun.jsp
    var pathName=window.document.location.pathname;
    var pos=curWwwPath.indexOf(pathName);
    //获取主机地址，如： http://localhost:8083
    var localhostPaht=curWwwPath.substring(0,pos);
    //获取带"/"的项目名，如：/uimcardprj
    var projectName=pathName.substring(0,pathName.substr(1).indexOf('/')+1);
    return(localhostPaht);
}
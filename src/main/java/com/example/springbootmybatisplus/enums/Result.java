package com.example.springbootmybatisplus.enums;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@ApiModel(description = "返回的数据")
@Data
public class Result<T> {
    /**
     * 返回实体的参数
     */
    @ApiModelProperty("返回码")
    private Integer code;
    @ApiModelProperty("返回消息")
    private String msg;
    @ApiModelProperty("返回数据")
    private T data;
    @ApiModelProperty("数据的总条数(此字段用于分页的时候用)")
    private Long count=new Long(0);//用于分页的时候表示总条数



    public Result(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Result(Integer code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    /**
     * 成功码0失败码-1
     * */
    public static Integer SUCCESS_CODE=0;
    public static Integer  FAIL_CODE=-1;

    /**
     * 返回成功
     * */
    public static Result retrunSucess(){
        return new Result<>(SUCCESS_CODE,"成功");
    }
    /**
     * 返回失败
     * */
    public static Result retrunFail(){
        return new Result<>(FAIL_CODE,"失败");
    }
    /**
     * 返回成功消息
     * */
    public static <E> Result<E> retrunSucessMsg(String msg){
        return new Result<>(SUCCESS_CODE,msg);
    }
    /**
     * 返回失败消息
     * */
    public static <E> Result<E> retrunFailMsg(String msg){
        return new Result<>(FAIL_CODE,msg);
    }
    /**
     * 返回成功消息和数据
     * */
    public static <E> Result<E> retrunSucessMsgData(E data){
        return new Result<>(SUCCESS_CODE,"成功",data);
    }
    /**
     * 返回失败消息和数据
     * */
    public static <E> Result<E> retrunFailMsgData(E data){
        return new Result<>(FAIL_CODE,"失败",data);
    }
    /**
     * 返回成功消息和数据
     * */
    public static <E> Result<E> retrunSucessMsgData(String msg,E data){
        return new Result<>(SUCCESS_CODE,"成功",data);
    }
    /**
     * 返回失败消息和数据
     * */
    public static <E> Result<E> retrunFailMsgData(String msg,E data){
        return new Result<>(FAIL_CODE,msg,data);
    }

    /**
     * 返回状态码,消息和数据
     * */
    public static <E> Result<E> retrunCodeMsgData(Integer code,String msg,E data){
        return new Result<>(code,msg,data);
    }
}

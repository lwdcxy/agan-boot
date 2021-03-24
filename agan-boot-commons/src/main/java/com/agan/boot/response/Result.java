package com.agan.boot.response;

import com.agan.boot.enums.ResultCode;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Result<T> {

    private Integer status;
    private String desc;
    private T data;


    /**
     * 成功，创建ResResult: 没data数据
     * @return
     */
    public static Result suc(){
        Result result = new Result();
        result.setResultCode(ResultCode.SUCCESS);
        return result;
    }
    /**
     * 成功，创建ResResult: 有data数据
     * @return
     */
    public static Result suc(Object data){
        Result result = new Result();
        result.setResultCode(ResultCode.SUCCESS);
        result.setData(data);
        return result;
    }
    /**
     * 失败，指定status,desc
     * @return
     */
    public static Result fail(Integer status,String desc){
        Result result = new Result();
        result.setStatus(status);
        result.setDesc(desc);
        return result;
    }

    /**
     * 失败，指定ResultCode枚举
     * @return
     */
    public static Result fail(ResultCode resultCode){
        Result result = new Result();
        result.setResultCode(resultCode);
        return result;
    }

    /**
     * 把ResultCode枚举转换为ResResult
     * @param code
     */
    private void setResultCode(ResultCode code){
        this.status = code.code();
        this.desc = code.message();
    }
}

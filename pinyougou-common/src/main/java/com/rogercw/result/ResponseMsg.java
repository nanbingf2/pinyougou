package com.rogercw.result;

import java.io.Serializable;

/**
 * @Author: rogercw
 * @Date: 2018/8/30 12:47
 * @Version 1.0
 * 响应结果类
 */
public class ResponseMsg implements Serializable {

    private boolean success;
    private String message;

    public ResponseMsg(boolean success, String message) {
        this.success = success;
        this.message = message;
    }

    public ResponseMsg() {
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}

package com.flipkart.bean;

import javax.validation.constraints.NotNull;

public class ResponseMessage {
    @NotNull
    private String msg;

    public ResponseMessage(String msg) {
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}

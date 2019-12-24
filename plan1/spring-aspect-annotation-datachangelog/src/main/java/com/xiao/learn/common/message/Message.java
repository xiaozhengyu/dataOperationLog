package com.xiao.learn.common.message;

import lombok.Data;

/**
 * @author xzy
 * @date 2019-12-24 11:45
 * 说明：
 */

@Data
public class Message {

    /**
     * 状态码（0：失败 1：成功）
     */
    public static final int STATUS_OK = 1;
    public static final int STATUS_FAIL = 0;

    /**
     * 状态信息
     */
    public static final String MESSAGE_OK = "成功";
    public static final String MESSAGE_FAIL = "失败";

    /**
     * 默认状态码、默认状态信息
     */
    public int status = STATUS_OK;
    public String message = MESSAGE_OK;

    public Message() {
    }

    public Message(int status, String message) {
        this.status = status;
        this.message = message;
    }

    public boolean isOk() {
        return this.status == STATUS_OK;
    }

    public boolean isFail() {
        return this.status == STATUS_FAIL;
    }
}

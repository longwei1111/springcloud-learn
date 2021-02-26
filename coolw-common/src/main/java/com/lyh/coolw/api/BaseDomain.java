package com.lyh.coolw.api;

import com.alibaba.fastjson.JSONObject;

import java.io.Serializable;

/**
 * @Classname BaseDomain
 * @Description
 * @Date 2021/2/2 11:10
 * @Author lw
 */
public class BaseDomain implements Serializable {

    private static final long serialVersionUID = 8094534547365664260L;

    @Override
    public String toString() {
        return JSONObject.toJSONString(this);
    }
}

package com.baidu.unbiz.dsp.archtype.rpc.impl;

import org.apache.commons.lang.StringUtils;

import com.baidu.unbiz.dsp.archtype.rpc.RpcCall;

/**
 * @author zhangxu
 */
public class LocalRpcCall implements RpcCall<String, Integer> {

    public Integer execute(String s) {
        if (StringUtils.isEmpty(s)) {
            return 0;
        }
        return s.hashCode();
    }

}

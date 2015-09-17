package com.baidu.unbiz.dsp.archtype.rpc;

/**
 * @author zhangxu
 */
public interface RpcCall<REQ, RES> {

    RES execute(REQ req);

}

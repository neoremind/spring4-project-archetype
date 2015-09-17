package com.baidu.unbiz.dsp.rpc;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.baidu.unbiz.dsp.archtype.rpc.NonGenericRpcCall;
import com.baidu.unbiz.dsp.archtype.rpc.RpcCall;

/**
 * @author zhangxu
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:applicationContext.xml"})
public class RpcCallTest {

    @Resource
    private RpcCall<String, Integer> localRpcCall;

    @Resource
    private RpcCall<String, Integer> myProxyRpcCall;

    @Resource
    private RpcCall<String, Integer> remoteRpcCallOfJdk;

    @Resource
    private NonGenericRpcCall remoteRpcCallOfJavassist;

    @Test
    public void testLocalExecute() {
        Integer i = localRpcCall.execute("123");
        System.out.println(i);
    }

    @Test
    public void testProxyExecute() {
        Integer i = myProxyRpcCall.execute("123");
        System.out.println(i);
    }

    @Test
    public void testRemoteExecuteOfJdk() {
        Integer i = remoteRpcCallOfJdk.execute("123");
        System.out.println(i);
    }

    @Test
    public void testRemoteExecuteOfJavassist() {
        Integer i = remoteRpcCallOfJavassist.execute("123");
        System.out.println(i);
    }

    /**
     * Javassist is faster than Jdk dynamic proxy by more than 2 times
     * <p/>
     * Test results:
     * <p/>
     * Jdk dynamic proxy: 247ms
     * Javassist proxy: 89ms
     * <p/>
     * Jdk dynamic proxy: 248ms
     * Javassist proxy: 91ms
     * <p/>
     * Jdk dynamic proxy: 207ms
     * Javassist proxy: 90ms
     */
    @Test
    public void testPerformance() {
        long start = System.currentTimeMillis();
        // Run 100 million times
        for (int j = 0; j < 100000000; j++) {
            remoteRpcCallOfJdk.execute("123");
        }
        System.out.println("Jdk dynamic proxy: " + (System.currentTimeMillis() - start) + "ms");

        start = System.currentTimeMillis();
        for (int j = 0; j < 100000000; j++) {
            remoteRpcCallOfJavassist.execute("123");
        }
        System.out.println("Javassist proxy: " + (System.currentTimeMillis() - start) + "ms");
    }

}

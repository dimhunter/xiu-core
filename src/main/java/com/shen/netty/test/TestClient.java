package com.shen.netty.test;

import org.junit.Test;

import java.net.URI;
import java.net.URISyntaxException;

/**
 * Created by shenluguo on 2015/6/17.
 */
public class TestClient {

    @Test
    public void test(){
//        String url = "http://dsp.gome.com.cn/decision/visitor?p=13";
        String url = "http://127.0.0.1:9991/aa/servlet/servlet1?type=upload";
        String host = null;
        try {
            URI uri = new URI(url);
            host = uri.getHost();
            System.out.println(host+"---");
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }

        try {
            NettyClient.start(host,9991);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}

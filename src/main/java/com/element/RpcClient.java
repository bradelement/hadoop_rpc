package com.element;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.ipc.RPC;

import java.io.IOException;
import java.net.InetSocketAddress;

public class RpcClient {
    public static void main(String[] args) {
        try {
            RpcInterface proxy = RPC.getProxy(
                    RpcInterface.class,
                    1,
                    new InetSocketAddress("127.0.0.1",12345),
                    new Configuration());

            int res = proxy.add(1, 2);
            System.out.println("res is " + res);

            // get name
            System.out.println("get name: " + proxy.getName("1234"));
            System.out.println("get name: " + proxy.getName("G20200579010175"));


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

package com.element;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.ipc.ProtocolSignature;
import org.apache.hadoop.ipc.RPC;

import java.io.IOException;

public class RpcServer implements RpcInterface {

    public static void main(String[] args) {
        RPC.Builder builder = new RPC.Builder(new Configuration());
        builder.setBindAddress("127.0.0.1");
        builder.setPort(12345);

        builder.setProtocol(RpcInterface.class);
        builder.setInstance(new RpcServer());

        try {
            RPC.Server server = builder.build();
            server.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public int add(int n1, int n2) {
        System.out.println("n1 = " + n1 + ", n2 = " + n2);
        return n1 + n2;
    }

    @Override
    public String getName(String number) {
        if (number.equals("G20200579010175")) {
            return "bradelement";
        }
        return null;
    }


    @Override
    public long getProtocolVersion(String s, long l) throws IOException {
        return RpcInterface.versionID;
    }

    @Override
    public ProtocolSignature getProtocolSignature(String s, long l, int i) throws IOException {
        return null;
    }
}

package com.wjy.socket.test2;

import com.wjy.util.PropertiesUtil;

import java.io.OutputStream;
import java.net.Socket;

public class SocketClient {

    private static final String HOST = PropertiesUtil.getStringValue("socket.server.host");

    private static final Integer PORT = PropertiesUtil.getIntegerValue("socket.server.port");

    private static final String CODING = PropertiesUtil.getStringValue("socket.coding");

    private static final String MESSAGE1 = "客户端 - 迟来的请求 - How are you ?";
    private static final String MESSAGE2 = "客户端 - 迟来的请求 - I'm fine, think you .";

    public static void main(String args[]) throws Exception {

        Socket socket = new Socket(HOST, PORT);

        OutputStream os = socket.getOutputStream();

        byte[] b1 = MESSAGE1.getBytes(CODING);

        os.write(b1.length >> 8);
        os.write(b1.length);
        os.write(b1);

        os.flush();

        System.out.println("client send message : " + MESSAGE1);

        byte[] b2 = MESSAGE2.getBytes(CODING);

        os.write(b2.length >> 8);
        os.write(b2.length);
        os.write(b2);

        os.flush();

        System.out.println("client send message : " + MESSAGE2);

        os.close();
        socket.close();

    }

}
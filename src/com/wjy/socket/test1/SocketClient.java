package com.wjy.socket.test1;

import com.wjy.util.PropertiesUtil;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class SocketClient {

    private static final String HOST = PropertiesUtil.getStringValue("socket.server.host");

    private static final Integer PORT = PropertiesUtil.getIntegerValue("socket.server.port");

    private static final String CODING = PropertiesUtil.getStringValue("socket.coding");

    private static final String MESSAGE = "客户端 - 迟来的请求";

    public static void main(String args[]) throws Exception {

        Socket socket = new Socket(HOST, PORT);

        OutputStream os = socket.getOutputStream();

        os.write(MESSAGE.getBytes(CODING));

        System.out.println("client send message : " + MESSAGE);

        socket.shutdownOutput();

        int len;
        byte[] b = new byte[1024];
        StringBuilder sb = new StringBuilder();

        InputStream is = socket.getInputStream();

        while ((len = is.read(b)) != -1) {

            sb.append(new String(b, 0, len, CODING));

        }

        System.out.println("client receive message : " + sb);

        is.close();
        os.close();
        socket.close();

    }

}

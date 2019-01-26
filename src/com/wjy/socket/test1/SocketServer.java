package com.wjy.socket.test1;

import com.wjy.util.PropertiesUtil;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketServer {

    private static final Integer PORT = PropertiesUtil.getIntegerValue("socket.server.port");

    private static final String CODING = PropertiesUtil.getStringValue("socket.coding");

    private static final String MESSAGE = "服务端 - 迟来的请求";

    public static void main(String[] args) throws Exception {

        ServerSocket server = new ServerSocket(PORT);

        System.out.println("ServerSocket等待中。。。");

        Socket socket = server.accept();

        int len;
        byte[] b = new byte[1024];
        StringBuilder sb = new StringBuilder();

        InputStream is = socket.getInputStream();

        while ((len = is.read(b)) != -1) {

            sb.append(new String(b, 0, len, CODING));

        }

        System.out.println("server receive message : " + sb);

        OutputStream os = socket.getOutputStream();

        os.write(MESSAGE.getBytes(CODING));

        System.out.println("server send message : " + MESSAGE);

        os.close();
        is.close();
        socket.close();
        server.close();

    }

}

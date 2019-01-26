package com.wjy.socket.test4.server;

import com.wjy.socket.test4.thread.ThreadFactoryCreate;
import com.wjy.util.PropertiesUtil;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import static java.lang.System.out;

public class WebSocketServer {

    private static final Integer PORT = PropertiesUtil.getIntegerValue("socket.server.port");

    static ThreadPoolExecutor executor = new ThreadPoolExecutor(3, 5, 1, TimeUnit.SECONDS,
            new LinkedBlockingQueue<Runnable>(), new ThreadFactoryCreate());

    static ServerSocket server = null;

    static {
        try {
            server = new ServerSocket(PORT);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void run() {

        executor.allowCoreThreadTimeOut(true);

        while (true) {

            try {

                Socket socket = server.accept();

                if (socket != null) {

                    WebSocketServerRun run = new WebSocketServerRun(socket);

                    executor.execute(run);

                }

            } catch (Exception e) {
                e.printStackTrace();
            }

        }

    }

    public static void main(String[] args) {

        out.println("聊天室等待中");

        run();

    }

}

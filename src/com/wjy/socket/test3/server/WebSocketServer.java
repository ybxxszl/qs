package com.wjy.socket.test3.server;

import com.alibaba.fastjson.JSONObject;
import com.wjy.socket.test3.bean.MsgBean;
import com.wjy.util.PropertiesUtil;

import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

import static java.lang.System.out;

public class WebSocketServer {

    private static final Integer PORT = PropertiesUtil.getIntegerValue("socket.server.port");

    private static final String CODING = PropertiesUtil.getStringValue("socket.coding");

    public static void main(String[] args) {

        try {

            run();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private static void run() throws Exception {

        ServerSocket server = null;
        Socket socket = null;
        InputStream is = null;

        out.println("聊天室等待中");

        while (true) {

            try {

                server = new ServerSocket(PORT);

                socket = server.accept();

                is = socket.getInputStream();

                byte[] b;

                while (true) {

                    int first = is.read();

                    if (first == -1) {
                        break;
                    }

                    int second = is.read();

                    b = new byte[(first << 8) + second];

                    is.read(b);

                    String msg = new String(b, CODING);

                    get(msg);

                }

            } catch (Exception e) {
                e.printStackTrace();
            } finally {

                try {
                    is.close();
                    socket.close();
                    server.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }

        }

    }

    private static void get(String msg) {

        MsgBean bean = JSONObject.parseObject(msg, MsgBean.class);

        if (bean.getType() == 1) {

            out.println(bean.getTime() + " " + bean.getName() + "进入聊天室");

        } else if (bean.getType() == 2) {

            out.println(bean.getTime() + " " + bean.getName() + "退出聊天室");

        } else if (bean.getType() == 3) {

            out.println(bean.getTime() + " " + bean.getName() + "说：" + bean.getContent());

        }

    }

}

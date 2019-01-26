package com.wjy.socket.test3.client;

import com.alibaba.fastjson.JSONObject;
import com.wjy.socket.test3.bean.MsgBean;
import com.wjy.util.PropertiesUtil;
import com.wjy.util.RandomCodeUtil;

import java.io.OutputStream;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import static java.lang.System.out;

public class WebSocketClient {

    private static final String HOST = PropertiesUtil.getStringValue("socket.server.host");

    private static final Integer PORT = PropertiesUtil.getIntegerValue("socket.server.port");

    private static final String CODING = PropertiesUtil.getStringValue("socket.coding");

    private static final String NAME = "玩家" + RandomCodeUtil.getUUID();

    public static void main(String[] args) {

        try {

            boolean flag = enter();

            if (flag) {

                run();

            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private static boolean enter() throws Exception {

        Socket socket = null;
        OutputStream os = null;

        try {

            socket = new Socket(HOST, PORT);

            os = socket.getOutputStream();

            String time = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(new Date());

            MsgBean bean = new MsgBean(NAME, time, 1);

            String msg = JSONObject.toJSONString(bean);

            byte[] b = msg.getBytes(CODING);

            os.write(b.length >> 8);
            os.write(b.length);
            os.write(b);

            os.flush();

        } catch (Exception e) {
            throw new Exception("进入聊天室失败", e);
        } finally {
            os.close();
            socket.close();
        }

        out.println(NAME + " 进入聊天室");

        return true;

    }

    private static void exit() throws Exception {

        Socket socket = null;
        OutputStream os = null;

        try {

            socket = new Socket(HOST, PORT);

            os = socket.getOutputStream();

            String time = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(new Date());

            MsgBean bean = new MsgBean(NAME, time, 2);

            String msg = JSONObject.toJSONString(bean);

            byte[] b = msg.getBytes(CODING);

            os.write(b.length >> 8);
            os.write(b.length);
            os.write(b);

            os.flush();

        } catch (Exception e) {
            throw new Exception("退出聊天室失败", e);
        } finally {
            os.close();
            socket.close();
        }

        out.println(NAME + " 退出聊天室");

    }

    private static void run() throws Exception {

        boolean flag = false;

        Socket socket = null;
        OutputStream os = null;

        while (true) {

            try {

                socket = new Socket(HOST, PORT);

                os = socket.getOutputStream();

                byte[] b;

                while (true) {

                    @SuppressWarnings("resource")
                    Scanner scanner = new Scanner(System.in);

                    String content = scanner.nextLine();

                    if ("exit".equals(content)) {

                        exit();

                        flag = true;

                        continue;

                    }

                    String time = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(new Date());

                    MsgBean bean = new MsgBean(NAME, content, time, 3);

                    String msg = JSONObject.toJSONString(bean);

                    b = msg.getBytes(CODING);

                    os.write(b.length >> 8);
                    os.write(b.length);
                    os.write(b);

                    os.flush();

                }

            } catch (Exception e) {
                e.printStackTrace();
            } finally {

                try {
                    os.close();
                    socket.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }

            if (flag) {
                break;
            }

        }

    }

}

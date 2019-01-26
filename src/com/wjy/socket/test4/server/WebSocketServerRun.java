package com.wjy.socket.test4.server;

import com.alibaba.fastjson.JSONObject;
import com.wjy.socket.test4.bean.MsgBean;
import com.wjy.util.PropertiesUtil;

import java.io.InputStream;
import java.net.Socket;
import java.util.concurrent.TimeUnit;

import static java.lang.System.out;

public class WebSocketServerRun implements Runnable {

    private static final String CODING = PropertiesUtil.getStringValue("socket.coding");

    private Socket socket;

    public WebSocketServerRun(Socket socket) {
        super();
        this.socket = socket;
    }

    @Override
    public void run() {

        InputStream is = null;

        while (true) {

            try {

                is = socket.getInputStream();

                byte[] b;

                int first = is.read();

                if (first != -1) {

                    int second = is.read();

                    b = new byte[(first << 8) + second];

                    is.read(b);

                    String msg = new String(b, CODING);

                    MsgBean bean = JSONObject.parseObject(msg, MsgBean.class);

                    get(bean);

                    if (bean.getType() == 2) {

                        is.close();
                        socket.close();

                        break;

                    }

                } else {

                    TimeUnit.SECONDS.sleep(2);

                }

            } catch (Exception e) {
                e.printStackTrace();
            }

        }

    }

    private void get(MsgBean bean) {

        if (bean.getType() == 1) {

            out.println(bean.getTime() + " " + bean.getName() + "进入聊天室");

        } else if (bean.getType() == 2) {

            out.println(bean.getTime() + " " + bean.getName() + "退出聊天室");

        } else if (bean.getType() == 3) {

            out.println(bean.getTime() + " " + bean.getName() + "说：" + bean.getContent());

        }

    }

}

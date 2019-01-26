package com.wjy.socket.test4.bean;

public class MsgBean {

    private String name;
    private String content;
    private String time;
    private Integer type;// 1 进入 2 退出 3 聊天内容

    public MsgBean() {
        super();
    }

    public MsgBean(String name, String time, Integer type) {
        super();
        this.name = name;
        this.time = time;
        this.type = type;
    }

    public MsgBean(String name, String content, String time, Integer type) {
        super();
        this.name = name;
        this.content = content;
        this.time = time;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "MsgBean [name=" + name + ", content=" + content + ", time=" + time + ", type=" + type + "]";
    }

}

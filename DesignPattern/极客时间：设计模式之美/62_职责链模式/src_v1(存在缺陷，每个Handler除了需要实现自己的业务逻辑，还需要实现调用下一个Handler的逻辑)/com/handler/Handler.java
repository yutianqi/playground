package com.handler;

public abstract class Handler {
    protected Handler successor = null;

    public void setSuccessor(Handler successor) {
        this.successor = successor;
    }
    // 存在缺陷，每个Handler除了需要实现自己的业务逻辑，还需要实现调用下一个Handler的逻辑
    public abstract void handle();

}
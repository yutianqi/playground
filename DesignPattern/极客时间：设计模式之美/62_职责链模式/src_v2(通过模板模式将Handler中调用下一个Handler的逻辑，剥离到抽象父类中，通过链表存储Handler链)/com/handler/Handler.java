package com.handler;

public abstract class Handler {
    protected Handler successor = null;

    public void setSuccessor(Handler successor) {
        this.successor = successor;
    }

    public abstract boolean subHandle();

    public void handle() {
        if (!subHandle() && this.successor != null) {
            this.successor.handle();
        }
    }

}
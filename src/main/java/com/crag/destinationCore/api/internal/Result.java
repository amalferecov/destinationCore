package com.crag.destinationCore.api.internal;

/**
 * Created by heisenberg on 7/9/18.
 */
public class Result {
    private int Status;
    private String Message;

    public Result(int status, String message) {
        Status = status;
        Message = message;
    }

    public Result() {
    }

    public int getStatus() {
        return Status;
    }

    public void setStatus(int status) {
        Status = status;
    }

    public String getMessage() {
        return Message;
    }

    public void setMessage(String message) {
        Message = message;
    }
}

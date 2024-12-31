package com.voipplus.mmsclient.handlers;

public class ServerFirstResponse {
    public boolean success;
    public String data;

    public ServerFirstResponse(boolean success, String data) {
        this.success = success;
        this.data = data;
    }
}

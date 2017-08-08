package com.iwilley.b1ec2.api.internal.util.json;

public interface JSONErrorListener {
    void start(String text);
    void error(String message, int column);
    void end();
}


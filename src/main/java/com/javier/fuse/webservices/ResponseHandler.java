package com.javier.fuse.webservices;

/**
 * Created by javiergonzalezcabezas on 16/6/15.
 */
public interface ResponseHandler {

    public void sendResponseSusccesful(String response);
    public void sendResponseFail(String error);
}

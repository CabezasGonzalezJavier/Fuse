package com.javier.fuse.webservices;

/**
 * Created by javiergonzalezcabezas on 15/6/15.
 */
public class CommandFactory {

    public static Command createGetCommand(String mUrl, ResponseHandler handler){

        Request request = RequestFactory.createResponseListener();
        return new GetCommand(mUrl,request, handler);

    }


}

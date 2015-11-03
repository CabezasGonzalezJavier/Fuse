package com.javier.fuse.webservices;

/**
 * Created by javiergonzalezcabezas on 29/07/15.
 */
public class RequestFactory {

    private static RequestImpl sRequestImpl;

    public static Request createResponseListener(){
        if (sRequestImpl == null){
            sRequestImpl = new RequestImpl();
        }
        return  sRequestImpl;
    }

    public static void setMockRequest(RequestImpl requestImpl){
        sRequestImpl = requestImpl;

    }

}

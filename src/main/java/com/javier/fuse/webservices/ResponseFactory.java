package com.javier.fuse.webservices;

/**
 * Created by javiergonzalezcabezas on 28/07/15.
 */
public class ResponseFactory {

    public static ResponseListener createResponseListener(ResponseHandler responseHandler){
        return new ResponseImpl(responseHandler);
    }
}

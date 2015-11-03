package com.javier.fuse.requesttask;

import com.javier.fuse.utils.Constants;
import com.javier.fuse.webservices.ResponseListener;

/**
 * Created by javiergonzalezcabezas on 15/6/15.
 */
public class ClientHTTPImpl  implements ClientHTTP {

    private ResponseListener mListener;

    private ClientAsyncTask mAsyncTaskClient;


    public ClientHTTPImpl(ResponseListener listener){
        mListener = listener;
        this.mAsyncTaskClient = new ClientAsyncTaskImpl();
    }



    @Override
    public void get(String url) {

        mAsyncTaskClient.executeAsync(mListener, url, Constants.TYPE_STRING_GET);
    }

    @Override
    public void post(String url) {

    }

    @Override
    public void put(String url) {

    }

    @Override
    public void delete(String url) {

    }
}

package com.javier.fuse.webservices;

/**
 * Created by javiergonzalezcabezas on 12/6/15.
 */
public class GetCommand implements Command {


    private String mUrl;
    private ResponseHandler mHandler;
    private Request mRequestImpl;

    public GetCommand(String url,Request httpClient,  ResponseHandler handler) {
        this.mUrl = url;
        this.mHandler = handler;
        this.mRequestImpl = httpClient;
    }

    @Override
    public void execute() {

        mRequestImpl.performGetRequest(mUrl, mHandler);

    }

}

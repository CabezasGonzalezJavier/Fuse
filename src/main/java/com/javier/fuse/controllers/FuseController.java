package com.javier.fuse.controllers;

import android.util.Log;

import com.javier.fuse.modelclient.FuseClient;
import com.javier.fuse.service.FuseServiceImpl;
import com.javier.fuse.webservices.FuseResponseHandler;
import com.javier.fuse.webservices.FuseResponseListener;

/**
 * Created by javiergonzalezcabezas on 3/11/15.
 */
public class FuseController implements FuseResponseHandler{
    private FuseResponseListener mListener;

    public FuseController(FuseResponseListener mListener) {
        this.mListener = mListener;
    }

    public void request(String string) {
        FuseServiceImpl receiver = new FuseServiceImpl();
        receiver.getFuse(this, string);

    }

    @Override
    public void handlFuse(FuseClient fuseClient) {
        mListener.onSuccess(fuseClient);
    }

    @Override
    public void sendResponseFail(String error) {
        mListener.onError(error);
    }

}

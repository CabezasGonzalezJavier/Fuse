package com.javier.fuse.webservices;

import com.javier.fuse.modelclient.FuseClient;

/**
 * Created by javiergonzalezcabezas on 3/11/15.
 */
public interface FuseResponseListener {
    public void onSuccess(FuseClient successResponse);
    public void onError(String errorResponse);
}

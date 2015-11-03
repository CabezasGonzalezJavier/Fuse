package com.javier.fuse.webservices;

import com.javier.fuse.modelclient.FuseClient;

/**
 * Created by javiergonzalezcabezas on 3/11/15.
 */
public interface FuseResponseHandler {
    public void handlFuse(FuseClient fuseClient);
    public void sendResponseFail(String error);
}

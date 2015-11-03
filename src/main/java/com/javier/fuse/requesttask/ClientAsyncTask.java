package com.javier.fuse.requesttask;

import com.javier.fuse.models.Response;
import com.javier.fuse.webservices.ResponseListener;

/**
 * Created by javiergonzalezcabezas on 15/7/15.
 */
public interface ClientAsyncTask {

    public void executeAsync(ResponseListener mListener, String url, String type);
    public Response callClient(final String url, final String type);
}

package com.javier.fuse.webservices;


/**
 * Created by javiergonzalezcabezas on 15/6/15.
 */
public interface ResponseListener {

    public void onSuccess(final String successResponse);
    public void onError(final String errorResponse);
    public void onGeneralError();
}

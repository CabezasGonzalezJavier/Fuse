package com.javier.fuse.controllers;

import com.javier.fuse.webservices.FuseResponseListener;

/**
 * Created by javiergonzalezcabezas on 3/11/15.
 */
public class FuseControllerFactory {

    private static FuseController sFuseController;
    private static FuseResponseListener sListener;

    public static  void setResponseListerner(FuseResponseListener responseListener) {
        sListener = responseListener;
    }

    public static FuseController getsFuseController() {
        if (sFuseController == null) {
            sFuseController = new FuseController(sListener);
        }
        return sFuseController;
    }

}

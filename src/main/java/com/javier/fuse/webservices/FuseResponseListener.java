package com.javier.fuse.webservices;

import com.javier.fuse.models.Fuse;

/**
 * Created by javiergonzalezcabezas on 3/11/15.
 */
public interface FuseResponseListener {
    public void onSuccess(final Fuse successResponse);
    public void onError(final String errorResponse);
}

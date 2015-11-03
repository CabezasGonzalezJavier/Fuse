package com.javier.fuse;

import com.javier.fuse.webservices.ResponseHandler;
import com.javier.fuse.webservices.ResponseImpl;
import com.javier.fuse.webservices.ResponseListener;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

/**
 * Created by javiergonzalezcabezas on 3/11/15.
 */
public class ResponseTest {
    public ResponseListener mResponseListener;
    public ResponseHandler mockResponseHandler;
    public String onGeneralError;
    public String mResponse;

    @Before
    public void setup() {
        mockResponseHandler = mock(ResponseHandler.class);
        mResponseListener = new ResponseImpl(mockResponseHandler);
        onGeneralError = "error General";
        mResponse = "response";
    }

    @Test
    public void testResponseTestGeneralError(){
        mResponseListener.onGeneralError();
        verify(mockResponseHandler).sendResponseFail(onGeneralError);

    }

    @Test
    public void testResponseTestFail(){
        mResponseListener.onError(mResponse);
        assertNotNull(mResponse);
        assertTrue(mResponse.equals("response"));
        verify(mockResponseHandler).sendResponseFail(mResponse);
    }

    @Test
    public void testResponseTestSuccess(){
        mResponseListener.onSuccess(mResponse);
        assertNotNull(mResponse);
        assertTrue(mResponse.equals("response"));
        verify(mockResponseHandler).sendResponseSusccesful(mResponse);
    }
}

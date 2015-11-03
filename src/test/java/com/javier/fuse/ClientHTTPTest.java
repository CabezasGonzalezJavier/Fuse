package com.javier.fuse;

import com.javier.fuse.models.Response;
import com.javier.fuse.requesttask.ClientAsyncTask;
import com.javier.fuse.requesttask.ClientAsyncTaskImpl;
import com.javier.fuse.requesttask.HttpURLConnectionFactory;
import com.javier.fuse.utils.Constants;

import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.ProtocolException;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by javiergonzalezcabezas on 3/11/15.
 */
public class ClientHTTPTest {
    public ClientAsyncTask mClientAsyncTask;

    private HttpURLConnection mockConnection;

    String mUrl;
    String mType;

    @Before
    public void setup() {

        mClientAsyncTask = new ClientAsyncTaskImpl();

        mUrl = Constants.URL;
        mType = Constants.TYPE_STRING_GET;

    }

    @Test
    public void setClientHTTPWithOnPostExecuteSuccess() {

        mockConnection = mock(HttpURLConnection.class);

        try {
            when(mockConnection.getInputStream()).thenReturn(new ByteArrayInputStream("Hello".getBytes()));
        } catch (IOException e) {
            e.printStackTrace();
        }

        HttpURLConnectionFactory.setHttpURLConnection(mockConnection);

        Response response = mClientAsyncTask.callClient(mUrl,mType);

        try {
            verify(mockConnection).setRequestMethod(mType);
        } catch (ProtocolException e) {
            e.printStackTrace();
        }

        assertNotNull(response);
        assertFalse(response.isInterneterror());
        assertTrue(response.getInfo() != null);
        assertTrue(response.getInfo().equals("Hello"));
    }

    @Test
    public void setClientHTTPWithOnPostExecuteFailure() {

        mockConnection = mock(HttpURLConnection.class);

        try {
            when(mockConnection.getInputStream()).thenThrow(new IOException());
        } catch (IOException e) {
            e.printStackTrace();
        }

        HttpURLConnectionFactory.setHttpURLConnection(mockConnection);



        Response response = mClientAsyncTask.callClient(mUrl,mType);

        assertNotNull(response);
        assertTrue(response.isInterneterror());
        assertTrue(response.getInfo() == null);
    }

}

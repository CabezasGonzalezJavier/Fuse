package com.javier.fuse;

import com.javier.fuse.webservices.Command;
import com.javier.fuse.webservices.GetCommand;
import com.javier.fuse.webservices.RequestImpl;
import com.javier.fuse.webservices.ResponseHandler;

import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

/**
 * Created by javiergonzalezcabezas on 3/11/15.
 */
public class GetCommandTest {

    @Test
    public void testGetCommandPerformsRequest() {

        String url = "SomeURL";
        String type;
        ResponseHandler handler = mock(ResponseHandler.class);

        RequestImpl mockClient = mock(RequestImpl.class);

        Command command = new GetCommand(url, mockClient, handler);

        command.execute();

        verify(mockClient).performGetRequest(url, handler);
    }

    @Test
    public void testGetCommandCallsHandlerWithSuccessfulResponse() {

        String url = "SomeURL";
        String type;
        ResponseHandler handler = mock(ResponseHandler.class);

        RequestImpl mockClient = mock(RequestImpl.class);

        GetCommand command = new GetCommand(url, mockClient, handler);

        command.execute();

        verify(mockClient).performGetRequest(url, handler);
    }

    @Test
    public void testGetCommandCallsHandlerWithFailureResponse() {

        String url = "SomeURL";
        String type;
        ResponseHandler handler = mock(ResponseHandler.class);

        RequestImpl mockClient = mock(RequestImpl.class);

        GetCommand command = new GetCommand(url, mockClient, handler);

        command.execute();

        verify(mockClient).performGetRequest(url, handler);
    }
}

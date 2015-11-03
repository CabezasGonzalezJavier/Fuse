package com.javier.fuse;

import com.javier.fuse.utils.Constants;
import com.javier.fuse.webservices.Command;
import com.javier.fuse.webservices.CommandFactory;
import com.javier.fuse.webservices.GetCommand;
import com.javier.fuse.webservices.RequestFactory;
import com.javier.fuse.webservices.RequestImpl;
import com.javier.fuse.webservices.ResponseHandler;
import com.javier.fuse.webservices.ResponseImpl;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;

/**
 * Created by javiergonzalezcabezas on 3/11/15.
 */
public class CommandFactoryTest {
    String mUrl;
    int mType;
    ResponseHandler mockResponseHandler;
    GetCommand mockGetCommand;
    CommandFactory mCommandFactory;
    ResponseImpl mockResponseImpl;

    RequestImpl mockRequestImpl;

    @Before
    public void setup() {
        mUrl = Constants.URL;
        mockGetCommand = mock(GetCommand.class);
        mockResponseImpl = mock(ResponseImpl.class);


        mCommandFactory = new CommandFactory();
        mockResponseHandler = mock(ResponseHandler.class);
        mockRequestImpl = mock(RequestImpl.class);
        RequestFactory.setMockRequest(mockRequestImpl);
    }

    @Test
    public void commandFactoryTestNotNull(){
        Command command = mCommandFactory.createGetCommand(mUrl, mockResponseHandler);
        assertNotNull(command);
        assertTrue(command.getClass().equals(GetCommand.class));
    }

}

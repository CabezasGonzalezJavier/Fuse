package com.javier.fuse.service;

import com.google.gson.Gson;
import com.javier.fuse.modelclient.FuseClient;
import com.javier.fuse.models.Fuse;
import com.javier.fuse.utils.Constants;
import com.javier.fuse.webservices.CommandFactory;
import com.javier.fuse.webservices.FuseResponseHandler;
import com.javier.fuse.webservices.ResponseHandler;

/**
 * Created by javiergonzalezcabezas on 3/11/15.
 */
public class FuseServiceImpl implements FuseService {

    public FuseServiceImpl() {
    }

    private CommandFactory mCommandFactory = new CommandFactory();

    @Override
    public void getFuse(final FuseResponseHandler fuseResponseHandler, String string) {
        ResponseHandler handler = new ResponseHandler() {
            @Override
            public void sendResponseSusccesful(String response) {
                Gson gson = new Gson();
                Fuse fuse = gson.fromJson(response, Fuse.class);
                fuseResponseHandler.handlFuse(convertFuseResultToFuseClient(fuse));
            }

            @Override
            public void sendResponseFail(String error) {
                fuseResponseHandler.sendResponseFail(error);
            }
        };
        mCommandFactory.createGetCommand(getURL(string), handler).execute();
    }

    public FuseClient convertFuseResultToFuseClient(Fuse result) {

        FuseClient fuseClient = new FuseClient();

        fuseClient.setCustomColor(result.getCustomColor());
        fuseClient.setEnabled(result.getPasswordChanging().getEnabled());
        fuseClient.setLogo(result.getLogo());
        fuseClient.setName(result.getName());
        fuseClient.setSecureField(result.getPasswordChanging().getSecureField());

        return fuseClient;
    }

    public String getURL(String string) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(Constants.URL_BEFORE);
        stringBuilder.append(string);
        stringBuilder.append(Constants.URL_AFTER);
        return stringBuilder.toString();
    }

}

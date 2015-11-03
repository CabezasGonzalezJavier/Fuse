package com.javier.fuse.requesttask;

import com.javier.fuse.webservices.ResponseListener;

/**
 * Created by javiergonzalezcabezas on 29/07/15.
 */
public class ClientHTTPFactory {

    private static ClientHTTP sClientHTTP;
    private static boolean sHasMockClient;

    public static ClientHTTP createResponseListener(ResponseListener responseListener){

        if (!sHasMockClient){
            sClientHTTP = new ClientHTTPImpl(responseListener);
        }else{
            sHasMockClient=false;
        }
        return sClientHTTP;
    }


    public static void setMockClientHTTP(ClientHTTP clientHTTP){
        sClientHTTP = clientHTTP;
        sHasMockClient = true;
    }

}

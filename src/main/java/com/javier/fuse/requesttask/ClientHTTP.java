package com.javier.fuse.requesttask;

/**
 * Created by javiergonzalezcabezas on 13/7/15.
 */
public interface ClientHTTP {

    void get(String url);
    void post(String url);
    void put(String url);
    void delete(String url);
}
package com.javier.fuse.modelclient;

import com.google.gson.annotations.Expose;

/**
 * Created by javiergonzalezcabezas on 3/11/15.
 */
public class FuseClient {
    @Expose
    private String name;
    @Expose
    private String logo;
    @Expose
    private String customColor;
    @Expose
    private Boolean enabled;
    @Expose
    private Object secureField;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getCustomColor() {
        return customColor;
    }

    public void setCustomColor(String customColor) {
        this.customColor = customColor;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    public Object getSecureField() {
        return secureField;
    }

    public void setSecureField(Object secureField) {
        this.secureField = secureField;
    }
}

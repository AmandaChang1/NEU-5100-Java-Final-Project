package com.neu.jan17.data;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.TreeSet;

public class Dealer {
    private String id;
    private String name;
    private String url;
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getUrl() {
        return url;
    }
    public void setUrl(String url) {
        this.url = url;
    }
}


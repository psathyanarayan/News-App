package com.news;

public class ModelNews {
    String newTitle,newDes,newimg,newurl;

    public String getNewTitle() {
        return newTitle;
    }

    public String getNewDes() {
        return newDes;
    }

    public String getNewimg() {
        return newimg;
    }

    public String getNewurl() {
        return newurl;
    }

    public ModelNews(String newTitle, String newDes, String newimg, String newurl) {
        this.newTitle = newTitle;
        this.newDes = newDes;
        this.newimg = newimg;
        this.newurl = newurl;
    }
}

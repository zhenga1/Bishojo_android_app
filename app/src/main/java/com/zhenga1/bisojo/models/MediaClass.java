package com.zhenga1.bisojo.models;

public class MediaClass {
    private String description, title,date, userid,post_categories,postid,view,uname,mediaurl,thumbnail;
    public MediaClass(){

    }
    public MediaClass(String description, String title, String date, String userid, String post_categories, String postid, String view, String uname, String mediaurl, String thumbnail){

        this.description = description;
        this.title = title;
        this.date = date;
        this.userid = userid;
        this.post_categories = post_categories;
        this.postid = postid;
        this.view = view;
        this.uname = uname;
        this.mediaurl = mediaurl;
        this.thumbnail = thumbnail;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getPost_categories() {
        return post_categories;
    }

    public void setPost_categories(String post_categories) {
        this.post_categories = post_categories;
    }

    public String getPostid() {
        return postid;
    }

    public void setPostid(String postid) {
        this.postid = postid;
    }

    public String getView() {
        return view;
    }

    public void setView(String view) {
        this.view = view;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getMediaurl() {
        return mediaurl;
    }

    public void setMediaurl(String mediaurl) {
        this.mediaurl = mediaurl;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }
}

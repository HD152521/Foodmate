package com.seong.foodmate.foodmate.vo;

import java.sql.Date;

import lombok.Data;

@Data
public class PostVO {
    private int no;
    private String user_Id;
    private String title;
    private String content;
    private double latitude;
    private double longitude;
    private String createdAt;
    private boolean status;
    private String post_ID;

    public String getPost_ID() {
        return this.post_ID;
    }

    public void setPost_ID(String post_ID) {
        this.post_ID = post_ID;
    }

    public int getNo() {
        return this.no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getUser_Id() {
        return this.user_Id;
    }

    public void setUser_Id(String user_Id) {
        this.user_Id = user_Id;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return this.content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public double getLatitude() {
        return this.latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return this.longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public String getCreatedAt() {
        return this.createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public boolean isStatus() {
        return this.status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "PostVO [no=" + no + ", user_Id=" + user_Id + ", title=" + title + ", content=" + content + ", latitude="
                + latitude + ", longitude=" + longitude + ", createdAt=" + createdAt + ", status=" + status +", post_id="+post_ID +"]";
    }
}

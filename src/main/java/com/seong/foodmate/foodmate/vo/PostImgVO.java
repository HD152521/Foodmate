package com.seong.foodmate.foodmate.vo;

import lombok.Data;

@Data
public class PostImgVO {
    private String post_id;
    private String imgUrl;
    private boolean status;
    private String createdAt;

    public String getPost_id() {
        return this.post_id;
    }

    public void setPost_id(String post_id) {
        this.post_id = post_id;
    }

    public String getImgUrl() {
        return this.imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public boolean isStatus() {
        return this.status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getCreatedAt() {
        return this.createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public String toString() {
        return "PostImgVO [post_id=" + post_id + ", imgUrl=" + imgUrl + ", status=" + status + ", createdAt="
                + createdAt + "]";
    }

}
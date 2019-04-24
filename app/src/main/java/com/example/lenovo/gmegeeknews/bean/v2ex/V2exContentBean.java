package com.example.lenovo.gmegeeknews.bean.v2ex;

public class V2exContentBean {
    private String image;
    private String member;
    private String time_reply;
    private String node;
    private String count_livid;
    private String max_text;

    @Override
    public String toString() {
        return "V2exContentBean{" +
                "image='" + image + '\'' +
                ", member='" + member + '\'' +
                ", time_reply='" + time_reply + '\'' +
                ", node='" + node + '\'' +
                ", count_livid='" + count_livid + '\'' +
                ", max_text='" + max_text + '\'' +
                '}';
    }

    public V2exContentBean() {
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getMember() {
        return member;
    }

    public void setMember(String member) {
        this.member = member;
    }

    public String getTime_reply() {
        return time_reply;
    }

    public void setTime_reply(String time_reply) {
        this.time_reply = time_reply;
    }

    public String getNode() {
        return node;
    }

    public void setNode(String node) {
        this.node = node;
    }

    public String getCount_livid() {
        return count_livid;
    }

    public void setCount_livid(String count_livid) {
        this.count_livid = count_livid;
    }

    public String getMax_text() {
        return max_text;
    }

    public void setMax_text(String max_text) {
        this.max_text = max_text;
    }

    public V2exContentBean(String image) {
        this.image = image;
    }

    public V2exContentBean(String image, String member, String time_reply, String node, String count_livid, String max_text) {

        this.image = image;
        this.member = member;
        this.time_reply = time_reply;
        this.node = node;
        this.count_livid = count_livid;
        this.max_text = max_text;
    }
}

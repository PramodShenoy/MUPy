package com.example.gilgamesh.mupy;

import java.io.Serializable;

public class Speaker implements Serializable{

    String topic,time,speaker,venue,about,desc,image,type;

    public Speaker(String topic, String time, String speaker, String venue, String about, String desc, String image,String type) {
        this.topic = topic;
        this.time = time;
        this.speaker = speaker;
        this.venue = venue;
        this.about = about;
        this.desc = desc;
        this.image = image;
        this.type = type;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getSpeaker() {
        return speaker;
    }

    public void setSpeaker(String speaker) {
        this.speaker = speaker;
    }

    public String getVenue() {
        return venue;
    }

    public void setVenue(String venue) {
        this.venue = venue;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}

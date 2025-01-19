package com.example.mymatnasbz;

public class Classes {

        private long id;
        private String name;
        private String desc;
        private byte[] picture;

    public Classes( String name, String desc, byte[] picture) {
        this.id = 0;
        this.name = name;
        this.desc = desc;
        this.picture = picture;
    }

    public Classes( long id,String name, String desc, byte[] picture) {
        this.id = id;
        this.name = name;
        this.desc = desc;
        this.picture = picture;
    }

    public Classes( long id,String name, String desc) {
        this.id = id;
        this.name = name;
        this.desc = desc;
    }
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public byte[] getPicture() {
        return picture;
    }

    public void setPicture(byte[] picture) {
        this.picture = picture;
    }
}

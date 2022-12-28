package com.bean;

public class CatRecord {
    private int record_id;
    private int cat_id;
    private String username;
    private String cat_position;
    private String record_time;
    private String last_update;

    public CatRecord() {
    }

    public CatRecord(int record_id, int cat_id, String username, String cat_position, String record_time, String last_update) {
        this.record_id = record_id;
        this.cat_id = cat_id;
        this.username = username;
        this.cat_position = cat_position;
        this.record_time = record_time;
        this.last_update = last_update;
    }

    public int getRecord_id() {
        return record_id;
    }

    public int getCat_id() {
        return cat_id;
    }

    public String getUsername() {
        return username;
    }

    public String getCat_position() {
        return cat_position;
    }

    public String getRecord_time() {
        return record_time;
    }

    public String getLast_update() {
        return last_update;
    }
}

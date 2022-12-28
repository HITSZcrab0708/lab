package com.bean;

public class CatInfo {
    private int cat_id;
    private String cat_name;
    private int cat_breed;
    private int cat_color;
    private int cat_character;
    private String cat_position;
    private int cat_count;

    public CatInfo(){}

    public CatInfo(int cat_id, String cat_name, int cat_breed, int cat_color, int cat_character, String cat_position, int cat_count) {
        this.cat_id = cat_id;
        this.cat_name = cat_name;
        this.cat_breed = cat_breed;
        this.cat_color = cat_color;
        this.cat_character = cat_character;
        this.cat_position = cat_position;
        this.cat_count = cat_count;
    }

    public int getCat_id() {
        return cat_id;
    }

    public String getCat_name() {
        return cat_name;
    }

    public String getCat_breed() {
        switch(cat_breed)
        {
            case 1:
                return "英国短毛";
            case 2:
                return "异国短毛";
            case 3:
                return "伯曼";
            case 4:
                return "阿比西尼亚";
            case 5:
                return "苏格兰折耳";
            case 6:
                return "缅因";
        }
        return null;
    }

    public String getCat_color() {
        switch(cat_color)
        {
            case 1:
                return "黑";
            case 2:
                return "白";
            case 3:
                return "灰";
            case 4:
                return "黄";
            case 5:
                return "蓝";
        }
        return null;
    }

    public String getCat_character() {
        switch(cat_character)
        {
            case 1:
                return "勇敢";
            case 2:
                return "调皮";
            case 3:
                return "慎重";
            case 4:
                return "浮躁";
            case 5:
                return "实干";
        }
        return null;
    }

    public String getCat_position() {
        return cat_position;
    }

    public int getCat_count() {
        return cat_count;
    }
}

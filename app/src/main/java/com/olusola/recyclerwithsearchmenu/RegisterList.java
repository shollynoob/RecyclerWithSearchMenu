package com.olusola.recyclerwithsearchmenu;

public class RegisterList {
    private String names;
    private int image_id;

    public RegisterList(String names, int image_id) {
        this.setNames(names);
        this.setImage_id(image_id);
    }



    public String getNames() {
        return names;
    }

    public void setNames(String names) {
        this.names = names;
    }

    public int getImage_id() {
        return image_id;
    }

    public void setImage_id(int image_id) {
        this.image_id = image_id;
    }

}

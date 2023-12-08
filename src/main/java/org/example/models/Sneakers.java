package org.example.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Sneakers {

    @Id
    private long id;
    private String image;
    private String title;
    private float price;

    public Sneakers(long id, String image, String title, float price) {
        this.id = id;
        this.image = image;
        this.title = title;
        this.price = price;
    }

    public Sneakers(){

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
}

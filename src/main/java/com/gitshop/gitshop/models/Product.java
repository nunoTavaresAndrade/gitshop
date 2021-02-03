package com.gitshop.gitshop.models;


import javax.persistence.*;

@Entity
@Table(name = "product")

public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String title;
    private String description;
    private String imgSrc;
    private String categorie;
    private float price;




    public Product() {

    }

    public Product( String title, String description, String imgSrc, String categorie, float price) {

        this.title = title;
        this.description = description;
        this.imgSrc = imgSrc;
        this.categorie = categorie;
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImgSrc() {
        return imgSrc;
    }

    public void setImgSrc(String imgSrc) {
        this.imgSrc = imgSrc;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }


    public String getCategorie() {
        return categorie;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", imgSrc='" + imgSrc + '\'' +
                ", categorie='" + categorie + '\'' +
                ", price=" + price +
                '}';
    }
}

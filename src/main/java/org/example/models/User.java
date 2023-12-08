package org.example.models;

import jakarta.persistence.*;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String firstname;
    private String secondname;
    private String email;
    private String password;
    @OneToOne
    @JoinColumn(name = "cart_id")
    private Cart cart;

    @OneToOne
    @JoinColumn(name = "favouriteList_id")
    private FavouriteList favouriteList;

    public User(Long id, String firstname, String secondname, String email, String password) {
        this.id = id;
        this.firstname = firstname;
        this.secondname = secondname;
        this.email = email;
        this.password = password;
        this.cart = new Cart();
        this.favouriteList = new FavouriteList();
    }

    public User () {

    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getSecondname() {
        return secondname;
    }

    public void setSecondname(String secondname) {
        this.secondname = secondname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    public FavouriteList getFavouriteList() {
        return favouriteList;
    }

    public void setFavouriteList(FavouriteList favouriteList) {
        this.favouriteList = favouriteList;
    }
}

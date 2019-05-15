package com.ryzananda.steaksurabaya.Activity.Fragment;

public class Data {
    private String username, hp, password, email, alamat, tgl_lahir;

    public Data() {
    }

    public Data(String username, String hp, String password, String email, String alamat, String tgl_lahir) {
        this.username = username;
        this.hp = hp;
        this.password = password;
        this.email = email;
        this.alamat = alamat;
        this.tgl_lahir = tgl_lahir;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getHp() {
        return hp;
    }

    public void setHp(String hp) {
        this.hp = hp;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.hp = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getTgl_lahir() {
        return tgl_lahir;
    }

    public void setTgl_lahir(String tgl_lahir) {
        this.tgl_lahir = tgl_lahir;
    }
}
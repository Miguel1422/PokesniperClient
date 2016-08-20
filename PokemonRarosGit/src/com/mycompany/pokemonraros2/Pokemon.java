package com.mycompany.pokemonraros2;

import java.util.Date;

public class Pokemon {

    private String name;
    private double lat;
    private double lon;
    private Date restante;
    private String ico;
    private boolean iv;

    public Pokemon(String name, double lat, double lon, Date restante, String ico, boolean iv) {
        this.name = name;
        this.lat = lat;
        this.lon = lon;
        this.restante = restante;
        this.ico = ico;
        this.iv = iv;
    }

    public Pokemon(double lat, double lon) {
        this("Default", lat, lon, new Date(), "nada", false);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLon() {
        return lon;
    }

    public void setLon(double lon) {
        this.lon = lon;
    }

    public Date getRestante() {
        return restante;
    }

    public void setRestante(Date restante) {
        this.restante = restante;
    }

    public String getIco() {
        return ico;
    }

    public void setIco(String ico) {
        this.ico = ico;
    }

    public boolean isIv() {
        return iv;
    }

    public void setIv(boolean iv) {
        this.iv = iv;
    }

    @Override
    public String toString() {
        return name + " " + lat + "," + lon;
    }
}

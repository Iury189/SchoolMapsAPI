package com.example.testmaps;
// Classe Local
public class Local {
	// Atributos
    private String nome;
    private double latitude, longitude;

    public String getNome() { return nome; }

    public void setNome(String nome) { this.nome = nome; }

    public double getLatitude() { return latitude; }

    public void setLatitude(double latitude) { this.latitude = latitude; }

    public double getLongitude() { return longitude; }

    public void setLongitude(double longitude) { this.longitude = longitude; }

    // Método construtor
    public Local(String nome, double latitude, double longitude) {
        this.nome = nome;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    // Método que descreve cada item do ListView
    @Override
    public String toString(){ return getNome(); }

}

package mx.unam.dgtic.m10_00.model;

import java.util.Objects;

public class Auto {
    private Integer id;
    private String modelo;
    private String marca;
    private String color;

    public Auto() {
    }

    public Auto(Integer id, String modelo, String marca, String color) {
        this.id = id;
        this.modelo = modelo;
        this.marca = marca;
        this.color = color;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Auto auto = (Auto) o;
        return Objects.equals(id, auto.id) && Objects.equals(modelo, auto.modelo) && Objects.equals(marca, auto.marca) && Objects.equals(color, auto.color);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, modelo, marca, color);
    }

    @Override
    public String toString() {
        return "Auto{" +
                "id=" + id +
                ", modelo='" + modelo + '\'' +
                ", marca='" + marca + '\'' +
                ", color='" + color + '\'' +
                '}';
    }
}

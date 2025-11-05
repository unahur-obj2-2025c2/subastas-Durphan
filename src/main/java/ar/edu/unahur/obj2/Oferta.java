package ar.edu.unahur.obj2;

import ar.edu.unahur.obj2.observer.Subastador;

public class Oferta {
    private double precio;
    private Subastador comprador;

    public Oferta(Subastador comprador) {
        this.precio = 0;
        this.comprador = comprador;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public Subastador getComprador() {
        return comprador;
    }
}

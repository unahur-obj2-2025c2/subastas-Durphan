package ar.edu.unahur.obj2.tipos_subastadores;

import ar.edu.unahur.obj2.Oferta;
import ar.edu.unahur.obj2.observable.ProductoSubastado;

public class Unico implements ITipoSubastador {
    private ProductoSubastado productoSubastado;

    public Unico(ProductoSubastado productoSubastado) {
        this.productoSubastado = productoSubastado;
    }

    @Override
    public boolean leConvieneRealizarOferta(Oferta ofertaActual) {
        return !this.productoSubastado.participoSubastador(ofertaActual.getComprador());
    }
}

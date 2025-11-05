package ar.edu.unahur.obj2.tipos_subastadores;

import ar.edu.unahur.obj2.Oferta;

public class ConLimite implements ITipoSubastador {
    private final Integer limite;

    public ConLimite(Integer limite) {
        this.limite = limite;
    }

    @Override
    public boolean leConvieneRealizarOferta(Oferta ofertaActual) {
        return ofertaActual.getPrecio() < this.limite;
    }
}

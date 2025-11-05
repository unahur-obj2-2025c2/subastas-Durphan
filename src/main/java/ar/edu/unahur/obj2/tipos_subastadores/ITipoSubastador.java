package ar.edu.unahur.obj2.tipos_subastadores;

import ar.edu.unahur.obj2.Oferta;

public interface ITipoSubastador {
    boolean leConvieneRealizarOferta(Oferta ofertaActual);
}

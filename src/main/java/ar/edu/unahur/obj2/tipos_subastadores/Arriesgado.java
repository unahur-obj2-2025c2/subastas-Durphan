package ar.edu.unahur.obj2.tipos_subastadores;

import ar.edu.unahur.obj2.Oferta;

public class Arriesgado implements ITipoSubastador {
    private static final Arriesgado instance = new Arriesgado();

    @Override
    public boolean leConvieneRealizarOferta(Oferta ofertaActual) {
        return Boolean.TRUE;
    }

    public static Arriesgado getInstance() {
        return instance;
    }

}

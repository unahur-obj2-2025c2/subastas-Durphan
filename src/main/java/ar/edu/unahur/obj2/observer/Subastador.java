package ar.edu.unahur.obj2.observer;

import ar.edu.unahur.obj2.Oferta;
import ar.edu.unahur.obj2.observable.ProductoSubastado;
import ar.edu.unahur.obj2.observer.excepciones.SubastadorNoParticipante;
import ar.edu.unahur.obj2.tipos_subastadores.Arriesgado;
import ar.edu.unahur.obj2.tipos_subastadores.ITipoSubastador;

public class Subastador implements IObserver {
    private String nombre;
    private Oferta ultimaOfertaRecibida = new Oferta(null);
    private ITipoSubastador tipoSubastador = Arriesgado.getInstance();

    public Subastador(String nombre, ITipoSubastador tipoSubastador) {
        this.nombre = nombre;
        this.tipoSubastador = tipoSubastador;
    }

    public Subastador(String nombre) {
        this.nombre = nombre;
    }

    public void setTipoSubastador(ITipoSubastador tipoSubastador) {
        this.tipoSubastador = tipoSubastador;
    }

    public String getNombre() {
        return nombre;
    }

    @Override
    public void update(Oferta oferta) {
        this.ultimaOfertaRecibida = oferta;
    }

    public Oferta getUltimaOfertaRecibida() {
        return ultimaOfertaRecibida;
    }

    public void realizarOferta(ProductoSubastado subasta) {
        Oferta oferta = new Oferta(this);
        oferta.setPrecio(this.getUltimaOfertaRecibida().getPrecio() + 10);
        if (!this.tipoSubastador.leConvieneRealizarOferta(oferta)) {
            return;
        }
        try {
            subasta.recibirOferta(oferta);
        } catch (SubastadorNoParticipante e) {
            throw e;
        }
    }
}
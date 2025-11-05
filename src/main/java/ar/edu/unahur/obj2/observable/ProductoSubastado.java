package ar.edu.unahur.obj2.observable;

import java.util.ArrayList;
import java.util.List;

import ar.edu.unahur.obj2.Oferta;
import ar.edu.unahur.obj2.observer.IObserver;
import ar.edu.unahur.obj2.observer.excepciones.SubastadorNoParticipante;

public class ProductoSubastado implements IObservable {
    private List<IObserver> subastadores = new ArrayList<>();
    private List<Oferta> ofertasActuales = new ArrayList<>();

    @Override
    public void agregarSubastador(IObserver observer) {
        subastadores.add(observer);
    }

    @Override
    public void eliminarSubastador(IObserver observer) {
        subastadores.remove(observer);
    }

    public Integer getCantidadDeOfertas() {
        return ofertasActuales.size();
    }

    @Override
    public void notificarSubastadores() {
        subastadores.forEach(observer -> observer.update(getUltimaOferta()));
    }

    public Oferta getUltimaOferta() {
        if (ofertasActuales.isEmpty()) {
            return new Oferta(null);
        }
        return ofertasActuales.get(ofertasActuales.size() - 1);
    }

    public void recibirOferta(Oferta oferta) {
        if (!subastadores.contains(oferta.getComprador())) {
            throw new SubastadorNoParticipante("El comprador que realizo la oferta no esta participando");
        }
        ofertasActuales.add(oferta);
        notificarSubastadores();
    }

    public boolean participoSubastador(IObserver subastador) {
        return ofertasActuales.stream()
                .anyMatch(oferta -> oferta.getComprador().equals(subastador));
    }

}

package ar.edu.unahur.obj2.observable;

import ar.edu.unahur.obj2.observer.IObserver;

public interface IObservable {
    void agregarSubastador(IObserver observer);

    void eliminarSubastador(IObserver observer);

    void notificarSubastadores();
}

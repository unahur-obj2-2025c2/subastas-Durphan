package ar.edu.unahur.obj2.observer.excepciones;

public class SubastadorNoParticipante extends RuntimeException {
    public SubastadorNoParticipante(String mensaje) {
        super(mensaje);
    }
}

package ar.edu.unahur.obj2.observer;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import ar.edu.unahur.obj2.observable.ProductoSubastado;
import ar.edu.unahur.obj2.observer.excepciones.SubastadorNoParticipante;
import ar.edu.unahur.obj2.tipos_subastadores.ConLimite;
import ar.edu.unahur.obj2.tipos_subastadores.Unico;

public class MainTest {
    ProductoSubastado producto = new ProductoSubastado();
    Subastador subastador1 = new Subastador("martomau");
    Subastador subastador2 = new Subastador("gozager");
    Subastador subastadorInfiltrado = new Subastador("diazdan");

    @Test
    void testEscenario1() {
        producto.agregarSubastador(subastador1);
        producto.agregarSubastador(subastador2);

        subastador1.realizarOferta(producto);
        assertEquals(10, subastador1.getUltimaOfertaRecibida().getPrecio());
        assertEquals(10, subastador2.getUltimaOfertaRecibida().getPrecio());
        assertEquals("martomau", subastador2.getUltimaOfertaRecibida().getComprador().getNombre());
        subastador2.realizarOferta(producto);
        assertEquals(20, subastador1.getUltimaOfertaRecibida().getPrecio());
        assertEquals(20, subastador2.getUltimaOfertaRecibida().getPrecio());
        assertEquals("gozager", subastador1.getUltimaOfertaRecibida().getComprador().getNombre());
        subastador1.realizarOferta(producto);
        assertEquals(30, subastador1.getUltimaOfertaRecibida().getPrecio());
        assertEquals(30, subastador2.getUltimaOfertaRecibida().getPrecio());
        assertEquals("martomau", subastador2.getUltimaOfertaRecibida().getComprador().getNombre());
        assertEquals(3, producto.getCantidadDeOfertas());
        assertThrows(SubastadorNoParticipante.class, () -> subastadorInfiltrado.realizarOferta(producto));
    }

    @Test
    void losOfertadoresConLimiteNoRealizanOfertasQueSuperanSuLimite() {
        Subastador subastadorConLimite = new Subastador("limitoso", new ConLimite(20));
        producto.agregarSubastador(subastadorConLimite);
        subastadorConLimite.realizarOferta(producto);
        assertEquals(10, subastadorConLimite.getUltimaOfertaRecibida().getPrecio());
        subastadorConLimite.realizarOferta(producto);
        assertEquals(10, subastadorConLimite.getUltimaOfertaRecibida().getPrecio());
    }

    @Test
    void losOfertadoresUnicosSoloRealizanOfertaUnaVez() {
        Subastador subastadorUnico = new Subastador("unicazo", new Unico(producto));
        producto.agregarSubastador(subastadorUnico);
        subastadorUnico.realizarOferta(producto);
        assertEquals(10, subastadorUnico.getUltimaOfertaRecibida().getPrecio());
        subastadorUnico.realizarOferta(producto);
        assertEquals(10, subastadorUnico.getUltimaOfertaRecibida().getPrecio());
    }

}

package es.centro.incidencias;

/**
 * Excepción comprobada lanzada cuando no se encuentra una incidencia solicitada.
 *
 * @author Ismael Vázquez Zas
 * @version 1.0.0
 * @since 1.0.0
 * @see GestorIncidencias#buscarPorId(String)
 */
public class IncidenciaNoEncontradaException extends Exception {

/**
 * Crea la excepción para el identificador que no se ha encontrado.
 * @param id identificador que se intentó localizar
 */
    public IncidenciaNoEncontradaException(String id) {
        super("No existe ninguna incidencia con el identificador " + id + ".");
    }
}

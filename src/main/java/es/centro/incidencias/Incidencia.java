package es.centro.incidencias;

import java.util.Locale;
/**
 * Representa una incidencia de soporte del centro educativo. Sus datos son
 * inmutables una vez creada la instancia.
 *
 * @author Ismael Vázquez Zas
 * @version 1.0.0
 * @since 1.0.0
 * @see GestorIncidencias
 */
public final class Incidencia {

    private final String id;
    private final String titulo;
    private final String prioridad;
    private final boolean abierta;

    
/**
 * Crea una incidencia con los datos indicados.
 * @param id identificador de la incidencia
 * @param titulo descripción breve del problema
 * @param prioridad nivel de prioridad
 * @param abierta {@code true} si la incidencia continúa abierta
 */

    public Incidencia(String id, String titulo, String prioridad, boolean abierta) {
        this.id = id;
        this.titulo = titulo;
        this.prioridad = prioridad;
        this.abierta = abierta;
    }

/** @return identificador de esta incidencia */
    public String getId() {
        return id;
    }

/** @return título descriptivo de esta incidencia */
    public String getTitulo() {
        return titulo;
    }

/** @return prioridad asignada a esta incidencia */
    public String getPrioridad() {
        return prioridad;
    }

/** @return {@code true} si la incidencia está abierta */
    public boolean isAbierta() {
        return abierta;
    }

/**
 * Comprueba si el ID o el título contienen el texto, ignorando mayúsculas.
 * @param texto criterio que se desea buscar
 * @return {@code true} si coincide con el ID o el título
 * @throws NullPointerException si {@code texto} es {@code null}
 */
    public boolean coincideCon(String texto) {
        String criterio = texto.toLowerCase(Locale.ROOT);
        return id.toLowerCase(Locale.ROOT).contains(criterio)
                || titulo.toLowerCase(Locale.ROOT).contains(criterio);
    }

}

package es.centro.incidencias;

import java.util.List;

/**
 * Proporciona operaciones de consulta sobre las incidencias del centro.
 *
 * @author Ismael Vázquez Zas
 * @version 1.0.0
 * @since 1.0.0
 * @see Incidencia
 */
public final class GestorIncidencias {

    private final List<Incidencia> incidencias;

/** Crea el gestor con el conjunto inicial de incidencias de ejemplo. */

    public GestorIncidencias() {
        incidencias = List.of(
                new Incidencia("INC-001", "No se puede iniciar sesión", "alta", true),
                new Incidencia("INC-002", "Actualizar el navegador", "media", false),
                new Incidencia("INC-003", "Impresora sin conexión", "baja", true),
                new Incidencia("INC-004", "Fallo de red en el aula", "alta", true)
        );
    }

/** @return lista inmutable con todas las incidencias */
    public List<Incidencia> listar() {
        return incidencias;
    }

/** @return lista inmutable con las incidencias abiertas */
    public List<Incidencia> listarAbiertas() {
        return incidencias.stream()
                .filter(Incidencia::isAbierta)
                .toList();
    }

/**
 * Busca incidencias cuyo ID o título contenga el texto indicado.
 * @param texto criterio de búsqueda
 * @return lista inmutable de coincidencias; puede estar vacía
 * @throws NullPointerException si {@code texto} es {@code null}
 * @see Incidencia#coincideCon(String)
 */
    public List<Incidencia> buscar(String texto) {
        return incidencias.stream()
                .filter(incidencia -> incidencia.coincideCon(texto))
                .toList();
    }

/**
 * Busca una incidencia por identificador, ignorando mayúsculas.
 * @param id identificador que se desea consultar
 * @return incidencia encontrada
 * @throws IncidenciaNoEncontradaException si no existe una incidencia con ese ID
 * @throws NullPointerException si {@code id} es {@code null}
 */
    public Incidencia buscarPorId(String id) throws IncidenciaNoEncontradaException {
        return incidencias.stream()
                .filter(incidencia -> incidencia.getId().equalsIgnoreCase(id))
                .findFirst()
                .orElseThrow(() -> new IncidenciaNoEncontradaException(id));
    }

/**
 * Obtiene la incidencia por ID, devolviendo {@code null} cuando no existe.
 * @param id identificador que se desea consultar
 * @return incidencia encontrada o {@code null} si no existe
 * @deprecated Desde 1.0.0, devolver {@code null} oculta la causa del fallo.
 * Utiliza {@link #buscarPorId(String)}, que comunica la ausencia mediante
 * {@link IncidenciaNoEncontradaException}.
 * @see #buscarPorId(String)
 */
    @Deprecated(since = "1.0.0", forRemoval = false)
    public Incidencia obtenerIncidencia(String id) {
        try {
            return buscarPorId(id);
        } catch (IncidenciaNoEncontradaException excepcion) {
            return null;
        }
    }
}

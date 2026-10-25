# Gestor de incidencias

Aplicación de consola para consultar incidencias de soporte de un centro educativo. Permite listar avisos, filtrar los que siguen abiertos, buscar por texto y consultar una incidencia mediante su identificador.

## Requisitos

- Java 17 o posterior.
- Maven, o el wrapper incluido en el proyecto.

## Funcionalidades

- Listar todas las incidencias.
- Mostrar únicamente las incidencias abiertas.
- Buscar por identificador o título sin distinguir mayúsculas y minúsculas.
- Consultar una incidencia por su ID.
- Utilizar un menú interactivo o comandos de línea de comandos.

## Compilar y ejecutar

Desde la raíz del proyecto:

```bash
mvn clean compile exec:java
```

En Windows también se puede utilizar el wrapper:

```powershell
.\mvnw.cmd clean compile exec:java
```

Sin argumentos se inicia el menú. Para ejecutar comandos directamente:

```bash
mvn exec:java -Dexec.args="ayuda"
mvn exec:java -Dexec.args="listar"
mvn exec:java -Dexec.args="abiertas"
mvn exec:java -Dexec.args="buscar navegador"
mvn exec:java -Dexec.args="detalle INC-001"
```

## Generación y consulta de Javadoc

Genera la documentación HTML con:

```bash
mvn javadoc:javadoc
```

O en Windows:

```powershell
.\mvnw.cmd javadoc:javadoc
```

Los archivos se generan en `docs/`. Abre `docs/index.html` en un navegador para consultar la documentación localmente.

Documentación publicada: https://ismaelvazquezzas.github.io/proyecto-base-maven-gestor-incidencias/es/centro/incidencias/package-summary.html

## Clases principales

| Clase | Responsabilidad |
|---|---|
| `App` | Punto de entrada; procesa comandos y muestra el menú y los resultados. |
| `GestorIncidencias` | Mantiene las incidencias y proporciona operaciones de consulta. |
| `Incidencia` | Representa una incidencia con ID, título, prioridad y estado. |
| `IncidenciaNoEncontradaException` | Excepción comprobada para los identificadores que no existen. |

## Estructura de archivos

```text
.
├── docs/                         # Documentación Javadoc generada
├── src/main/java/es/centro/incidencias/
│   ├── App.java
│   ├── GestorIncidencias.java
│   ├── Incidencia.java
│   └── IncidenciaNoEncontradaException.java
├── pom.xml
├── mvnw
├── mvnw.cmd
└── README.md
```

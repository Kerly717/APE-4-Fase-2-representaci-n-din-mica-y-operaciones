
# Conexión Ambato – APE 4 | Fase 2
## Información académica

**Universidad:** Universidad Técnica de Ambato

**Facultad:** Facultad de Ingeniería en Sistemas, Electrónica e Industrial

**Carrera:** Software

**Asignatura:** Estructura de Datos

**Tema:** APE 4 – Fase 2: Representación dinámica y operaciones sobre personas/relaciones

**Estudiante:** Espinoza Reyes Kerly Margoth

**Docente:** Ing. José Caiza, Mg.

## Descripción de la Guía Ape

**Conexión Ambato** es un proyecto desarrollado en Java para la asignatura de **Estructura de Datos**, de la Universidad Técnica de Ambato.

El sistema simula una red social dinámica que permite registrar usuarios, crear y eliminar amistades, seguir a otras personas y consultar las relaciones existentes.

En esta segunda fase se implementa un **grafo dinámico mediante multilistas y listas de adyacencia**, utilizando nodos propios y sin emplear colecciones de Java como `ArrayList`, `LinkedList`, `HashMap` o `HashSet`.

## Objetivo general

Implementar una red social dinámica mediante listas de adyacencia con nodos propios, permitiendo gestionar usuarios y relaciones de amistad y seguimiento.

## Objetivos específicos

- Representar personas y relaciones mediante vértices y aristas.
- Implementar operaciones de registro y eliminación de usuarios.
- Crear y eliminar relaciones de amistad.
- Implementar relaciones dirigidas de seguimiento.
- Validar usuarios inexistentes, duplicados y relaciones no permitidas.
- Analizar la complejidad temporal de los algoritmos.

## Tecnologías utilizadas

| Tecnología | Descripción |
|---|---|
| Java | Lenguaje de programación |
| Visual Studio Code | Editor de código |
| Git | Control de versiones |
| GitHub | Repositorio del proyecto |
| Grafos | Representación de relaciones |
| Multilistas | Estructura dinámica de nodos |

## Estructura de datos

El sistema utiliza una multilista formada por vértices y aristas.

### Clase Persona

Almacena la información de cada usuario.

- `usuario`: identificador único.
- `nombre`: nombre de la persona.

### Clase Vertice

Representa un usuario dentro del grafo.

- `persona`: información del usuario.
- `aristas`: primera relación del usuario.
- `sig`: siguiente vértice.

### Clase Arista

Representa una relación entre dos usuarios.

- `destino`: vértice relacionado.
- `tipo`: AMISTAD o SEGUIR.
- `sig`: siguiente arista.

### Tipos de relaciones

**AMISTAD:** relación bidireccional. Se almacenan dos aristas, una por cada sentido.

**SEGUIR:** relación unidireccional. Se almacena una sola arista desde el seguidor hacia el usuario seguido.

## Funcionalidades del sistema

| Funcionalidad | Descripción |
|---|---|
| Registrar persona | Agrega un usuario al grafo |
| Eliminar persona | Elimina un usuario y sus relaciones |
| Crear amistad | Establece una amistad recíproca |
| Eliminar amistad | Elimina la amistad en ambos sentidos |
| Seguir usuario | Crea una relación dirigida |
| Dejar de seguir | Elimina una relación de seguimiento |
| Listar amigos | Muestra las amistades de un usuario |
| Listar seguidos | Muestra las personas que sigue |
| Listar seguidores | Muestra quiénes siguen al usuario |
| Contar amigos | Calcula el número de amistades |
| Mostrar red | Visualiza los usuarios y sus relaciones |

## Validaciones implementadas

El sistema verifica que:

- No se registren usuarios duplicados.
- No se acepten identificadores vacíos.
- Los identificadores no contengan espacios ni comas.
- No se creen relaciones con usuarios inexistentes.
- Una persona no pueda relacionarse consigo misma.
- No existan relaciones duplicadas del mismo tipo.
- Al eliminar un usuario se eliminen todas las relaciones asociadas.

Los identificadores se normalizan a minúsculas para evitar diferencias entre mayúsculas y minúsculas.

## Caso práctico: Conexión Ambato

La red inicial está formada por seis usuarios:

| Código | Usuario | Amigos iniciales |
|---|---|---|
| A01 | Sofía | Mateo, Andrés |
| A02 | Mateo | Sofía, Valeria |
| A03 | Valeria | Mateo, Andrés |
| A04 | Andrés | Valeria, Sofía, Camila |
| A05 | Camila | Andrés |
| A06 | Diego | Ninguno |

Inicialmente existen:

- 6 usuarios registrados.
- 5 relaciones de amistad.
- 10 aristas internas de amistad.

## Pruebas del sistema

Se establece la siguiente secuencia de comprobación:

| Prueba | Resultado esperado |
|---|---|
| Registrar seis usuarios | Registro correcto |
| Crear cinco amistades | Amistades establecidas |
| Mateo sigue a Sofía | Seguimiento registrado |
| Diego sigue a Sofía | Seguimiento registrado |
| Consultar amigos de Andrés | Valeria, Sofía y Camila |
| Eliminar amistad Andrés-Camila | Relación eliminada |
| Eliminar a Sofía | Usuario y relaciones eliminados |
| Registrar usuario duplicado | Operación rechazada |
| Crear amistad consigo mismo | Operación rechazada |

### Pruebas automatizadas

De acuerdo con el informe de la práctica:

**65 pruebas ejecutadas – 65 pruebas correctas.**

Las pruebas permiten comprobar el comportamiento de las operaciones y las validaciones del grafo dinámico.

## Complejidad temporal

| Operación | Complejidad |
|---|---|
| Buscar usuario | O(V) |
| Registrar persona | O(V) |
| Agregar amistad | O(V + grado) |
| Seguir usuario | O(V + grado) |
| Eliminar amistad | O(V + grado) |
| Dejar de seguir | O(V + grado) |
| Eliminar persona | O(V + A) |
| Listar amigos | O(V + grado) |
| Listar seguidos | O(V + grado) |
| Listar seguidores | O(V + A) |
| Contar amigos | O(V + grado) |
| Mostrar red | O(V + A) |

Donde:

- **V:** número de vértices o usuarios.
- **A:** número de aristas almacenadas.
- **grado:** número de relaciones del vértice consultado.

## Ejecución del proyecto

### Requisitos

- Tener instalado Java JDK.
- Contar con Visual Studio Code o un IDE compatible con Java.
- Disponer de los archivos fuente del proyecto.

### Pasos

1. Clonar o descargar el repositorio.
2. Abrir la carpeta del proyecto en Visual Studio Code.
3. Identificar la clase principal que contiene el método `main`.
4. Ejecutar el programa desde el IDE.
5. Utilizar el menú de consola para gestionar usuarios y relaciones.

## Conclusiones

1. La implementación de multilistas permitió representar dinámicamente una red social, facilitando la incorporación y eliminación de usuarios sin establecer un tamaño fijo.

2. Las relaciones de amistad y seguimiento demostraron la importancia de diferenciar entre grafos no dirigidos y dirigidos.

3. Las validaciones permitieron mantener la consistencia de los datos, evitando usuarios duplicados, relaciones inválidas y referencias a usuarios eliminados.

4. El análisis de complejidad permitió identificar que las operaciones que recorren toda la red requieren mayor tiempo de procesamiento.

5. Las listas de adyacencia constituyen una alternativa eficiente para representar grafos dispersos.

## Recomendaciones

1. Mantener las validaciones antes de registrar usuarios o relaciones.
2. Ejecutar las pruebas automatizadas después de realizar modificaciones.
3. Comprobar los casos límite, como redes vacías y usuarios inexistentes.
4. Documentar los métodos para facilitar el mantenimiento del código.
5. Comparar en futuras prácticas las listas de adyacencia con las matrices de adyacencia.


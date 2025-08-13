
````markdown
# GiftCard Management (Arquitectura Hexagonal)

Este proyecto es una aplicación de consola en **Kotlin** para gestionar tarjetas de regalo (GiftCards) siguiendo el patrón de **Arquitectura Hexagonal**.  
Está pensado como un ejercicio práctico para separar responsabilidades y entender cómo interactúan **dominio**, **puertos** y **adaptadores**.

## 📂 Estructura del proyecto

```plaintext
src/main/kotlin
├── Main.kt                         # Punto de entrada de la aplicación
├── core                             # Capa central (lógica de negocio)
│   ├── domain                       # Modelos y reglas de dominio
│   │   └── GiftCard.kt
│   ├── ports                        # Definición de interfaces
│   │   ├── `in`                     # Puertos de entrada (casos de uso)
│   │   │   └── GiftCardService.kt
│   │   └── out                      # Puertos de salida (repositorios, servicios externos)
│   │       └── GiftCardRepository.kt
│   └── usecases                     # Implementaciones de casos de uso
│       └── GiftCardServiceImpl.kt
├── adapters                         # Adaptadores que conectan el core con el exterior
│   ├── in/console                   # Entrada por consola
│   │   └── ConsoleController.kt
│   └── out/memory                   # Persistencia en memoria
│       └── MemoryGiftCardRepository.kt
````

## Arquitectura Hexagonal

El diseño sigue estos principios:

* **Dominio (`core/domain`)**: Contiene la entidad `GiftCard` y sus propiedades.
* **Puertos de entrada (`core/ports/in`)**: Interfaces que definen las operaciones disponibles para interactuar con el dominio.
* **Casos de uso (`core/usecases`)**: Implementan la lógica de negocio, dependen de puertos de salida para obtener/guardar datos.
* **Puertos de salida (`core/ports/out`)**: Interfaces que definen cómo el dominio interactúa con el mundo exterior (repositorios, APIs externas).
* **Adaptadores de entrada (`adapters/in`)**: Transforman las entradas del usuario en llamadas a los casos de uso.
* **Adaptadores de salida (`adapters/out`)**: Implementan la persistencia o integración externa.

La comunicación es **unidireccional hacia el dominio**:
Adaptadores → Puertos de entrada → Casos de uso → Puertos de salida → Adaptadores.

## Funcionalidades

* Crear una nueva GiftCard.
* Recargar saldo.
* Cobrar saldo.
* Listar todas las tarjetas.

## Ejecución

1. **Clonar repositorio**

   ```bash
   git clone https://github.com/usuario/GiftCardManagement.git
   cd GiftCardManagement
   ```

2. **Compilar y ejecutar**

   ```bash
   ./gradlew run
   ```

   o desde IntelliJ IDEA ejecutando `Main.kt`.

3. **Interacción**
   La aplicación solicitará acciones por consola:

   ```
   1. Crear GiftCard
   2. Recargar
   3. Cobrar
   4. Listar todas
   0. Salir
   ```

## Mejoras futuras

* Validaciones más estrictas en el dominio (ej. no permitir recargas negativas).
* Implementar persistencia con base de datos real.
* Añadir tests unitarios para casos de uso.
* Manejo de excepciones personalizado.



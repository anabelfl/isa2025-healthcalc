# isa2025-healthcalc
Health calculator used in Ingeniería del Software Avanzada

# HealthCalc

Este repositorio contiene una **calculadora de salud** con funciones para calcular el **peso ideal (IW)** y la **tasa metabólica basal (BMR)**.  

---

## Práctica 1: Casos de Prueba  

A continuación, se presentan los **casos de prueba** para validar el correcto funcionamiento de la calculadora de salud.  

### 🔹 **Cálculo del Peso Ideal (`idealBodyWeight(int height, char gender)`)**  
La fórmula de Lorentz permite estimar de forma aproximada el **peso ideal** en base a la algura y género del usuario::
- Hombre: `IW = height - 100 - (height - 150) / 4)`
- Mujer: `IW = height - 100 - (height - 150) / 2.5)`


| **Caso de Prueba** | **Entrada** | **Salida Esperada** |
|------------------|------------|------------------|
| 1. Calcular IW de una mujer | `height = 164`, `gender = 'w'` | Peso ideal en kg según la fórmula de Lorentz (58.4 kg). |
| 2. Calcular IW de un hombre | `height = 164`, `gender = 'm'` | Peso ideal en kg según la fórmula de Lorentz (60.5 kg). |
| 3. Altura superior a 250cm | `height = 250`, `gender = 'm'` | Error: "Height out of range". |
| 4. Altura igual a 0cm  | `height = 0`, `gender = 'm'` | Error: "Height out of range". |
| 5. Género inválido | `height = 169`, `gender = 'X'` | Error: "Invalid gender. Do use 'w' or 'm'". |

---

### 🔹 **Cálculo de la Tasa Metabólica Basal (`basalMetabolicRate(float weight, int height, int age, char gender)`)**  

La tasa metabólica, es la cantidad de calorías que una persona gasta en el día.

La **tasa metabólica basal** (BMR) es esta cifra en estado basal, es decir sin moverse. Es la cantidad de calorías que el cuerpo gasta en reposo para mantener sus funciones vitales, como la respiración, los latidos cardíacos y la temperatura corporal. 
Sirve para entender y calcular el total de energía que el cuerpo gasta por día


Los factores clave que afectan la tasa metabólica basal son: el sexo, la edad, la altura y el peso.

Para  calcular este valor se utiliza la fórmula de Harris-Benedict:
- Hombre: `BMR = 88.362 + 13.397 * weight + 4.799 * height - 5.677 * age`
- Mujer: `BMR = 447.593 + 9.247 * weight + 3.098 * height - 4.330 * age`


| **Caso de Prueba** | **Entrada** | **Salida Esperada** |
|------------------|------------|------------------|
| 1. Calcular BMR de una mujer | `weight = 65`, `height = 164`, `age = 21`, `gender = 'w'` | BMR según la fórmula de Harris-Benedict (1465.79 kcal/day). |
| 2. Calcular BMR de un hombre | `weight = 70`, `height = 177`, `age = 23`, `gender = 'm'` | BMR según la fórmula de Harris-Benedict (1745.004 kcal). |
| 3. Peso inválido | `weight = 460`, `height = 200`, `age = 45`, `gender = 'm'` | Error: "Weight out of range (1-400 kg)". |
| 4. Peso inválido | `weight = 0`, `height = 120`, `age = 10`, `gender = 'w'` | Error: "Weight out of range (1-400 kg)". |
| 5. Altura inválida | `weight = 60`, `height = 260`, `age = 65`, `gender = 'm'` | Error: "Height out of range (1-250 cm)". |
| 6. Altura inválida | `weight = 60`, `height = -4`, `age = 10`, `gender = 'w'` | Error: "Height out of range (1-250 cm)". |
| 7. Edad fuera de rango | `weight = 60`, `height = 100`, `age = -3`, `gender = 'm'` | Error: "Age out of range (1-110 years)". |
| 8. Edad fuera de rango | `weight = 60`, `height = 100`, `age = 130`, `gender = 'm'` | Error: "Age out of range (1-110 years)". |
| 9. Género no reconocido | `weight = 60`, `height = 150`, `age = 23`, `gender = 'p'` | Error: "Invalid gender. Do use 'w' or 'm'". |

---

### 🔹 Ejecución de los casos de prueba usando Maven

Comprobación de que los tests se han ejecutado exitosamente:
![Información de Maven](doc/infomvn.png)


### 🔹 Registro de instantáneas

Captura que muestra los commits que se han ido realizando durante la práctica.
![gikt](doc/registro_commits.png)


### 🔹 Enlaces externos   

Para la creación de este archivo README e implementación de código del programa, se ha contado con la ayuda de inteligencia artificial y páginas externas como https://www.tuasaude.com/es/tasa-metabolica-basal/.

---

## Práctica 2: Diagrama de Caso de Uso  

Se muestra el diagrama de casos de uso de la calculadora de salud actualizado:  

![Diagrama de Casos de Uso](doc/casodeuso.png)

### **CALCULAR TASA METABÓLICA BASAL (FULLY DRESSED VERSION)**  

- **Actor principal:** Persona (usuario).  
- **Ámbito:** Calculadora de salud.  
- **Nivel:** User goal.  

### 🎯 **Stakeholders e intereses:**  
- **Persona:** Quiere conocer su TMB para gestionar su alimentación y salud.  
- **Médico:** Puede usar la TMB para realizar diagnósticos o tratamientos preventivos.  
- **Entrenador deportivo:** Usa la TMB para crear planes de entrenamiento y alimentación.  

### ✅ **Precondición:**  
El usuario debe introducir datos válidos (peso, altura, edad y género).  

### ⚠️ **Garantía mínima:**  
El sistema notifica un error si los datos son inválidos.

### 🎯 **Garantía de éxito:**  
El sistema muestra la TMB calculada correctamente mediante la fórmula de Harris-Benedict.  

### 🔄 **Escenario principal:**  
1. El usuario accede a la función "Calcular tasa metabólica basal".  
2. El sistema solicita peso, altura, edad y género.  
3. El usuario introduce los datos.  
4. El sistema valida los datos.  
5. Se aplica la fórmula de Harris-Benedict.  
6. Se muestra la TMB calculada.  

### 🚨 **Escenarios alternativos:**  
  - **4a.** Datos inválidos (valores negativos, vacíos o fuera de rango).  
  - **4a.1** El sistema muestra un mensaje de error.  
  - **4a.2** Se solicita volver a ingresar los datos.  

### 🔀 **Extensiones:**  
- **2a.1** El sistema ofrece la opción de volver al menú principal.  

# SVG-grapher
Graficador SVG

# Requerimientos

Este proyecto se realizó usando Maven, por lo que es necesario que se tenga instalada una versión funcional de Maven para usar correctamente el programa.

# Uso

## Compilar programa

Dirígiete a la carpeta raiz de este repositorio y ejecuta la siguiente instrucción:

  mvn compile

## Instalar programa

Dirígiete a la carpeta raiz de este repositorio y ejecuta la siguiente instrucción:

  mvn install
  
 acto seguido se empezará a instalar el programa.
 
## Ejecutar programa

Para esto es necesario usar la siguiente sintaxis dentro de la carpeta raiz del programa:

  java -jar target/proyecto2 [<Nombre de archivo> | Entrada estandar]
  
Si se intenta utilizar el programa con un archivo específico, entonces debes especificar la ruta de éste, además debe seguir la siguiente estructura
 
<Estructura de datos> Valor_1 Valor_2 ... Valor_n
 
Lo mismo aplica para entrada estándar

El programa ignora por defecto las lineas que empiecen por #, por lo que si desea comentar algún archivo de texto, puede hacerlo poniendo **#** 
al inicio de cada linea comentada.

# Estrucutarad soportadas con su respectiva sintáxis para el programa
 
## Arbol Binario Completo (ArbolCompleto)
## Arbol Binario Ordenado (ArbolOrdenado)
## Arbol Rojinegro (ArbolRojinegro)
## Arbol ALV (ArbolAVL)
## Cola (Cola)
## Gráfica (Gráfica)
## Lista (Lista)
## Montículo Mínimo (MonticuloMinimo)
## Arreglo (Arreglo)

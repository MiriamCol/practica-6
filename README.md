# Practica 6: Testing de una aplicacion de Spring Boot

Miriam Colino Ruipérez 201804334

## Objetivo de la práctica

Dado un desarrollo de Spring Boot, es necesario anhadir tests a las siguientes clases:

- DNI & Telefono (Unit Tests) (Cada clase tiene un metodo y varias casuisticas para probar)
- ProcessController (E2E Tests) (2 endpoints)

## Entrega

Sube la practica solucionada a un repositorio de Github.
y crea un documento en formato Markdown, explicando las casuisticas que se van a probar.

## Casuisticas

DNITest.java
- caso correcto
- caso letra al principio incorrecto (pattern incorrecto)
- caso la letra no contemplada en las opciones válidas (letra O)

TelTest.java
- caso correcto
- letra en medio de los numeros es incorrecto

ProcessControllerTest.java
- caso todo correcto
- caso telefono no correcto
- caso dni no correcto





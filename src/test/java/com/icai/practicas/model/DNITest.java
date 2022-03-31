package com.icai.practicas.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DNITest {

    private DNI dni;

    @Test
    void returnTrue() {

        dni= new DNI("05326899F"); //correcto
        Boolean expectedResult= true;
        Boolean result = dni.validar();

        Assertions.assertEquals(expectedResult,result);

    }
    @Test
    void returnFalse1() {

        dni= new DNI("a5326899F"); //letra al principio es incorrecto (pattern incorrecto)
        Boolean expectedResult= false;
        Boolean result = dni.validar();

        Assertions.assertEquals(expectedResult,result);

    }
    @Test
    void returnFalse2() {

        dni= new DNI("05326899O"); //la letra 0 no esta contemplada en las opciones válidas
        Boolean expectedResult= false;
        Boolean result = dni.validar();

        Assertions.assertEquals(expectedResult,result);

    }
    @Test
    void returnFalse3() {

        dni= new DNI("00000000T"); //un dni inválido
        Boolean expectedResult= false;
        Boolean result = dni.validar();

        Assertions.assertEquals(expectedResult,result);

    }
}
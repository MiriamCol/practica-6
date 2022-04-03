package com.icai.practicas;

import com.icai.practicas.model.Telefono;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TelefonoTest {


    private Telefono telefono;

    @Test
    void returnTrue() {

        telefono= new Telefono("915436147"); //teléfono correcto
        Boolean expectedResult= true;
        Boolean result = telefono.validar();

        Assertions.assertEquals(expectedResult,result);

    }
    @Test
    void returnFalse() {

        telefono= new Telefono("9a5436147"); //letra no correcta
        Boolean expectedResult= false;
        Boolean result = telefono.validar();

        Assertions.assertEquals(expectedResult,result);

    }
}
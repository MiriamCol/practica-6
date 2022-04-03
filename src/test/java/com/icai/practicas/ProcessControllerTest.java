package com.icai.practicas;

import com.icai.practicas.controller.ProcessController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import static org.assertj.core.api.BDDAssertions.then;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ProcessControllerTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void allCorrect(){


        String address = "http://localhost:" + port + "/api/v1/process-step1";
        ProcessController.DataRequest dataEntry = new ProcessController.DataRequest("Miriam Colino", "05326899F", "9154361475");
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<ProcessController.DataRequest> request = new HttpEntity<>(dataEntry, headers);

        ResponseEntity<String> result = this.restTemplate.postForEntity(address, request, String.class);

        String expectedResult = "{\"result\":\"OK\"}";
        then(result.getBody()).isEqualTo(expectedResult);
    }


    @Test
    public void DNINotCorrect()
    {

        String address = "http://localhost:" + port + "/api/v1/process-step1";
        ProcessController.DataRequest dataEntry = new ProcessController.DataRequest("Miriam Colino", "05326899O", "915436147");
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<ProcessController.DataRequest> request = new HttpEntity<>(dataEntry, headers);

        ResponseEntity<String> result = this.restTemplate.postForEntity(address, request, String.class);

        String expectedResult = "{\"result\":\"KO\"}";
        then(result.getBody()).isEqualTo(expectedResult);
    }

    @Test
    public void TelNotCorrect()
    {

        String address = "http://localhost:" + port + "/api/v1/process-step1";
        ProcessController.DataRequest dataEntry = new ProcessController.DataRequest("Miriam Colino", "05326899F", "91543614");
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<ProcessController.DataRequest> request = new HttpEntity<>(dataEntry, headers);

        ResponseEntity<String> result = this.restTemplate.postForEntity(address, request, String.class);

        String expectedResult = "{\"result\":\"KO\"}";
        then(result.getBody()).isEqualTo(expectedResult);
    }
@Test
public void AllCorrectlegacy(){


        String address = "http://localhost:" + port + "/api/v1/process-step1-legacy";
        MultiValueMap<String, String> data = new LinkedMultiValueMap<>();
        data.add("fullName", "Miriam Colino");
        data.add("dni", "05326899F");
        data.add("telefono", "915436147");
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(data, headers);

        ResponseEntity<String> result = this.restTemplate.postForEntity(address, request, String.class);

        String expectedResult = "Muchas gracias por enviar los datos";
        then(result.getBody()).contains(expectedResult);
        }

@Test
public void DNINotCorrectlegacy(){


        String address = "http://localhost:" + port + "/api/v1/process-step1-legacy";
        MultiValueMap<String, String> data = new LinkedMultiValueMap<>();
        data.add("fullName", "Miriam Colino");
        data.add("dni", "053268OO");
        data.add("telefono", "915436147");
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(data, headers);

        ResponseEntity<String> result = this.restTemplate.postForEntity(address, request, String.class);

        String expectedResult = "Revise los datos introducidos";
        then(result.getBody()).contains(expectedResult);
        }

@Test
public void TelNotCorrectlegacy(){


        String address = "http://localhost:" + port + "/api/v1/process-step1-legacy";
        MultiValueMap<String, String> data = new LinkedMultiValueMap<>();
        data.add("fullName", "Miriam Colino");
        data.add("dni", "05326899F");
        data.add("telefono", "91yy36147");
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(data, headers);

        ResponseEntity<String> result = this.restTemplate.postForEntity(address, request, String.class);

        String expectedResult = "Revise los datos introducidos";
        then(result.getBody()).contains(expectedResult);
        }

}
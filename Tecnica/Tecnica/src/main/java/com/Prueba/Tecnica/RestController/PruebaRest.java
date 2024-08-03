/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Prueba.Tecnica.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author marco
 */
@RestController
@RequestMapping("/api/sequence")
public class PruebaRest {

    @PutMapping("/collatz/{numeroIngresado}")
    public ResponseEntity<Map<String, Object>> getCollatzSequence(@PathVariable int numeroIngresado) {
        if (numeroIngresado <= 0) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        List<Integer> Secuencia = new ArrayList<>();
        int numero = numeroIngresado;

        while (numero != 1) {
            Secuencia.add(numero);
            if (numero % 2 == 0) {
                numero /= 2;
            } else {
                numero = 3 * numero + 1;
            }
        }
        Secuencia.add(1);

        Map<String, Object> response = new HashMap<>();
        response.put("numeroIngresado", numeroIngresado);
        response.put("secuencia", Secuencia);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PutMapping("/fizzbuzz/{numeroIngresado}")
    public ResponseEntity<List<String>> getFizzBuzzSequence(@PathVariable int numeroIngresado) {
        if (numeroIngresado <= 0) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        List<String> secuencia = new ArrayList<>();

        for (int i = 1; i <= numeroIngresado; i++) {
            if (i % 3 == 0 && i % 5 == 0) {
                secuencia.add("FizzBuzz");
            } else if (i % 3 == 0) {
                secuencia.add("Fizz");
            } else if (i % 5 == 0) {
                secuencia.add("Buzz");
            } else {
                secuencia.add(String.valueOf(i));
            }
        }

        return new ResponseEntity<>(secuencia, HttpStatus.OK);
    }

}

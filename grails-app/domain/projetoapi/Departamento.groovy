package projetoapi

import grails.converters.JSON
import groovy.json.JsonBuilder

import java.time.LocalDate
import java.time.format.DateTimeFormatter

class Departamento {
    Long id
    String nome

    static hasMany = [empregados: Empregado]

    static {
        JSON.registerObjectMarshaller(LocalDate) { LocalDate date ->
            date.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"))
        }
    }

    String toJson() {
        new JsonBuilder(this).toString()
    }
}


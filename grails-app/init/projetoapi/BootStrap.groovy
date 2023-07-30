package projetoapi

import java.time.LocalDate

class BootStrap {

    def init = { servletContext ->
        def dep1 = new Departamento(nome: "Defesa").save()
        def dep2 = new Departamento(nome: "Meio Campo").save()
        def dep3 = new Departamento(nome: "Ataque").save()

        new Empregado(nome: "Fernandao", dataNascimento: LocalDate.parse("1978-03-18"), matricula: 12345, departamento: dep3).save()
        new Empregado(nome: "Dalessandro", dataNascimento: LocalDate.parse("1981-04-15"), matricula: 67890, departamento: dep2).save()
        new Empregado(nome: "Indio", dataNascimento: LocalDate.parse("1975-02-14"), matricula: 54321, departamento: dep1).save()
        new Empregado(nome: "Rafael Sobis", dataNascimento: LocalDate.parse("1985-06-17"), matricula: 98765, departamento: dep3).save()
        new Empregado(nome: "Falcão", dataNascimento: LocalDate.parse("1953-10-16"), matricula: 13579, departamento: dep2).save()
    }

    def destroy = {
    }
}

package projetoapi

import grails.converters.JSON
import grails.gorm.transactions.Transactional

@Transactional
class EmpregadoController {

    def empregadoService

//    def index() {
//        def empregados = empregadoService.listarEmpregados()
//        render empregados as JSON
//    }

    // altera a ordem de apresentacao do get
    def index() {
        def empregados = empregadoService.listarEmpregados()
        def listaFormatada = empregados.collect { empregado ->
            [
                    id: empregado.id,
                    matricula: empregado.matricula,
                    nome: empregado.nome,
                    dataNascimento: empregado.dataNascimento,
                    departamento: empregado.departamento.id
            ]
        }
        render listaFormatada as JSON
    }


    def show(Long id) {
        def empregado = empregadoService.buscarEmpregadoPorId(id)
        def empregadoFormatado = [
                id: empregado.id,
                matricula: empregado.matricula,
                nome: empregado.nome,
                dataNascimento: empregado.dataNascimento,
                departamento: empregado.departamento.id
        ]
        render empregadoFormatado as JSON
    }

    def save() {
        def empregadoData = request.JSON
        def empregado = empregadoService.criarEmpregado(empregadoData)
        render empregado as JSON
    }

    def update(Long id) {
        def empregadoData = request.JSON
        def empregado = empregadoService.atualizarEmpregado(id, empregadoData)
        render empregado as JSON
    }

    def delete(Long id) {
        def empregado = empregadoService.excluirEmpregado(id)
        render empregado as JSON
    }
}

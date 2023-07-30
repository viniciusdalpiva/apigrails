package projetoapi

import grails.converters.JSON
import grails.gorm.transactions.Transactional

@Transactional
class EmpregadoController {

    def empregadoService

    def index() {
        def empregados = empregadoService.listarEmpregados()
        render empregados as JSON
    }

    def show(Long id) {
        def empregado = empregadoService.buscarEmpregadoPorId(id)
        render empregado as JSON
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

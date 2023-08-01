package projetoapi

import org.springframework.validation.BindingResult

class DepartamentoService {

    def listarDepartamentos() {
        Departamento.list()
    }

    def buscarDepartamentoPorId(Long id) {
        Departamento.get(id)
    }

    def criarDepartamento(Map departamentoData) {
        validarDadosObrigatorios(departamentoData) // Validate required fields

        def empregados = departamentoData.empregados
        if (empregados == null || empregados.isEmpty()) {
            throw new IllegalArgumentException("Não foi possível incluir o departamento. É necessário fornecer uma lista de 'empregados'.")
        }

        def departamento = new Departamento(departamentoData)
        departamento.save()
        departamento
    }

    def atualizarDepartamento(Long id, Map departamentoData) {
        validarDadosObrigatorios(departamentoData) // Validate required fields

        def departamento = Departamento.get(id)
        departamento.properties = departamentoData
        departamento.save()
        departamento
    }

    def excluirDepartamento(Long id) {
        def departamento = Departamento.get(id)
        departamento.delete()
        departamento
    }

    private validarDadosObrigatorios(Map departamentoData) {
        def requiredFields = ['nome'] // Add any other required fields here
        def missingFields = requiredFields.findAll { !departamentoData.containsKey(it) }

        if (missingFields) {
            def missingFieldsStr = missingFields.join(', ')
            throw new IllegalArgumentException("Não foi possível incluir o departamento, campo(s) '${missingFieldsStr}' não foi(foram) preenchido(s).")
        }
    }
}

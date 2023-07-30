package projetoapi

class EmpregadoService {

    def listarEmpregados() {
        Empregado.list()
    }

    def buscarEmpregadoPorId(Long id) {
        Empregado.get(id)
    }

    def criarEmpregado(Map empregadoData) {
        def empregado = new Empregado(empregadoData)
        
        empregado.save()
        empregado
    }

    def atualizarEmpregado(Long id, Map empregadoData) {
        def empregado = Empregado.get(id)
        empregado.properties = empregadoData
        empregado.save()
        empregado
    }

    def excluirEmpregado(Long id) {
        def empregado = Empregado.get(id)
        empregado.delete()
        empregado
    }
}

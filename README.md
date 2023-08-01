API Groovy on Grails
Descrição
Esta é uma API construída usando o framework Groovy on Grails, que fornece endpoints para gerenciar departamentos e empregados de uma empresa.

Tecnologias utilizadas
Groovy on Grails (versão 5.3.3): Um framework de aplicativo web baseado em Groovy, que utiliza o ecossistema Grails para agilizar o desenvolvimento.
Endpoints
Departamentos
GET /projetoapi/departamento/: Retorna a lista de todos os departamentos cadastrados.
GET /projetoapi/departamento/{id}: Retorna os detalhes de um departamento específico com base no ID fornecido.
POST /projetoapi/departamento/: Cria um novo departamento com base nos dados fornecidos no corpo da solicitação JSON. Campos obrigatórios: "nome" e "empregados" (uma lista de empregados associados ao departamento).
PUT /projetoapi/departamento/{id}: Atualiza os dados de um departamento existente com base no ID fornecido e nos dados fornecidos no corpo da solicitação JSON. Campos obrigatórios: "nome" e "empregados" (uma lista de empregados associados ao departamento).
DELETE /projetoapi/departamento/{id}: Exclui um departamento com base no ID fornecido.
Empregados
GET /projetoapi/empregado/: Retorna a lista de todos os empregados cadastrados.
GET /projetoapi/empregado/{id}: Retorna os detalhes de um empregado específico com base no ID fornecido.
POST /projetoapi/empregado/: Cria um novo empregado com base nos dados fornecidos no corpo da solicitação JSON. Campos obrigatórios: "nome", "matricula", "dataNascimento" e "departamento" (ID do departamento ao qual o empregado pertence).
PUT /projetoapi/empregado/{id}: Atualiza os dados de um empregado existente com base no ID fornecido e nos dados fornecidos no corpo da solicitação JSON. Campos obrigatórios: "nome", "matricula", "dataNascimento" e "departamento" (ID do departamento ao qual o empregado pertence).
DELETE /projetoapi/empregado/{id}: Exclui um empregado com base no ID fornecido.
Formato de Data
Para as operações de criação e atualização de empregados, o formato de data aceito é 'yyyy-MM-dd'. Caso um formato diferente seja fornecido, a API retornará um erro informando que a data é inválida.

Tratamento de Erros
A API trata erros de forma apropriada e retorna mensagens de erro claras quando campos obrigatórios estão faltando ou quando a data de nascimento do empregado não está no formato correto.

Como usar
Para interagir com a API, utilize uma ferramenta como o Postman ou cURL para fazer solicitações HTTP para os endpoints mencionados acima.

Notas
Certifique-se de incluir os cabeçalhos apropriados nas solicitações, como "Content-Type: application/json" quando enviar dados no formato JSON.
O serviço de departamento realiza validação para garantir que a lista de empregados esteja presente ao criar ou atualizar um departamento. Da mesma forma, o serviço de empregado valida se todos os campos obrigatórios estão presentes ao criar ou atualizar um empregado.
Os dados são armazenados em um banco de dados (que não está detalhado nesta documentação) e as operações CRUD são executadas através dos serviços correspondentes.

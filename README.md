# Prova Android - Cadastro de Produtos para Loja Virtual

Este projeto é um aplicativo Android desenvolvido para modernizar a organização de uma pequena loja de produtos eletrônicos. Ele substitui o controle manual em cadernos por um sistema digital de cadastro e listagem de estoque.

## 🚀 Funcionalidades

- **Cadastro de Produtos:**
  - Nome do produto.
  - Código alfanumérico.
  - Preço (com suporte a decimais e validação de números positivos).
  - Quantidade em estoque (validação de números inteiros positivos).
  - Validação de campos obrigatórios.
- **Listagem de Produtos:**
  - Visualização em lista de todos os itens cadastrados.
  - Exibição de Nome, Código e Preço.
  - Atualização automática ao cadastrar novos itens.
- **Navegação:**
  - Alternância simples entre as telas de cadastro e listagem.

## 🛠 Tecnologias Utilizadas

- **Linguagem:** Java
- **Banco de Dados:** Room Database (Persistência local)
- **Interface (UI):**
  - Material Design Components (CardView, TextInputLayout)
  - Layouts responsivos com ScrollView e ConstraintLayout
  - Esquema de cores personalizado (Azul Escuro e Branco)

## 📁 Estrutura do Projeto (Principais Arquivos)

- `Produto.java`: Entidade que representa a tabela no banco de dados.
- `ProdutoDao.java`: Interface com os métodos de inserção e consulta.
- `ProdutoDatabase.java`: Configuração central do banco de dados Room.
- `CadastroActivity.java`: Lógica de validação e salvamento de produtos.
- `MainActivity.java`: Lógica de listagem e exibição dos dados.

---

**Sugestão de commit:** `docs: adiciona README com detalhes do projeto e tecnologias`

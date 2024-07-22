### Restrições e Regras de Negócio

#### Atributos em Geral:
- **Aceita valor nulo ou não?**
  - Apenas telefone (Entidade) pode ser nulo
- **Será permitido alteração futura?**
  - Apenas CPF (Entidade) não pode ser alterado
- **Deverá ser único?**
  - Apenas CPF (Entidade), e-mail (Entidade), e nome (Perfume) devem ser únicos
- **Padrão (regex):**
  - Apenas CPF (Usuário) e CEP (Endereço) devem seguir um padrão específico


### Requisitos

#### Requisitos Mínimos da Aplicação:

- O sistema tem como objetivo realizar o CRUD de uma entidade. Para isso, faz-se necessário ter uma conta de usuário no sistema.
- O sistema deverá possuir 2 tipos de usuários: **ADMINISTRADOR** e **COMUM**.
  - O Administrador pode cadastrar/alterar/excluir outros usuários.
  - O Comum pode apenas realizar cadastros das entidades, porém só pode acessar as entidades cadastradas por ele (deverá ter relacionamento entre as entidades). Além disso, poderá alterar seus dados e senha.
- A entidade deverá ter pelo menos 10 atributos.
- Os usuários deverão ter atributos comuns e outros diferentes (usar herança).


### Regras de Negócio Específicas para Perfumaria:

#### Usuário:
- Um usuário deve ser registrado no sistema com informações de identificação e contato.
- Um usuário pode adicionar perfumes ao seu carrinho de compras.
  
#### Perfume:
- Um perfume deve ter informações como nome, marca, preço e quantidade em estoque.
- O nome do perfume deve ser único.

#### Carrinho:
- Um carrinho de compras deve ser criado e associado a um usuário.
- Um carrinho de compras pode conter vários perfumes.
- A quantidade de cada perfume no carrinho de compras deve ser registrada.

#### Validações:
- O sistema deve realizar validações para garantir que as informações inseridas sejam válidas, como endereços válidos, métodos de pagamento válidos, etc.

#### Segurança:
- As informações dos usuários, como dados de contato e informações de pagamento, devem ser protegidas de forma segura.

# Faça um fork desse repositório

Este é um repositório vazio de propósito. A ideia é que você faça um fork para que eu, Alberto, possa usar o github para ter a chance de olhar vários dos códigos produzido por você e seus(as) colegas da Jornada Dev Eficiente :). 

Durante cada uma das seis semanas eu vou pegar código por amostragem e analisar. Feito isso, vou criar um vídeo anonimizando a pessoa que é dona do código, com as minhas observações e postar isso como material de suporte da funcionalidade :). 

------------------------------------------------------

### Primeiro Card: 

- É necessário cadastrar um novo autor no sistema. Todo autor tem um nome, email e uma descrição. Também queremos saber o instante exato que ele foi registrado.
restrições
  - O instante não pode ser nulo
  - O email é obrigatório
  - O email tem que ter formato válido
  - O nome é obrigatório
  - A descrição é obrigatória e não pode passar de 400 caracteres

Resultado esperado:
  - Um novo autor criado e status 200 retornado

### Segundo Card: 

- O email do autor precisa ser único no sistema

Resultado esperado:
  - Erro de validação no caso de email duplicado
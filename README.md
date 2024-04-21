# **Projeto Intermediário**

## Disciplina de Backend - Professor Ramon Venson - SATC 2024

A API que decidi utilizar nesse projeto foi relacionada a QUIZ pois estou desenvolvendo na disciplina de "Projeto Integrador: Sistema Web" um software sobre esse tema direcionado a um público infantíl.

### Estrutura do Projeto

O projeto foi construido conforme a estrutura a seguir:

- **pacote aplicacao**
    - QuizQuestion
    - SpringBootQuizApplication

- **pacote controller**
    - QuizController

- **pacote service**
    - QuizService

 ### Explicação Projeto

- **QuizQuestion**
O primeiro passo seria verificar os campos do arquivo JSON da API e passar para essa classe "QuizQuestion" os mesmo campos para fazer os atributos, após isso deve-se criar o nosso Construtor que serve para criar objetos e o mesmo aceita parâmetros para todos os atributos da classe, também foi feito os Getters para obter o valor do atributo e os Setters para definir o valor do atributo.
Basicamente essa classe serve como um modelo para representar perguntas de quiz em Java, permitindo que se possa definir e acessar diferentes aspectos de uma pergunta como por exemplo o tipo, dificuldade, categoria, etc.

- **SpringBootQuizApplication**
O SpringBootQuizApplication é a classe principal da minha aplicação Spring Boot. Ele configura e inicia a aplicação, permitindo que o Spring Boot gerencie os componentes e forneça a infraestrutura necessária para executar a aplicação. Isso é feito através da anotação @SpringBootApplication, que combina várias outras anotações e permite a configuração automática, o escaneamento de componentes e a execução da aplicação. O método main() é o ponto de entrada da aplicação, iniciando o contexto Spring Boot com a chamada a SpringApplication.run().

- **QuizController**
Primeiramente utilizei as anotações @RestController para lidar com solicitações HTTP e retornar os resultados diretamente no formato JSON e @RequestMapping("/quiz") para dizer que as solicitações começarão com "/quiz".
Depois utilizei um @Autowired para passar uma instância de "QuizService" no controlador, assim ele vai permitir que o controlador utilize os métodos fornecidos pelo serviço do quiz para realizar operações como obter perguntas e validar respostas conforme solicitado pelo professor. E utilizei o construtor para receber uma instância de "QuizService" para permitir que o Spring injete automaticamente uma instância de "QuizService" no controlador quando ele é criado para garantir que ele tenha acesso aos métodos do serviço.
Além disso foram criados 01 @PostMapping e 02 @GetMapping para fazerem as seguintes funções:

  - **@GetMapping("/questions"):** Quando você requisitar ele no Insomnia atráves do "http://localhost:8090/quiz/questions"  ele vai fornecer um JSON de todas as perguntas da API do Quiz.
    
  - **@PostMapping("/enviar"):** Envia as respostas dadas pelo usuário atráves do "http://localhost:8090/quiz/enviar" para serem processadas e avaliadas pelo sistema e retorna uma mensagem de sucesso.
    
  - **GetMapping("/ajuda"):** Por fim esta requisição vai fornecer informações de ajuda sobre o projeto que no caso é o nome do projeto + nome aluno em formato JSON através do "http://localhost:8090/quiz/ajuda".

- **QuizService**
Primeiramente utilizei a anotação @Service para marcar a classe como um componente de serviço gerenciado pelo Spring.
Criei a "apiUrl" para colocar a URL da API externa que fornece as perguntas do quiz.
Utilizei uma instância "RestTemplate" para fazer requisições HTTP para a API externa.
Elaborei um mapa que será usado para armazenar as respostas dos usuários, onde a chave é o ID da pergunta e o valor é a resposta do usuário.
Ale´m disso foram criados também 04 métodos:

  - **obterQuizQuestions:** Ele faz uma requisição GET para a API externa e retorna as perguntas do quiz em formato de string.
  
  - **validarResposta:** Ele verifica se a resposta fornecida pelo usuário para determinada pergunta é correta. Ele recebe o ID da pergunta e a resposta fornecida pelo usuário, compara essa resposta com a resposta correta recuperada do mapa "perguntas" e retorna TRUE se forem iguais e FALSE caso sejam falsas.
  
  - **armazenarResposta:** Esse método vai armazenar a resposta fornecida pelo usuário para uma determinada pergunta no mapa "resposta". Para isso ele vai receber o ID da pergunta e a resposta fornecidas pelo usuário e armazenar no mapa.

  - **obterTodasRespostas:** Por fim esse método vai retornar todas as respostas fornecidas pelo usuário até o momento e vai retornar o mapa "respostas" que contem todas as respostas armazenadas.

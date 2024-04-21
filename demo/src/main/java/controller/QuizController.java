package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/quiz")
public class QuizController {

    private final RestTemplate restTemplate;

    @Autowired
    public QuizController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @GetMapping("/questions")
    public String getQuizQuestions() {
        String apiUrl = "https://opentdb.com/api.php?amount=10&category=27&difficulty=easy&type=multiple";
        return restTemplate.getForObject(apiUrl, String.class);
    }

    @PostMapping("/enviar")
    public String enviarQuizAnswers() {
        return "Respostas do quiz enviadas com sucesso!";
    }

    @GetMapping("/ajuda")
    public String getAjuda() {
        return "{\n" +
                "  \"estudante\": \"Wallace da Silva Mendes\",\n" +
                "  \"projeto\": \"Web Service com API Externa de Quiz\"\n" +
                "}";
    }
}

package service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Service
public class QuizService {

    private final String apiUrl = "https://opentdb.com/api.php?amount=10&category=27&difficulty=easy&type=multiple";
    private final RestTemplate restTemplate = new RestTemplate();
    private Map<Integer, String> respostas = new HashMap<>();

    public QuizService() {
    }

    public String obterQuizQuestions() {
        return restTemplate.getForObject(apiUrl, String.class);
    }

    public boolean validarResposta(int idPergunta, String resposta) {
        return true;
    }

    public void armazenarResposta(int idPergunta, String resposta) {
        respostas.put(idPergunta, resposta);
    }

    public Map<Integer, String> obterTodasRespostas() {
        return respostas;
    }
}

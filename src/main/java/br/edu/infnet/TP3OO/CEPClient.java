package br.edu.infnet.TP3OO;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class CEPClient {
    
    public CEP buscaCEP(String cep){
        RestTemplate template = new RestTemplate();
        return template.getForObject("https://viacep.com.br/ws/{cep}/json/", CEP.class, cep);
    }
}

package br.edu.infnet.TP3OO;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonController {
    private final PessoaService pessoaService;

    public PersonController(PessoaService pessoaService) {
        this.pessoaService = pessoaService;
    }
    
    @GetMapping("/pessoas")
    List<Pessoa> all(){
        return pessoaService.findAll();
    }
    
    @PostMapping("/registrarPessoas")
    Pessoa register(String nome, String email, String telefone, String cep, String logradouro,
                    String bairro, String localidade){
        return pessoaService.register(nome, email, telefone, cep);
    }
    
}

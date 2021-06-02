package br.edu.infnet.TP3OO;

import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class PessoaService {
    private final IPessoaRepository pr;
    
    public PessoaService(IPessoaRepository pr) {
        this.pr = pr;
    }
    
    public Pessoa register(String nome, String email, String telefone, String cep){
    	CEPClient pc = new CEPClient();
    	CEP endereco = pc.buscaCEP(cep);
    	String cepClasse = endereco.getCep();
    	String logradouro = endereco.getLogradouro();
    	String bairro = endereco.getBairro();
    	String localidade = endereco.getLocalidade();
    	return this.pr.save(new Pessoa(nome, email, telefone, cepClasse, logradouro, bairro, localidade));
    }
    
    @Transactional(readOnly = true)
    public List<Pessoa> findAll(){
        return this.pr.findAll();
    }
}

package br.edu.infnet.TP3OO;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class PessoaService {
    private final IPessoaRepository pessoaRepository;
    
    public PessoaService(IPessoaRepository pessoaRepository) {
        this.pessoaRepository = pessoaRepository;
    }
    
    public Pessoa registrar(String nome, String email, String telefone, String cep){
    	CEPClient cc = new CEPClient();
    	CEP endereco = cc.buscaCEP(cep);
    	String cepClasse = endereco.getCep();
    	String logradouro = endereco.getLogradouro();
    	String bairro = endereco.getBairro();
    	String localidade = endereco.getLocalidade();
    	return this.pessoaRepository.save(new Pessoa(nome, email, telefone, cepClasse, logradouro, bairro, localidade));
    }
    
    @Transactional(readOnly = true)
    public List<Pessoa> listaDePessoas(){
        return this.pessoaRepository.findAll();
    }
    
    @Transactional(readOnly = true)
    public Pessoa getPessoa(Integer id) {
        Optional<Pessoa> res = this.pessoaRepository.findById(id);
        return res.orElse(null);
    }
    
    public void alterarPessoa(Integer id, Pessoa pessoa){  
        pessoa.setId(id);
        pessoaRepository.save(pessoa);
    }

}

package br.edu.infnet.TP3OO;

import java.util.List;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class PessoaController {
    private final PessoaService pessoaService;
    private final AmazonClient amazonClient;

    public PessoaController(PessoaService pessoaService, AmazonClient amazonClient) {
        this.pessoaService = pessoaService;
        this.amazonClient = amazonClient;
    }
    
    @GetMapping("/pessoas")
    List<Pessoa> lista(){
        return pessoaService.listaDePessoas();
    }
    
    @RequestMapping(method = {RequestMethod.GET}, value = "/consultarPessoa/{id}")
    Pessoa consultarPorId(@PathVariable Integer id){
        return pessoaService.getPessoa(id);
    }
    
    @PostMapping("/registrarPessoas")
    Pessoa registrarPessoa(String nome, String email, String telefone, String cep, @RequestPart(value = "file") MultipartFile file){
        amazonClient.uploadFile(file);
        return pessoaService.registrar(nome, email, telefone, cep);
    }
    
    @RequestMapping(method = {RequestMethod.PUT}, value = "/alterarPessoa/{id}")
    public void alterarPessoaHTTP(@PathVariable Integer id, @RequestBody Pessoa pessoa) {  
        pessoaService.alterarPessoa(id, pessoa);
    }
    
    @DeleteMapping("/deleteFile")
    public String deleteFile(@RequestPart(value = "url") String fileUrl) {
        return this.amazonClient.deleteFileFromBucketS3(fileUrl);
    }
}

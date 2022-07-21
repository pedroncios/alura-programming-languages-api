package br.com.pedroncios.programminglanguages.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LinguagemController {

    @Autowired
    private LinguagemRepository repositorio;
    
    @GetMapping("/linguagem-preferida")
    public String processaLinguagemPreferida() {
        return "Pode ter certeza que não é Java! LOL";
    }

    @GetMapping("/linguagens")
    public List<Linguagem> obterLinguagens() {
        return repositorio.findAll(Sort.by(Sort.Direction.ASC, "rank"));
    }

    @GetMapping("/linguagens/{id}")
    public Linguagem obterLinguagem(@PathVariable String id) {
        return repositorio.findById(id).orElseThrow(() -> new RuntimeException("Erro ao buscar linguagem com id: " + id));
    }

    @PostMapping("/linguagens")
    @ResponseStatus(HttpStatus.CREATED)
    public Linguagem cadastrarLinguagem(@RequestBody Linguagem linguagem) {
        Linguagem retorno = repositorio.save(linguagem);
        return retorno;
    }

    @DeleteMapping("/linguagens/{id}")
    public void apagarLinguagem(@PathVariable String id) {
        repositorio.deleteById(id);
    }

    /*@PutMapping("/linguagens/{id}")
    public Linguagem alterarLinguagem(@RequestBody Linguagem novaLinguagem, @PathVariable String id) {
        return repositorio.findById(id)
            .map(linguagem -> {
                linguagem.set
            });
    }*/
}

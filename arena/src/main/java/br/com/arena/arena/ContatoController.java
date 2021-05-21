package br.com.arena.arena;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;



@Controller
public class ContatoController {
    
@Autowired
ContatoRepository contatoRepository;

@GetMapping(value = "/lista2")    
public ModelAndView getlista2(){
 List<Contato> lista = new ArrayList<>();

 lista = contatoRepository.findAll();

 ModelAndView modelAndView = new ModelAndView("lista2");

 modelAndView.addObject("lista", lista);
 
    return modelAndView;
}

@GetMapping(value = "/sobre")    
public ModelAndView getsobre(){
    ModelAndView modelAndView = new ModelAndView("sobre");
    return modelAndView;
}

@GetMapping(value = "/contato")    
public ModelAndView getcontato(){
    ModelAndView modelAndView = new ModelAndView("contato");
    return modelAndView;
}


@GetMapping(value = "/cadastro")    
public ModelAndView getcadastro(){
    ModelAndView modelAndView = new ModelAndView("cadastro");
    return modelAndView;
}
@PostMapping(value = "/adicionar")
public ModelAndView postAdicionar(@RequestParam String nome, @RequestParam String cargo, @RequestParam String cidade){

    Contato contato = new Contato();

    contato.setNome(nome);
    contato.setCargo(cargo);
    contato.setCidade(cidade);

    contatoRepository.save(contato);

    ModelAndView modelAndView = new ModelAndView("lista");

    modelAndView.addObject("contato", contato);


return modelAndView;


}
}

package br.com.arena.arena;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

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
@GetMapping(value="/detalhes/{id}")
    public ModelAndView getDetalhes(@PathVariable Long id) {
       
        Contato contato = new Contato();
        contato = contatoRepository.findById(id).get();

       
        ModelAndView modelAndView = new ModelAndView("lista");

      
        modelAndView.addObject("contato", contato);

    
        return modelAndView;
}

@GetMapping(value = "/cadastro")    
public ModelAndView getCadastro() {
    List<Contato> lista = new ArrayList<>();

    lista = contatoRepository.findAll();
    Contato contato = new Contato();

    ModelAndView modelAndView = new ModelAndView("cadastro");

    modelAndView.addObject("contato", contato);
    modelAndView.addObject("lista", lista);
    return modelAndView;
}
@GetMapping(value = "/acesso")    
public ModelAndView getacesso(){
    ModelAndView modelAndView = new ModelAndView("acesso");
    return modelAndView;
}
@PostMapping(value = "/adicionar")
public ModelAndView postAdicionar(Contato contato) {

    contatoRepository.save(contato);

    ModelAndView modelAndView = new ModelAndView("lista");

    modelAndView.addObject("contato", contato);


return modelAndView;
}
@GetMapping(value="/editar/{id}")
    public ModelAndView getEditar(@PathVariable Long id) {
     
        Contato contato = new Contato();
        contato = contatoRepository.findById(id).get();

     
        ModelAndView modelAndView = new ModelAndView("cadastro");

      
        modelAndView.addObject("contato", contato);

 
        return modelAndView;
    }
    

    @GetMapping(value="/deletar/{id}")
    public String getDeletar(@PathVariable Long id) {
     
        contatoRepository.deleteById(id);

      
        return "redirect:/cadastro";
    
}
}

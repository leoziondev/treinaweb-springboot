package br.com.webdzion.twclients.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.webdzion.twclients.model.Client;
import br.com.webdzion.twclients.repository.ClientRepository;

@Controller
@RequestMapping("/cliente")
public class ClientController {

  @Autowired
  private ClientRepository clientRepository;

  @GetMapping
  public ModelAndView index() {
    ModelAndView modelAndView = new ModelAndView("cliente/index.html");

    List<Client> clientes = clientRepository.findAll();
    modelAndView.addObject("clientes", clientes);

    return modelAndView;
  }

  @GetMapping("/{id}")
  public ModelAndView show(@PathVariable Long id) {
    ModelAndView modelAndView = new ModelAndView("cliente/show.html");

    Client cliente = clientRepository.getReferenceById(id);
    modelAndView.addObject("cliente", cliente);

    return modelAndView;
  }

  @GetMapping("/{id}/excluir")
  public ModelAndView destroy(@PathVariable Long id) {
    ModelAndView modelAndView = new ModelAndView("redirect:/cliente");

    clientRepository.deleteById(id);

    return modelAndView;
  }

  @GetMapping("/cadastrar")
  public ModelAndView create() {
    ModelAndView modelAndView = new ModelAndView("cliente/form");

    modelAndView.addObject("cliente", new Client());

    return modelAndView;
  }
  
  @PostMapping("/cadastrar")
  public ModelAndView store(Client cliente) {
    ModelAndView modelAndView = new ModelAndView("redirect:/cliente");

    clientRepository.save(cliente);

    return modelAndView;
  }

  @GetMapping("/{id}/editar")
  public ModelAndView edit(@PathVariable Long id) {
    ModelAndView modelAndView = new ModelAndView("cliente/form");

    Client cliente = clientRepository.getReferenceById(id);
    modelAndView.addObject("cliente", cliente);

    return modelAndView;
  }

  @PostMapping("/{id}/editar")
  public ModelAndView edit(Client cliente) {
    ModelAndView modelAndView = new ModelAndView("redirect:/cliente");

    clientRepository.save(cliente);

    return modelAndView;
  }
}

package br.com.webdzion.twclients.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/")
public class HomeController {
  
  @GetMapping("/")
  public String home() {
    return "home";
  }

  @GetMapping("/mensagem")
  public ModelAndView mensagem() {
    ModelAndView modelAndView = new ModelAndView();

    modelAndView.setViewName("mensagem");
    modelAndView.addObject("mensagem", "Mensagem vinda do server via Model And View");

    return modelAndView;
  }

  @GetMapping("/saudacao")
  public ModelAndView suadacao(@RequestParam(required = false, defaultValue = "Spring Boot") String nome) {
    ModelAndView modelAndView = new ModelAndView();

    modelAndView.setViewName("saudacao");
    modelAndView.addObject("nome", nome);

    return modelAndView;
  }

}

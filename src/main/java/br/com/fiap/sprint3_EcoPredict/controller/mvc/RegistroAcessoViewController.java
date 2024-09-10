package br.com.fiap.sprint3_EcoPredict.controller.mvc;

import br.com.fiap.sprint3_EcoPredict.model.RegistroAcesso;
import br.com.fiap.sprint3_EcoPredict.repository.RegistroAcessoRepository;
import br.com.fiap.sprint3_EcoPredict.response.RegistroAcessoResponse;
import br.com.fiap.sprint3_EcoPredict.service.RegistroAcessoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
public class RegistroAcessoViewController {

    @Autowired
    private RegistroAcessoService registroAcessoService;
    @Autowired
    private RegistroAcessoRepository registroAcessoRepository;

    @GetMapping("/listaAcessos")
    public ModelAndView listaAcessos() {
        List<RegistroAcesso> listaAcessos = registroAcessoRepository.findAll();
        List<RegistroAcessoResponse> listaAcessosResponse = new ArrayList<>();
        for (RegistroAcesso registroAcesso : listaAcessos) {
            listaAcessosResponse.add(registroAcessoService.registroAcessoToResponse(registroAcesso));
        }
        ModelAndView mv = new ModelAndView("registroAcesso");
        mv.addObject("listaAcessos", listaAcessosResponse);
        return mv;
    }
}

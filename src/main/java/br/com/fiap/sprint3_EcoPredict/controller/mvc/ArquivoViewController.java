package br.com.fiap.sprint3_EcoPredict.controller.mvc;

import br.com.fiap.sprint3_EcoPredict.model.Arquivo;
import br.com.fiap.sprint3_EcoPredict.repository.ArquivoRepository;
import br.com.fiap.sprint3_EcoPredict.response.ArquivoResponse;
import br.com.fiap.sprint3_EcoPredict.service.ArquivoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ArquivoViewController {

    @Autowired
    private ArquivoService arquivoService;
    @Autowired
    private ArquivoRepository arquivoRepository;

    @GetMapping("/listaArquivos")
    public ModelAndView listaArquivos() {
        List<Arquivo> listaArquivos = arquivoRepository.findAll();
        List<ArquivoResponse> listaArquivosResponse = new ArrayList<>();
        for (Arquivo arquivo : listaArquivos) {
            listaArquivosResponse.add(arquivoService.arquivoToResponse(arquivo));
        }
        ModelAndView mv = new ModelAndView("arquivo");
        mv.addObject("listaArquivos", listaArquivosResponse);
        return mv;
    }
}

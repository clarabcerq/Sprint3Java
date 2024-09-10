package br.com.fiap.sprint3_EcoPredict.controller.mvc;

import br.com.fiap.sprint3_EcoPredict.model.Usuario;
import br.com.fiap.sprint3_EcoPredict.repository.UsuarioRepository;
import br.com.fiap.sprint3_EcoPredict.response.UsuarioResponse;
import br.com.fiap.sprint3_EcoPredict.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
public class UsuarioViewController {

    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("/listaUsuarios")
    public ModelAndView listaUsuarios() {
        List<Usuario> listaUsuarios = usuarioRepository.findAll();
        List<UsuarioResponse> listaUsuariosResponse = new ArrayList<>();
        for (Usuario usuario : listaUsuarios) {
            listaUsuariosResponse.add(usuarioService.usuarioToResponse(usuario));
        }
        ModelAndView mv = new ModelAndView("usuario");
        mv.addObject("listaUsuarios", listaUsuariosResponse);
        return mv;
    }
}

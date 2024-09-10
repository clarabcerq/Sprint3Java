package br.com.fiap.sprint3_EcoPredict.controller.mvc;

import br.com.fiap.sprint3_EcoPredict.model.Produto;
import br.com.fiap.sprint3_EcoPredict.repository.ProdutoRepository;
import br.com.fiap.sprint3_EcoPredict.response.ProdutoResponse;
import br.com.fiap.sprint3_EcoPredict.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ProdutoViewController {

    @Autowired
    private ProdutoRepository produtoRepository;
    @Autowired
    private ProdutoService produtoService;

    @GetMapping("/listaProdutos")
    public ModelAndView listaProdutos() {
        List<Produto> listaProdutos = produtoRepository.findAll();
        List<ProdutoResponse> listaProdutosResponse = new ArrayList<>();
        for (Produto produto : listaProdutos) {
            listaProdutosResponse.add(produtoService.produtoToResponse(produto));
        }
        ModelAndView mv = new ModelAndView("produto");
        mv.addObject("listaProdutos", listaProdutosResponse);
        return mv;
    }
}

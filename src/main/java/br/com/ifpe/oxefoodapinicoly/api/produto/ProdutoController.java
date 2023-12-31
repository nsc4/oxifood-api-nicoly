package br.com.ifpe.oxefoodapinicoly.api.produto;
import java.util.List;

import javax.persistence.Id;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.ifpe.oxefoodapinicoly.modelo.Produto;
import br.com.ifpe.oxefoodapinicoly.modelo.produto.ProdutoService;

@RestController
@RequestMapping("/api/produto")
@CrossOrigin
public class ProdutoController {

    @Id
   @Autowired
   private ProdutoService produtoService;

   @PostMapping
   public ResponseEntity<Produto> save(@RequestBody ProdutoRequest request) {

      Produto produto = produtoService.save(request.build());
       return new ResponseEntity<Produto>(produto, HttpStatus.CREATED);
   }
   @Id
    @GetMapping
    public List<Produto> findAll() {
  
        return produtoService.findAll();
    }
    @Id
        @GetMapping("/{id}")
    public Produto findById(@PathVariable Long id) {

        return produtoService.findById(id);
    }
}
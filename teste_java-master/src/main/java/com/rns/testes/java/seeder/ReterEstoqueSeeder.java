package com.rns.testes.java.seeder;


import com.rns.testes.java.model.Estoque;
import com.rns.testes.java.model.Filial;
import com.rns.testes.java.model.Produto;
import com.rns.testes.java.service.IEstoqueService;
import com.rns.testes.java.service.IFilialService;
import com.rns.testes.java.service.IProdutoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class ReterEstoqueSeeder {

    @Autowired
    IEstoqueService estoqueService;

    @Autowired
    IFilialService filialService;

    @Autowired
    IProdutoService produtoService;

    @EventListener
    public void seedEstoque(ContextRefreshedEvent event) {
        try {
            log.info("Criando estoques....");
            criandoEstoques();
        } catch (Exception e) {
            log.error(e.getMessage());
        }

    }
        private void criandoEstoques()  {


        Produto prod1 = produtoService.findById( "Cod-Produto-1" );
        Produto prod2 = produtoService.findById( "Cod-Produto-2" );
        Produto prod3 = produtoService.findById( "Cod-Produto-3" );
        Produto prod4 = produtoService.findById( "Cod-Produto-4" );

        Filial filial1 = filialService.findById((long) 1);
        Filial filial2 = filialService.findById((long) 2);
        Filial filial3 = filialService.findById((long) 3);
        Filial filial4 = filialService.findById((long) 4);

        Estoque galpao_prod1 = new Estoque();
        galpao_prod1.setProduto( prod1);
        galpao_prod1.setFilial( filial1 );
        galpao_prod1.setQuantidade(8 );

        estoqueService.save(galpao_prod1);

        Estoque galpao_prod2 = new Estoque();
        galpao_prod2.setProduto( prod2 );
        galpao_prod2.setFilial( filial2 );
        galpao_prod2.setQuantidade( 5 );

        estoqueService.save(galpao_prod2);

        Estoque galpao_prod3 = new Estoque();
        galpao_prod3.setProduto( prod3 );
        galpao_prod3.setFilial( filial3 );
        galpao_prod3.setQuantidade( 3 );

        estoqueService.save(galpao_prod3);

        Estoque galpao_prod4 = new Estoque();
        galpao_prod4.setProduto( prod4);
        galpao_prod4.setFilial( filial4 );
        galpao_prod4.setQuantidade( 4 );

        estoqueService.save(galpao_prod4);

         Estoque galpao_prod5 = new Estoque();
         galpao_prod5.setProduto( prod4);
         galpao_prod5.setFilial( filial1 );
         galpao_prod5.setQuantidade( 4 );

         estoqueService.save(galpao_prod5);

         Estoque galpao_prod6 = new Estoque();
         galpao_prod6.setProduto( prod3);
         galpao_prod6.setFilial( filial2 );
         galpao_prod6.setQuantidade( 9 );

         estoqueService.save(galpao_prod6);
        
          Estoque galpao_prod7 = new Estoque();
          galpao_prod7.setProduto( prod4);
          galpao_prod7.setFilial( filial1 );
          galpao_prod7.setQuantidade( 12 );

          estoqueService.save(galpao_prod4);


//
//        Estoque lojaBtoC1 = new Estoque();
//        lojaBtoC1.setRazaoSocial("Loja São Paulo LTDA");
//        lojaBtoC1.setCnpj("72.286.494/0001-23");
//        lojaBtoC1.setTipoEstoque(EnumTipoEstoque.LOJA_PF);
//        lojaBtoC1.setEndereco("Av. Paulista, 111, São Paulo - SP");
//
//        estoqueService.save(lojaBtoC1);
//
//        Estoque lojaBtoC2 = new Estoque();
//        lojaBtoC2.setRazaoSocial("Loja Rio de Janeiro LTDA");
//        lojaBtoC2.setCnpj("50.935.855/0001-82");
//        lojaBtoC2.setTipoEstoque(EnumTipoEstoque.LOJA_PF);
//        lojaBtoC2.setEndereco("Av. Barata Ribeiro, 199, Rio de Janeiro - RJ");
//
//        estoqueService.save(lojaBtoC2);
//
//        Estoque lojaBtoB = new Estoque();
//        lojaBtoB.setRazaoSocial("Loja To Loja LTDA");
//        lojaBtoB.setCnpj("82.602.541/0001-54");
//        lojaBtoB.setTipoEstoque(EnumTipoEstoque.LOJA_PJ);
//        lojaBtoB.setEndereco("Av. Barata Ribeiro, 124, Rio de Janeiro - RJ");
//
//        estoqueService.save(lojaBtoB);
    }
}

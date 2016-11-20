package br.edu.facisa.sigelar.bean;

import java.io.IOException;
import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import org.omnifaces.util.Faces;
import org.omnifaces.util.Messages;

import br.edu.facisa.sigelar.dao.ProdutoDAO;
import br.edu.facisa.sigelar.domain.Produto;

@ManagedBean
@ViewScoped
public class BeanProdutoCRUD implements Serializable {

	private static final long serialVersionUID = 4952476482356094470L;
	private List<Produto> produtos;
//	private List<Produto> produtosFiltrados;

	@PostConstruct
	public void init() {
		ProdutoDAO<Produto> pd = new ProdutoDAO<Produto>();
		produtos = pd.listar();
	}


	public void editar(ActionEvent evento) {
		try {
			Produto produto = new Produto();
			produto = (Produto) evento.getComponent().getAttributes().get("selecionadoCorrente");
			String idProd = produto.getCodigoProduto();
			BeanBoxNavigation box = BeanBoxNavigation.getInstance();
			box.setId(idProd);
			Faces.redirect("./pages/produto/produtoCadastro.xhtml");
		} catch (IOException e) {
			Messages.addGlobalInfo("Erro ao tentar editar o produto");
		}

	}

	public void excluir(ActionEvent evento) {
		Produto produto = new Produto();
		try {
		produto = (Produto) evento.getComponent().getAttributes().get("selecionadoCorrente");
		ProdutoDAO<Produto> pd = new ProdutoDAO<Produto>();
		pd.excluir(produto);
			Faces.redirect("./pages/produto/produtoCRUD.xhtml");
		} catch (IOException e) {
			Messages.addGlobalInfo("Erro ao tentar excluir o produto");
		}
	}

//	public List<Produto> getProdutosFiltrados() {
//		return produtosFiltrados;
//	}
//
//	public void setProdutosFiltrados(List<Produto> produtosFiltrados) {
//		this.produtosFiltrados = produtosFiltrados;
//	}

	public List<Produto> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}
}

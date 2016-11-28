package br.edu.facisa.sigelar.bean;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.omnifaces.util.Messages;

import br.edu.facisa.sigelar.dao.ProdutoDAO;
import br.edu.facisa.sigelar.domain.Produto;

@ManagedBean
@ViewScoped
public class BeanAlmoxarifadoSolicitar implements Serializable {

	private static final long serialVersionUID = 4952476482356094470L;
	private Produto produto;

	@PostConstruct
	public void init() {
		produto = new Produto();
		String id = BeanBoxNavigation.getInstance().getId();
		if (id != null && id != "") {
			ProdutoDAO<Produto> pd = new ProdutoDAO<Produto>();
			produto = pd.buscar(id);
			BeanBoxNavigation.getInstance().clean();
		}
	}

	public void salvar() {

		try {
			ProdutoDAO<Produto> pd = new ProdutoDAO<Produto>();
			pd.merge(produto);
			Messages.addGlobalInfo("Produto: " + produto.getNome() + " cadastrado com sucesso!");
			produto = new Produto();
		} catch (Exception e) {
			Messages.addGlobalError("Erro ao cadastrar produto");
		}
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

}

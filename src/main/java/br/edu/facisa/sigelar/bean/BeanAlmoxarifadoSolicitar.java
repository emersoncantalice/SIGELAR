package br.edu.facisa.sigelar.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.omnifaces.util.Messages;

import br.edu.facisa.sigelar.dao.ProdutoDAO;
import br.edu.facisa.sigelar.dao.SolicitacaoDAO;
import br.edu.facisa.sigelar.domain.Produto;
import br.edu.facisa.sigelar.domain.Solicitacao;

@ManagedBean
@ViewScoped
public class BeanAlmoxarifadoSolicitar implements Serializable {

	private static final long serialVersionUID = 4952476482356094470L;
	private Produto produto;
	private List<Produto> produtos;
	private Solicitacao solicitacao;

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@PostConstruct
	public void init() {
		ProdutoDAO pd = new ProdutoDAO();
		produtos = pd.listar();
	}

	public void salvar() {

		try {
			SolicitacaoDAO sd = new SolicitacaoDAO();
			solicitacao.setProduto(produto.getNome());
			sd.merge(solicitacao);
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

	public List<Produto> getProdutos() {
		return produtos;
	}

	public Solicitacao getSolicitacao() {
		return solicitacao;
	}

	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}

	public void setSolicitacao(Solicitacao solicitacao) {
		this.solicitacao = solicitacao;
	}

}

package br.edu.facisa.sigelar.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;
import javax.faces.model.SelectItem;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;

import org.omnifaces.util.Messages;

import com.google.gson.Gson;

import br.edu.facisa.sigelar.domain.ExemploDomain;
import br.edu.facisa.sigelar.util.EnumCursos;
import br.edu.facisa.sigelar.util.EnumOperacoesCRUD;

@ManagedBean
@ViewScoped
public class BeanDeExemploCRUD implements Serializable {

	private static final long serialVersionUID = 4952476482356094470L;
	private ExemploDomain participante;
	private List<ExemploDomain> participantes;
	private List<ExemploDomain> participantesFiltrados;
	private EnumOperacoesCRUD operacao;
	private List<SelectItem> listaAreasInteresse;
	private List<SelectItem> listaPeriodos;
	private List<SelectItem> listaDeCursos;
	private String areaInteresse;
	private static final String CAMINHO_SERVICO = "http://localhost:8080/EFEC/Restful";

	@PostConstruct
	public void init() {
		listar();
	}

	public void instanciarNovo() {

		try {

			participante = new ExemploDomain();
			operacao = EnumOperacoesCRUD.CADASTAR;

			listar();

			popularCursos();

		} catch (Exception e) {
			Messages.addGlobalError("Erro ao carregar a página de cadastro");
		}
	}

	private void popularCursos() {
		listaDeCursos = new ArrayList<SelectItem>();

		for (EnumCursos curso : EnumCursos.values()) {
			listaDeCursos.add(new SelectItem(curso.getNome()));
		}

	}

	public boolean EalunoFacisa() {
		boolean retorno = false;
		if (participante != null) {
			if (participante.getEstudanteFacisa() != null) {
				if (participante.getEstudanteFacisa() == 'S') {
					retorno = true;
				} else {
					participante.setCurso(null);
					participante.setMatricula(null);
					participante.setPeriodo(null);
					retorno = false;
				}
			}
		}
		return retorno;
	}

	public void excluir(ActionEvent event) {
		try {

			participante = (ExemploDomain) event.getComponent().getAttributes().get("selecionadoCorrente");

			Client cliente = ClientBuilder.newClient();
			WebTarget pathService = cliente.target(CAMINHO_SERVICO + "/participante/").path("{codigo}")
					.resolveTemplate("codigo", participante.getId());
			System.out.println("AQUI CHEGUEI");
			pathService.request().delete();

			listar();

			Messages.addGlobalInfo("ExemploDomain: " + participante.getNome() + " excluido com sucesso!");
		} catch (Exception e) {
			Messages.addGlobalError("Erro ao excluir o participante");
		}
	}

	public void editar(ActionEvent event) {

		try {

			participante = (ExemploDomain) event.getComponent().getAttributes().get("selecionadoCorrente");
			operacao = EnumOperacoesCRUD.EDITAR;
			System.out.println(participante);
			popularCursos();

		} catch (Exception e) {
			Messages.addGlobalError("Erro ao carregar a página de edição");
		}
	}

	public void listar() {
		try {

			Client cliente = ClientBuilder.newClient();
			WebTarget pathService = cliente.target(CAMINHO_SERVICO + "/participante");
			String json = pathService.request().get(String.class);

			Gson gson = new Gson();
			ExemploDomain[] participantesVetor = gson.fromJson(json, ExemploDomain[].class);
			participantes = Arrays.asList(participantesVetor);
			participantesFiltrados = participantes;

		} catch (Exception e) {
			Messages.addGlobalError("Erro ao listar participantes");
		}
	}

	public void salvar() {

		if (operacao.equals(EnumOperacoesCRUD.EDITAR)) {
			try {
				Client cliente = ClientBuilder.newClient();
				WebTarget pathService = cliente.target(CAMINHO_SERVICO + "/participante");
				Gson gson = new Gson();
				String json = gson.toJson(participante);
				pathService.request().put(Entity.json(json));
				Messages.addGlobalInfo("ExemploDomain: " + participante.getNome() + " editado com sucesso!");
				listar();
			} catch (Exception e) {
				Messages.addGlobalError("Ocorreu um erro, participante não foi editado");
			}
		} else {
			try {
				Client cliente = ClientBuilder.newClient();
				WebTarget pathService = cliente.target(CAMINHO_SERVICO + "/participante");
				Gson gson = new Gson();
				String json = gson.toJson(participante);
				pathService.request().post(Entity.json(json));
				Messages.addGlobalInfo("ExemploDomain: " + participante.getNome() + " salvo(a) com sucesso!");
				participante = new ExemploDomain();
				listar();
			} catch (Exception e) {
				Messages.addGlobalError("Ocorreu um erro, participante não foi adicionado");
			}
		}

	}

	public ExemploDomain getParticipante() {
		return participante;
	}

	public List<ExemploDomain> getParticipantes() {
		return participantes;
	}

	public List<ExemploDomain> getParticipantesFiltrados() {
		return participantesFiltrados;
	}

	public EnumOperacoesCRUD getOperacao() {
		return operacao;
	}

	public List<SelectItem> getListaAreasInteresse() {
		return listaAreasInteresse;
	}

	public List<SelectItem> getListaPeriodos() {
		return listaPeriodos;
	}

	public List<SelectItem> getListaDeCursos() {
		return listaDeCursos;
	}

	public String getAreaInteresse() {
		return areaInteresse;
	}

	public void setParticipante(ExemploDomain participante) {
		this.participante = participante;
	}

	public void setParticipantes(List<ExemploDomain> participantes) {
		this.participantes = participantes;
	}

	public void setParticipantesFiltrados(List<ExemploDomain> participantesFiltrados) {
		this.participantesFiltrados = participantesFiltrados;
	}

	public void setOperacao(EnumOperacoesCRUD operacao) {
		this.operacao = operacao;
	}

	public void setListaAreasInteresse(List<SelectItem> listaAreasInteresse) {
		this.listaAreasInteresse = listaAreasInteresse;
	}

	public void setListaPeriodos(List<SelectItem> listaPeriodos) {
		this.listaPeriodos = listaPeriodos;
	}

	public void setListaDeCursos(List<SelectItem> listaDeCursos) {
		this.listaDeCursos = listaDeCursos;
	}

	public void setAreaInteresse(String areaInteresse) {
		this.areaInteresse = areaInteresse;
	}

}

package br.edu.facisa.sigelar.service;

import java.io.Serializable;
import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

import com.google.gson.Gson;

import br.edu.facisa.sigelar.dao.ExemploDomainDAO;
import br.edu.facisa.sigelar.domain.ExemploDomain;

@Path("participante")
public class ExemploService implements Serializable {

	private static final long serialVersionUID = 1403220352301748312L;

	@GET
	public String listar() {
		ExemploDomainDAO participanteDAO = new ExemploDomainDAO();
		List<ExemploDomain> participantes = participanteDAO.listar("nome");

		Gson gson = new Gson();
		String json = gson.toJson(participantes);
		System.out.println("rolou participante");
		return json;
	}

	@GET
	@Path("{id}")
	public String buscar(@PathParam("id") Long id) {
		ExemploDomainDAO participanteDAO = new ExemploDomainDAO();
		ExemploDomain participante = participanteDAO.buscar(id);

		Gson gson = new Gson();
		String json = gson.toJson(participante);

		return json;
	}

	@POST
	public String salvar(String json) {
		Gson gson = new Gson();
		ExemploDomain participante = gson.fromJson(json, ExemploDomain.class);
		ExemploDomainDAO participanteDAO = new ExemploDomainDAO();
		participanteDAO.salvar(participante);
		return json;
	}
	
	@PUT
	public String editar(String json) {
		Gson gson = new Gson();
		ExemploDomain participante = gson.fromJson(json, ExemploDomain.class);
		ExemploDomainDAO participanteDAO = new ExemploDomainDAO();
		participanteDAO.editar(participante);
		return json;
	}
	
	@DELETE
	@Path("{codigo}")
	public String excluir(@PathParam("codigo") Long codigo) {
		Gson gson = new Gson();
		System.out.println("Cheguei");
		ExemploDomainDAO participanteDAO = new ExemploDomainDAO();
		ExemploDomain participante = participanteDAO.buscar(codigo);
		participanteDAO.excluir(participante);
		String json = gson.toJson(participante);
		return json;
	}
}

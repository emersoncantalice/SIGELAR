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

import br.edu.facisa.sigelar.dao.ParticipanteDAO;
import br.edu.facisa.sigelar.domain.Participante;

@Path("participante")
public class ParticipanteService implements Serializable {

	private static final long serialVersionUID = 1403220352301748312L;

	@GET
	public String listar() {
		ParticipanteDAO participanteDAO = new ParticipanteDAO();
		List<Participante> participantes = participanteDAO.listar("nome");

		Gson gson = new Gson();
		String json = gson.toJson(participantes);
		System.out.println("rolou participante");
		return json;
	}

	@GET
	@Path("{id}")
	public String buscar(@PathParam("id") Long id) {
		ParticipanteDAO participanteDAO = new ParticipanteDAO();
		Participante participante = participanteDAO.buscar(id);

		Gson gson = new Gson();
		String json = gson.toJson(participante);

		return json;
	}

	@POST
	public String salvar(String json) {
		Gson gson = new Gson();
		Participante participante = gson.fromJson(json, Participante.class);
		ParticipanteDAO participanteDAO = new ParticipanteDAO();
		participanteDAO.salvar(participante);
		return json;
	}
	
	@PUT
	public String editar(String json) {
		Gson gson = new Gson();
		Participante participante = gson.fromJson(json, Participante.class);
		ParticipanteDAO participanteDAO = new ParticipanteDAO();
		participanteDAO.editar(participante);
		return json;
	}
	
	@DELETE
	@Path("{codigo}")
	public String excluir(@PathParam("codigo") Long codigo) {
		Gson gson = new Gson();
		System.out.println("Cheguei");
		ParticipanteDAO participanteDAO = new ParticipanteDAO();
		Participante participante = participanteDAO.buscar(codigo);
		participanteDAO.excluir(participante);
		String json = gson.toJson(participante);
		return json;
	}
}

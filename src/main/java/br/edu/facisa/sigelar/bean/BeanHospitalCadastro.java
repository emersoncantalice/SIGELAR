package br.edu.facisa.sigelar.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.omnifaces.util.Faces;
import org.omnifaces.util.Messages;

import br.edu.facisa.sigelar.dao.HospitalDAO;
import br.edu.facisa.sigelar.domain.Hospital;

@ManagedBean
@ViewScoped
public class BeanHospitalCadastro implements Serializable {

	private static final long serialVersionUID = 4952476482356094470L;
	private Hospital hospital;
	private static Map<String, String> cidadesGeral;
	private static Map<String, String> bairrosGeral;
	private List<String> estados;
	private List<String> cidades;
	private List<String> bairros;
	private String estado;
	private String cidade;
	private String bairro;

	static {
		cidadesGeral = new LinkedHashMap<String, String>();
		cidadesGeral.put("Campina Grande", "Paraíba");
		cidadesGeral.put("João Pessoa", "Paraíba");
		cidadesGeral.put("Recife", "Pernambuco");

		bairrosGeral = new LinkedHashMap<String, String>();
		bairrosGeral.put("Cruzeiro", "Campina Grande");
		bairrosGeral.put("Catolé", "Campina Grande");
		bairrosGeral.put("Bancarios", "João Pessoa");
		bairrosGeral.put("Bessa", "João Pessoa");
		bairrosGeral.put("São José", "Recife");
		bairrosGeral.put("Afogados", "Recife");

	}

	@PostConstruct
	public void init() {
		hospital = VerificadorDeCadastroDeSistema.hospital;
		if (hospital == null) {
			hospital = new Hospital();
		} else {
			estado = hospital.getEstado();
			cidade = hospital.getCidade();
			bairro = hospital.getBairro();
			popularEstados();
			popularCidades();
			popularBairros();
		}
		popularEstados();

	}

	public void salvar() {

		try {
			HospitalDAO hos = new HospitalDAO();
			hospital.setEstado(estado);
			hospital.setCidade(cidade);
			hospital.setBairro(bairro);
			hos.merge(hospital);
			Messages.addGlobalInfo(hospital.getNome() + " cadastrado(a) com sucesso!, Faça login novamente!");
			Faces.redirect("/SIGELAR/j_spring_security_logout");
		} catch (Exception e) {
			Messages.addGlobalError("Erro ao cadastrar o hospital");
		}
	}

	@SuppressWarnings("rawtypes")
	public void popularBairros() {
		bairros = new ArrayList<>();

		Iterator it = bairrosGeral.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry pairs = (Map.Entry) it.next();
			if (pairs.getValue().equals(this.cidade)) {
				bairros.add(pairs.getKey().toString());
			}
		}
	}

	public void popularEstados() {
		estados = new ArrayList<>();
		estados.add("Paraíba");
		estados.add("Pernambuco");
	}

	@SuppressWarnings("rawtypes")
	public void popularCidades() {
		cidades = new ArrayList<>();

		Iterator it = cidadesGeral.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry pairs = (Map.Entry) it.next();
			if (pairs.getValue().equals(this.estado)) {
				cidades.add(pairs.getKey().toString());
			}
		}
	}

	public Hospital getHospital() {
		return hospital;
	}

	public List<String> getEstados() {
		return estados;
	}

	public List<String> getCidades() {
		return cidades;
	}

	public List<String> getBairros() {
		return bairros;
	}

	public void setHospital(Hospital hospital) {
		this.hospital = hospital;
	}

	public void setEstados(List<String> estados) {
		this.estados = estados;
	}

	public void setCidades(List<String> cidades) {
		this.cidades = cidades;
	}

	public void setBairros(List<String> bairros) {
		this.bairros = bairros;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getCidade() {
		return cidade;
	}

	public String getBairro() {
		return bairro;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

}

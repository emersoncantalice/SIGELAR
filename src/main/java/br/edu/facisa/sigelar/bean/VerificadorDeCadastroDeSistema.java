package br.edu.facisa.sigelar.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.omnifaces.util.Messages;
import org.primefaces.context.RequestContext;

import br.edu.facisa.sigelar.dao.HospitalDAO;
import br.edu.facisa.sigelar.domain.Hospital;

@ManagedBean
@SessionScoped
public class VerificadorDeCadastroDeSistema implements Serializable {

	private static final long serialVersionUID = -7662886420181717079L;
	private List<Hospital> hospitais;
	public static Hospital hospital;
	private boolean carregaSistema;

	@PostConstruct
	public void carregaInformacoesBasicas() {

		try {
			carregaSistema = true;
			HospitalDAO hospitalDAO = new HospitalDAO();
			hospitais = hospitalDAO.listar();

			if (hospitais == null || hospitais.isEmpty()) {
				carregaSistema = false;
				RequestContext context = RequestContext.getCurrentInstance();
				hospital = null;
				context.execute("PF('naoCadastrado').show()");
				throw new SistemaNaoCadastradoException();
			} else {
				for (Hospital h : hospitais) {
					hospital = h;
					break;
				}
			}

		} catch (SistemaNaoCadastradoException s) {
			Messages.addGlobalError(
					"O sistema ainda não foi cadastrado, contacte o adminitrador\n Algumas funções não funcionaram corretamente");
		}
	}

	public boolean isCarregaSistema() {
		return carregaSistema;
	}

	public void setCarregaSistema(boolean carregaSistema) {
		this.carregaSistema = carregaSistema;
	}

}

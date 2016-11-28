package br.edu.facisa.sigelar.bean;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class BeanBoxNavigation implements Serializable {

	private static final String VAZIO = "";
	private static final BeanBoxNavigation INSTANCE = new BeanBoxNavigation();
	private static final long serialVersionUID = 5096136652371175046L;
	private String id;

	private BeanBoxNavigation() {
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public static BeanBoxNavigation getInstance() {
		return INSTANCE;
	}

	public void clean() {
		this.id = VAZIO;
	}

}

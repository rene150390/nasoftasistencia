package org.rene.sanabria.agsnasoft.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Invitado {
	
	@Id
	@GeneratedValue
	private int id;
	private String idsha;
	private String nombre;
	private String email;
	private String empresa;
	private String tel;
	private String puesto;
	private String asiste;

	public Invitado(){}
	
	public Invitado(String nombre, String empresa, String puesto, String email, String tel, String idsha, String asiste){
		setNombre(nombre);
		setEmpresa(empresa);
		setPuesto(puesto);
		setEmail(email);
		setTel(tel);
		setIdsha(idsha);
		setAsiste(asiste);
	}
	
	

	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	public String getEmpresa() {
		return empresa;
	}

	public void setEmpresa(String empresa) {
		this.empresa = empresa;
	}


	public String getIdsha() {
		return idsha;
	}


	public void setIdsha(String idsha) {
		this.idsha = idsha;
	}


	public String getTel() {
		return tel;
	}


	public void setTel(String tel) {
		this.tel = tel;
	}


	public String getPuesto() {
		return puesto;
	}


	public void setPuesto(String puesto) {
		this.puesto = puesto;
	}


	public String getAsiste() {
		return asiste;
	}


	public void setAsiste(String asiste) {
		this.asiste = asiste;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}
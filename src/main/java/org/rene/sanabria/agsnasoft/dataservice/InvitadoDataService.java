package org.rene.sanabria.agsnasoft.dataservice;

import java.util.List;

import org.rene.sanabria.agsnasoft.model.Invitado;



public interface InvitadoDataService {
	public void addInvitado(Invitado inv);
	public List<Invitado> getInvitados(String parametro);
	public List<Invitado> getInvitadoByNombre(String nombre);
	public void updateInvitado(Invitado inv);
}

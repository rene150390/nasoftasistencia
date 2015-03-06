package org.rene.sanabria.agsnasoft.dataservice;


import java.util.List;

import org.rene.sanabria.agsnasoft.dao.InvitadoDAO;
import org.rene.sanabria.agsnasoft.model.Invitado;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class InvitadoDataServiceImp implements InvitadoDataService{
	
	@Autowired
    private InvitadoDAO invitadoDAO;
	
	@Transactional
	public void addInvitado(Invitado inv) {
		invitadoDAO.addInvitado(inv);
	}
	@Transactional
	public List<Invitado> getInvitados(String parametro){
		return invitadoDAO.getInvitados(parametro);
	}
	@Transactional
	public List<Invitado> getInvitadoByNombre(String nombre){
		return invitadoDAO.getInvitadoByNombre(nombre);
	}
	@Transactional
	public void updateInvitado(Invitado inv) {
		invitadoDAO.updateInvitado(inv);
	}
	@Transactional
	public List<Invitado> getInvitadoByMail(String email){
		return invitadoDAO.getInvitadoByMail(email);
	}
	@Transactional
	public void updateInvitadoByEmail(Invitado inv){
		invitadoDAO.updateInvitado(inv);
	}
	

}

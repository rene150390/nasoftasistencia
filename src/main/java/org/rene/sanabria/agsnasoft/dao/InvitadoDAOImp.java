package org.rene.sanabria.agsnasoft.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.rene.sanabria.agsnasoft.model.Invitado;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class InvitadoDAOImp implements InvitadoDAO{
	
	@Autowired
	private SessionFactory sessionFactory;

	public void addInvitado(Invitado inv) {
		this.sessionFactory.getCurrentSession().save(inv);
	}
	@SuppressWarnings("unchecked")
	public List<Invitado> getInvitados(String parametro){
		 return this.sessionFactory.getCurrentSession().createQuery("from Invitado I where I.nombre like '%"+parametro+"%'").list();
	 }
	@SuppressWarnings("unchecked")
	public List<Invitado> getInvitadoByNombre(String nombre){
		return this.sessionFactory.getCurrentSession().createQuery("from Invitado I where I.nombre='"+nombre+"'").list();
	}
	public void updateInvitado(Invitado inv){
		this.sessionFactory.getCurrentSession().createQuery("update Invitado set"
    			+ " empresa = '"+inv.getEmpresa()+"', puesto = '"+inv.getPuesto()+"', email ='"+inv.getEmail()+"', "
    					+ " tel='"+inv.getTel()+"' where email='"
    			+inv.getEmail()+"'" ).executeUpdate();
	}

}

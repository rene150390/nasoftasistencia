package org.rene.sanabria.agsnasoft.controller;


import java.util.ArrayList;
import java.util.List;

import org.rene.sanabria.agsnasoft.dataservice.InvitadoDataService;
import org.rene.sanabria.agsnasoft.model.Invitado;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping
public class MainController {
	@Autowired InvitadoDataService invitadoService;

	/*@RequestMapping(value="/register", method=RequestMethod.POST)
	public String registerWeb(@RequestParam("nombre") String nombre, @RequestParam("empresa") String empresa,
			@RequestParam("puesto") String puesto,
			@RequestParam("email") String email,
			@RequestParam("tel") String tel,
			@RequestParam("idsha") String idsha) {
		
		String id1 = idsha.equals(null) || idsha.equals("null") ? "" : idsha;
		Invitado inv = new Invitado(nombre, empresa, puesto, email, tel, id1, "si");
		invitadoService.addInvitado(inv);
		return "registroOk";
	}*/
	@RequestMapping(value="/registerws", method=RequestMethod.POST)
	public @ResponseBody String registerService(@RequestBody Invitado inv) {
		List<Invitado> listaExists = invitadoService.getInvitadoByNombre(inv.getNombre());
		
		if(listaExists.isEmpty())
			invitadoService.addInvitado(inv);
		invitadoService.updateInvitado(inv);
		return "registroOk";
	}
	@RequestMapping(value="/getinvitados", method=RequestMethod.GET)
	public @ResponseBody List<String> getService(@RequestParam("parametro") String parametro) {
		List<Invitado> lista = invitadoService.getInvitados(parametro);
		List<String> listaNombres = new ArrayList<String>();
		for(Invitado inv : lista)
			listaNombres.add(inv.getNombre());
		return listaNombres;
	}
	@RequestMapping(value="/getinvitadosattrib", method=RequestMethod.GET)
	public @ResponseBody List<Invitado> getInvitadoService(@RequestParam("nombre") String nombre) {
		List<Invitado> lista = invitadoService.getInvitadoByNombre(nombre);
		
		return lista;
	}
	
}

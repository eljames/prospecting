package br.prospecting.controller.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.prospecting.bal.Origin;
import br.prospecting.repository.DBException;
import br.prospecting.service.OriginService;

@RestController
@RequestMapping("/origins")
public class OriginAPI {
	
	@Autowired
	private OriginService originService;
	
	@RequestMapping(method = RequestMethod.GET)
	public void getList() throws DBException {
		List<Origin> list = originService.listOrigins();
		
		for(Origin origin : list) {
			System.out.println(origin.getId() + " | " + origin.getName());
		}
	}
}

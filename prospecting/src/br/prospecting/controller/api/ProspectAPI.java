package br.prospecting.controller.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.prospecting.bal.Prospect;
import br.prospecting.repository.DBException;
import br.prospecting.repository.ProspectSearchFields;
import br.prospecting.service.ProspectService;

@RestController
@RequestMapping("/prospects")
public class ProspectAPI {
	
	@Autowired
	private ProspectService prospectService;
	
	
	/**
	 * /prospects POST
	 * 
	 * @param prospect
	 * @throws DBException
	 */
	@RequestMapping(method=RequestMethod.POST, consumes=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public void save(@RequestBody Prospect prospect) throws DBException {
		prospectService.saveProspect(prospect);
	}
	
	/**
	 *  /prospects GET
	 * 
	 * @param psf
	 * @return
	 * @throws DBException
	 */
	@RequestMapping(method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<Prospect> list(ProspectSearchFields psf) throws DBException {
		return prospectService.list(psf);
	}
	
	/**
	 *  /prospects/{id} GET
	 * 
	 * @param id
	 * @return
	 * @throws DBException
	 */
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public Prospect get(@PathVariable("id") long id) throws DBException {
		return prospectService.getProspect(id);
	}
	
	/**
	 *  /prospects/{id} PUT
	 * 
	 * @param prospect
	 * @throws DBException
	 */
	@RequestMapping(value="/{id}", method=RequestMethod.PUT)
	public void update(@PathVariable("id") long id, @RequestBody Prospect prospect) throws DBException {
		prospect.setId(id);
		prospectService.updateProspect(prospect);
	}
	
	/**
	 *  /prospects/{id} DELETE
	 * 
	 * @param id
	 * @throws DBException
	 */
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	public void remove(@PathVariable("id") long id) throws DBException {
		prospectService.removeProspect(id);
	}
}
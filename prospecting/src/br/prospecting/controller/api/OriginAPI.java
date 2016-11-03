package br.prospecting.controller.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
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
	
	/**
	 * POST /origins
	 * 
	 * @param origin
	 * @throws DBException
	 */
	@RequestMapping(method = RequestMethod.POST, consumes=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public void save(@RequestBody Origin origin) throws DBException {
		originService.saveOrigin(origin);
	}
	
	/**
	 *  GET /origins
	 * 
	 * @return origin list
	 * @throws DBException
	 */
	@RequestMapping(method = RequestMethod.GET, produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<Origin> listOrigins() throws DBException {
		return originService.listOrigins();
	}
	
	/**
	 *  PUT /origins/{id}
	 * 
	 * @param id
	 * @param origin
	 * @throws DBException
	 */
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public void update(@PathVariable("id") long id, @RequestBody Origin origin) throws DBException {
		origin.setId(id);
		originService.updateOrigin(origin);
	}
	
	/**
	 *  DELETE /origins/{id}
	 * 
	 * @param id
	 * @throws DBException
	 */
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public void remove(@PathVariable("id") long id) throws DBException {
		
		originService.removeOrigin(id);
	}
}

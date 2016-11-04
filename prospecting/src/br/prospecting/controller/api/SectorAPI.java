package br.prospecting.controller.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.prospecting.bal.Sector;
import br.prospecting.repository.DBException;
import br.prospecting.service.SectorService;

@RestController
@RequestMapping("/sectors")
public class SectorAPI {

	@Autowired
	SectorService sectorService;
	
	@RequestMapping(method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Sector> list() throws DBException {
		return sectorService.list();
	}
	
	@RequestMapping(method=RequestMethod.POST, consumes=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public void save(@RequestBody Sector sector) throws DBException {
		sectorService.saveSector(sector);
	}
	
	
	@RequestMapping(value="/{id}",method=RequestMethod.PUT, consumes=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public void update(@PathVariable("id") long id, @RequestBody Sector sector) throws DBException {
		sector.setId(id);
		sectorService.updateSector(sector);
	}
	
	@RequestMapping(value="/{id}",method=RequestMethod.DELETE)
	public void remove(@PathVariable("id") long id) throws DBException {
		sectorService.removeSector(id);
	}
}

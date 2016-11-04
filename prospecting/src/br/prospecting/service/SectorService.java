package br.prospecting.service;

import java.util.List;

import br.prospecting.bal.Sector;
import br.prospecting.repository.DBException;

public interface SectorService {
	
	public void saveSector(Sector sector) throws DBException;
	public void updateSector(Sector sector) throws DBException;
	public void removeSector(long id) throws DBException;
	public List<Sector> list() throws DBException; 
}

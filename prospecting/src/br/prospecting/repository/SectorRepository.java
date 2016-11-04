package br.prospecting.repository;

import java.util.List;

import br.prospecting.bal.Sector;

public interface SectorRepository extends GenericRepository<Sector> {
	
	public List<Sector> list();
}

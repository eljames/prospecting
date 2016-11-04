package br.prospecting.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.prospecting.bal.Sector;
import br.prospecting.repository.DBException;
import br.prospecting.repository.SectorRepository;

@Service
@Transactional
public class SectorServiceImpl implements SectorService {

	@Autowired
	private SectorRepository sectorRep;
	
	@Override
	public void saveSector(Sector sector) throws DBException {
		sectorRep.save(sector);
	}

	@Override
	public void updateSector(Sector sector) throws DBException {
		sectorRep.update(sector);
	}

	@Override
	public void removeSector(long id) throws DBException {
		sectorRep.remove(id);
	}

	@Override
	public List<Sector> list() throws DBException {
		return sectorRep.list();
	}

}

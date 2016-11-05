package br.prospecting.service;

import java.util.List;

import br.prospecting.bal.Prospect;
import br.prospecting.repository.DBException;
import br.prospecting.repository.ProspectSearchFields;

public interface ProspectService {
	public void saveProspect(Prospect prospect) throws DBException;
	public List<Prospect> list(ProspectSearchFields psf) throws DBException;
	public Prospect getProspect(long id) throws DBException;
	public void updateProspect(Prospect prospect) throws DBException;
	public void removeProspect(long id) throws DBException;
}

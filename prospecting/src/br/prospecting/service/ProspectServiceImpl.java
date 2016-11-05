package br.prospecting.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.prospecting.bal.Prospect;
import br.prospecting.repository.DBException;
import br.prospecting.repository.ProspectRepository;
import br.prospecting.repository.ProspectSearchFields;

@Service
@Transactional
public class ProspectServiceImpl implements ProspectService {

	@Autowired
	private ProspectRepository prospectRep;
	
	@Override
	public void saveProspect(Prospect prospect) throws DBException {
		prospect.setRegistrationDate(LocalDateTime.now());
		prospectRep.save(prospect);
	}

	@Override
	public List<Prospect> list(ProspectSearchFields psf) throws DBException {
		return prospectRep.list(psf);
	}

	@Override
	public Prospect getProspect(long id) throws DBException {
		return prospectRep.get(id);
	}

	@Override
	public void updateProspect(Prospect prospect) throws DBException {
		prospectRep.update(prospect);
	}

	@Override
	public void removeProspect(long id) throws DBException {
		prospectRep.remove(id);
	}

}

package br.prospecting.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.prospecting.bal.Origin;
import br.prospecting.repository.DBException;
import br.prospecting.repository.OriginRepository;

@Service
public class OriginServiceImpl implements OriginService {
	
	@Autowired
	private OriginRepository originRep;

	@Transactional
	@Override
	public void saveOrigin(Origin origin) throws DBException {
		originRep.save(origin);
	}

	@Transactional(readOnly = true)
	@Override
	public Origin getOrigin(long id) throws DBException {
		return originRep.get(id);
	}

	@Transactional(readOnly = true)
	@Override
	public List<Origin> listOrigins() {
		return originRep.list();
	}

	@Transactional
	@Override
	public void updateOrigin(Origin origin) throws DBException {
		originRep.update(origin);
	}

	@Transactional
	@Override
	public void removeOrigin(long id) throws DBException {
		originRep.remove(id);
	}
	
	
}

package br.prospecting.service;

import java.util.List;

import br.prospecting.bal.Origin;
import br.prospecting.repository.DBException;

public interface OriginService {
	
	public void saveOrigin(Origin origin) throws DBException;
	
	public Origin getOrigin(long id) throws DBException;
	
	public List<Origin> listOrigins() throws DBException;
	
	public void updateOrigin(long id) throws DBException;
	
	public void removeOrigin(Origin origin) throws DBException;
}

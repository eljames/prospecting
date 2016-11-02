package br.prospecting.dal;

import java.util.List;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.SqlReturnResultSet;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;

import br.prospecting.bal.Origin;
import br.prospecting.repository.DBException;
import br.prospecting.repository.OriginRepository;

@Repository
public class OriginDAO implements OriginRepository {
	
	private SimpleJdbcCall simpleJdbcCall;

	@Autowired
	public OriginDAO(DataSource dataSource) {
		simpleJdbcCall = new SimpleJdbcCall(dataSource);
	}
	
	@Override
	public void save(Origin origin) throws DBException {
		
		SqlParameterSource sqlParam = new MapSqlParameterSource()
				.addValue("_name", origin.getName());
		
		simpleJdbcCall.withProcedureName("usp_origin_add").execute(sqlParam);
	}

	@Override
	public Origin get(long id) throws DBException {
		
		return null;
	}

	@Override
	public void update(Origin origin) throws DBException {
		SqlParameterSource sqlParam = new MapSqlParameterSource()
				.addValue("_id", origin.getId())
				.addValue("_name", origin.getName());
		
		simpleJdbcCall.withProcedureName("usp_origin_set").execute(sqlParam);
		
	}

	@Override
	public void remove(long id) throws DBException {
		// TODO Auto-generated method stub
		
	}

	
	@Override
	public List<Origin> list() {
		
		simpleJdbcCall
				.withProcedureName("usp_origin_list")
				.withoutProcedureColumnMetaDataAccess()
				.declareParameters(new SqlReturnResultSet("origins", new OriginMapper()));
				
		
		@SuppressWarnings("unchecked")
		List<Origin> originList = (List<Origin>) simpleJdbcCall.execute().get("origins");
		
		return originList;
	}

}

package br.prospecting.dal;

import java.sql.Types;
import java.util.List;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.SqlParameter;
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
		
		MapSqlParameterSource sqlParam = new MapSqlParameterSource()
				.addValue("_id", id);
		
		simpleJdbcCall
				.withProcedureName("usp_origin_get")
				.declareParameters(new SqlReturnResultSet("origin", new OriginMapper()), new SqlParameter("_id", Types.BIGINT))
				.setAccessCallParameterMetaData(false);
		
		@SuppressWarnings("unchecked")
		Origin origin = ((List<Origin>) simpleJdbcCall.execute(sqlParam).get("origin")).get(0);
		return origin;
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
		
		MapSqlParameterSource sqlParam = new MapSqlParameterSource()
				.addValue("_id", id);
		
		simpleJdbcCall.withProcedureName("usp_origin_del").execute(sqlParam);
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

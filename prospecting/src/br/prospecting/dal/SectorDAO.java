package br.prospecting.dal;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SqlReturnResultSet;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;

import br.prospecting.bal.Sector;
import br.prospecting.repository.DBException;
import br.prospecting.repository.SectorRepository;

@Repository
public class SectorDAO implements SectorRepository {

	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public SectorDAO(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	@Override
	public void save(Sector sector) throws DBException {
		
		MapSqlParameterSource sqlParam = new MapSqlParameterSource();
		sqlParam.addValue("_name", sector.getName());
		
		SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate);
		simpleJdbcCall
			.withProcedureName("usp_sector_add")
			.execute(sqlParam);
	}

	@Override
	public Sector get(long id) throws DBException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(Sector sector) throws DBException {
		
		MapSqlParameterSource sqlParam = new MapSqlParameterSource()
				.addValue("_id", sector.getId())
				.addValue("_name", sector.getName());

		SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate);
		simpleJdbcCall
			.withProcedureName("usp_sector_set")
			.execute(sqlParam);
	}

	@Override
	public void remove(long id) throws DBException {
		SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate);
		simpleJdbcCall
			.withProcedureName("usp_sector_del")
			.execute(new MapSqlParameterSource("_id", id));
	}

	@Override
	public List<Sector> list() {
		SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate);
		simpleJdbcCall
			.withoutProcedureColumnMetaDataAccess()
			.withProcedureName("usp_sector_list")
			.declareParameters(new SqlReturnResultSet("sectors", new SectorMapper()));
		
		@SuppressWarnings("unchecked")
		List<Sector> listSector = (List<Sector>) simpleJdbcCall.execute().get("sectors");
		
		return listSector;
	}

}

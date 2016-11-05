package br.prospecting.dal;

import java.sql.Timestamp;
import java.sql.Types;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.SqlReturnResultSet;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;

import br.prospecting.bal.Prospect;
import br.prospecting.repository.DBException;
import br.prospecting.repository.ProspectRepository;
import br.prospecting.repository.ProspectSearchFields;

@Repository
public class ProspectDAO implements ProspectRepository {

	private JdbcTemplate jdbcTemplate;
	
	public ProspectDAO(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	@Override
	public void save(Prospect prospect) throws DBException {
		
		MapSqlParameterSource sqlParam = getSaveParams(prospect);
		SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate);
		simpleJdbcCall
			.withProcedureName("usp_prospect_add")
			.execute(sqlParam);
	}

	
	@Override
	public Prospect get(long id) throws DBException {
		
		SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate);
		
		simpleJdbcCall
			.withProcedureName("usp_prospect_get")
			.withoutProcedureColumnMetaDataAccess()
			.declareParameters(new SqlReturnResultSet("prospect", new ProspectMapper()), new SqlParameter("_id", Types.BIGINT));
		
		@SuppressWarnings("unchecked")
		Prospect prospect = ((List<Prospect>)simpleJdbcCall.execute(new MapSqlParameterSource("_id", id)).get("prospect")).get(0);
		
		return prospect;
	}

	@Override
	public void update(Prospect prospect) throws DBException {
		
		MapSqlParameterSource sqlParam = getUpdateParams(prospect);
		SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate);
		simpleJdbcCall
			.withProcedureName("usp_prospect_set")
			.execute(sqlParam);
		
	}

	@Override
	public void remove(long id) throws DBException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Prospect> list(ProspectSearchFields prospectSearchFields) throws DBException {
		// TODO Auto-generated method stub
		return null;
	}
	
	private MapSqlParameterSource getSaveParams(Prospect prospect) {
		return new MapSqlParameterSource()
				.addValue("_name", prospect.getName())
				.addValue("_address", prospect.getAddress())
				.addValue("_phone_number", prospect.getPhoneNumber())
				.addValue("_registration_date", Timestamp.valueOf(prospect.getRegistrationDate()))
				.addValue("_status", prospect.getStatus())
				.addValue("_sector_id", prospect.getSector().getId())
				.addValue("_origin_id", prospect.getOrigin().getId());
	}
	
	private MapSqlParameterSource getUpdateParams(Prospect prospect) {
		return new MapSqlParameterSource()
				.addValue("_id", prospect.getId())
				.addValue("_name", prospect.getName())
				.addValue("_address", prospect.getAddress())
				.addValue("_phone_number", prospect.getPhoneNumber())
				.addValue("_registration_date", Timestamp.valueOf(prospect.getRegistrationDate()))
				.addValue("_status", prospect.getStatus())
				.addValue("_sector_id", prospect.getSector().getId())
				.addValue("_origin_id", prospect.getOrigin().getId());
	}

}

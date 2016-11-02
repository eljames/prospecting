package br.prospecting.dal;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import br.prospecting.bal.Origin;

public class OriginMapper implements RowMapper<Origin> {
	
	@Override
	public Origin mapRow(ResultSet rs, int rowNum) throws SQLException {
		Origin origin = new Origin();
		origin.setId(rs.getLong("id"));
		origin.setName(rs.getString("name"));
		return origin;
	}

}

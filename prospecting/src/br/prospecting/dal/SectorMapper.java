package br.prospecting.dal;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import br.prospecting.bal.Sector;

public class SectorMapper implements RowMapper<Sector> {

	@Override
	public Sector mapRow(ResultSet rs, int rowNum) throws SQLException {
		Sector sector = new Sector();
		
		sector.setId(rs.getLong("id"));
		sector.setName(rs.getString("name"));
		return sector;
	}
	
}

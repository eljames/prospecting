package br.prospecting.dal;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import br.prospecting.bal.Origin;
import br.prospecting.bal.Prospect;
import br.prospecting.bal.Sector;

public class ProspectMapper implements RowMapper<Prospect> {
	
	@Override
	public Prospect mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		Prospect prospect = new Prospect();
		prospect.setId(rs.getLong("id"));
		prospect.setName(rs.getString("name"));
		prospect.setAddress(rs.getString("address"));
		prospect.setRegistrationDate(rs.getTimestamp("registration_date").toLocalDateTime());
		prospect.setPhoneNumber(rs.getString("phone_number"));
		prospect.setStatus(rs.getInt("status"));
		
		/*
		 * Get prospect dependencies
		 * 
		 */
		
		prospect.setSector(getSector(rs));
		prospect.setOrigin(getOrigin(rs));
		
		return prospect;
	}
	
	
	private Sector getSector(ResultSet rs) throws SQLException {
		Sector sector = new Sector();
		sector.setId(rs.getLong("sector_id"));
		sector.setName(rs.getString("sector_name"));
		return sector;
	}
	
	private Origin getOrigin(ResultSet rs) throws SQLException {
		Origin origin = new Origin();
		origin.setId(rs.getLong("origin_id"));
		origin.setName(rs.getString("origin_name"));
		return origin;
	}

}

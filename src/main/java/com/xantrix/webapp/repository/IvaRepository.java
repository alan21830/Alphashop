package com.xantrix.webapp.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.xantrix.webapp.domain.Articoli;
import com.xantrix.webapp.domain.Iva;

 

@Repository
public class IvaRepository  {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public List<Iva> SelIva()
	{
		String sql = "SELECT * FROM IVA";
		
		List lista = jdbcTemplate.query(sql, new RowMapper()
				{

					@Override
					public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
						Iva i = new Iva();
						i.setDescrizione(rs.getString("DESCRIZIONE"));
						i.setAliquota(rs.getInt("ALIQUOTA"));
						return i;
					}
				});
		return lista;
	
	}
	
}
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
import com.xantrix.webapp.domain.FamAssort;



@Repository
public class FamAssRepository {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public List<FamAssort> SelFamAssort()
	{
		String sql="SELECT * FROM FAMASSORT" ;

		List<FamAssort> lista= jdbcTemplate.query(sql,new RowMapper()
		{
			@Override  
			public FamAssort mapRow(ResultSet rs, int rownumber) throws SQLException {
				FamAssort a= new FamAssort();
				try
				{
					a.setDescrizione(rs.getString("DESCRIZIONE"));
					
				}catch (Exception e) {
					 
				}
				return a;
				 

			}
		});
		return lista;
		
        

		
	
}



}
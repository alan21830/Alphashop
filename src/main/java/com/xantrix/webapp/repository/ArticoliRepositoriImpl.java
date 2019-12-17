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

 

@Repository
public class ArticoliRepositoriImpl implements ArticoliRepository{

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public List<Articoli> SelArticoliByFilter(String Filtro) {
		//String sql =" select * from articoli where DESCRIZIONE like '"+Filtro+"%'";

		String sql = "EXEC [dbo].[Sp_SelArticoliSVILUPPO] '"+Filtro+"'";
		

		List <Articoli> list= jdbcTemplate.query(sql,new RowMapper<Articoli>()
		{
			@Override  
			public Articoli mapRow(ResultSet rs, int rownumber) throws SQLException {
				Articoli a= new Articoli();
				try
				{
					a.setCodArt(rs.getString("CODART").trim());
					a.setDescrizione(rs.getString("DESCRIZIONE").trim());
					a.setUm(rs.getString("UM"));
					a.setCodStat(rs.getString("CODSTAT").trim()); 
					a.setPzCart(rs.getInt("PZCART"));
					a.setPesoNetto(rs.getDouble("PESONETTO"));
					a.setIdIva(rs.getInt("IDIVA"));
					a.setIdStatoArt(rs.getString("IDSTATOART").trim());
					a.setIdFamAss(rs.getInt("IDFAMASS"));
					a.setDataCreaz(rs.getDate("DATACREAZIONE"));
					
				}catch (Exception e) {
					 
				}
				return a;
				 

			}
		});
		return list; 
		}
		 

		@Override
		public List<Articoli> SelArticoliByFilter(String Filtro, String OrderBy, String Tipo) {
			 
			return null;
		}

		@Override
		public void InsArticolo(Articoli articolo) {
			 String sql = 
					 "EXEC Sp_InsArticoli '"+
					 articolo.getCodArt()+"','"+
					 articolo.getDescrizione()+"','"+
					 articolo.getUm()+"','"+
					 articolo.getCodStat()+"','"+
					 articolo.getPzCart()+"','"+
					 articolo.getIdIva()+"','"+
					 articolo.getIdStatoArt()+"','"+
					 articolo.getIdFamAss()+"'";
			 
			
		}

		@Override
		public void DelArticolo(String CodArt) {
			 String sql= "DELETE FROM ARTICOLI WHERE CODART ='"+CodArt +"'";

		}

	}

package com.springmvc.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Repository;

import com.springmvc.model.CityInfo;

@Repository
public class CityDAOImpl implements CityDAO {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	

	@Override
	public CityInfo getCityInfo(String cityname) {
		String query = "select * from hib_cityinfo where cityname=?";

		CityInfo cinfo = jdbcTemplate.query(query, new Object[]{cityname},
				new ResultSetExtractor<CityInfo>() {

					@Override
					public CityInfo extractData(ResultSet rs)
							throws SQLException, DataAccessException {
						CityInfo c = new CityInfo();
						if (rs.next()) {
							c.setCityname(rs.getString("cityname"));
							c.setState(rs.getString("state"));
							c.setInformation(rs.getString("information"));
						}
						return c;
					}

				});

		return cinfo;
	}

	

}

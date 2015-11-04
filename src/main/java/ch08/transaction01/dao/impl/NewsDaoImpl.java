package ch08.transaction01.dao.impl;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import ch08.transaction01.dao.NewsDao;

public class NewsDaoImpl implements NewsDao {
	
	private DataSource ds;
	public DataSource getDs() {
		return ds;
	}
	public void setDs(DataSource ds) {
		this.ds = ds;
	}
	@Override
	public void insert(String title, String content) {
		JdbcTemplate jt=new JdbcTemplate(ds);
		jt.update("insert into news_inf values(null,?,?)",title,content);
		System.out.println("insert "+title+" "+content);
		jt.update("insert into news_inf values(null,?,?)",title,content);
		System.out.println("insert "+title+" "+content);
	}

}

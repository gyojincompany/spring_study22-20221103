package com.gyojincompany.study22;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;

public class TicketDao {
	
	JdbcTemplate template;

	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}
	
	public void buyTicket(final TicketDto dto) {
		
		this.template.update(new PreparedStatementCreator() {
			
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				// TODO Auto-generated method stub
				String sql = "insert into card (consumerid,amount) values (?,?)";
				PreparedStatement pstmt = con.prepareStatement(sql);
				pstmt.setString(1, dto.getConsumerid());
				pstmt.setString(2, dto.getAmount());
				
				return pstmt;
			}
		});
		
	}
	
}

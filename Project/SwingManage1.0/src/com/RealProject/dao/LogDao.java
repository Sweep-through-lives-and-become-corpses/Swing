package com.RealProject.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.RealProject.model.LogModel;
import com.RealProject.util.DBConnection;

public class LogDao {
	
	public List<LogModel> getLists(){
		
		List<LogModel> lists = new ArrayList<LogModel>();
		String sql = "select * from c_log";
		try {
			ResultSet rs = DBConnection.query(sql);
			while(rs.next()){
				LogModel lm = new LogModel();
				lm.setLog_id(rs.getInt("log_id"));
				lm.setLogin_user(rs.getString("login_user"));
				lm.setLog_time(rs.getString("log_time"));
				lm.setOperate(rs.getString("log_operate"));
				lists.add(lm);				
			}
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lists;
		
	}

}

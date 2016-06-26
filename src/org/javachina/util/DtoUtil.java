package org.javachina.util;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.javachina.connectionpool.ConnectionPool;

public class DtoUtil {
	public static void main(String[] args) {
		Connection conn = ConnectionPool.getConnection();
		Statement stat = null;
		ResultSet rs = null;
		OutputStream os =null;
		try {
			stat = conn.createStatement();
			String sql = "select table_name from user_tables";
			rs = stat.executeQuery(sql);
			while(rs.next()){
				String tableName = rs.getString(1);
				String dtoName = tableName.substring(0, 1)+tableName.substring(1).toLowerCase()+"Dto";
				System.out.println("文件名"+dtoName);
				//拼文件
				StringBuffer s = new StringBuffer("package org.javachina.createdto.dto;");
				s.append("public class "+dtoName+" {");
				Statement stat2 = conn.createStatement();
				String sql2="select column_name,data_type from user_tab_cols where table_name ='"+tableName+"'";
				ResultSet rs2 = stat2.executeQuery(sql2);
				while(rs2.next()){
					String columName = rs2.getString(1).toLowerCase();
					String dataType = rs2.getString(2);
					if(dataType.equals("VARCHAR2")){
						s.append("private String "+columName+";");
						s.append("public void set"+columName.substring(0, 1).toUpperCase()+columName.substring(1)+"(String s){this."+columName+"=s;}");
						s.append("public String get"+columName.substring(0, 1).toUpperCase()+columName.substring(1)+"(){return this."+columName+";}");
					}else if(dataType.equals("NUMBER")){
						s.append("private int "+columName+";");
						s.append("public void set"+columName.substring(0, 1).toUpperCase()+columName.substring(1)+"(int s){this."+columName+"=s;}");
						s.append("public int get"+columName.substring(0, 1).toUpperCase()+columName.substring(1)+"(){return this."+columName+";}");

					}else if(dataType.equals("DATE")){
						s.append("private java.sql.Date "+columName+";");
						s.append("public void set"+columName.substring(0, 1).toUpperCase()+columName.substring(1)+"(java.sql.Date s){this."+columName+"=s;}");
						s.append("public java.sql.Date get"+columName.substring(0, 1).toUpperCase()+columName.substring(1)+"(){return this."+columName+";}");

					}
				}
				s.append("}");
				os = new FileOutputStream("./src/org/javachina/createdto/dto/"+dtoName+".java");
				os.write(s.toString().getBytes());
				os.flush();
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				if(os!=null){
					
					os.close();
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}

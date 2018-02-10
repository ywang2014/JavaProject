/*
 * ר�Ÿ���������ݿ����Ӳ�������
 * Java����MySQL���������������ص�ַ 
 * 		http://www.mysql.com/downloads/connector/j
 * 
 * �������ݿ�����Ӻ͹ر�
 */

package org.useradmin.dbc;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;

public class DataBaseConnection
{
	private static final String DBDRIVER = "org.gdt.mm.mysql.Driver";
	private static final String DBURL = "jdbc:mysql://localhost:3306/mldn";
	private static final String DBUSER = "root";
	private static final String DBPASS = "root";
	private Connection conn = null;
	
	public DataBaseConnection()
	{
		try
		{
			Class.forName(DBDRIVER);
		}
		catch (ClassNotFoundException e)
		{
			e.printStackTrace();
		}
		try
		{
			conn = DriverManager.getConnection(DBURL, DBUSER, DBPASS);
		} catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public Connection getConnection()
	{
		return this.conn;
	}
	
	public void close()
	{
		if (this.conn != null)
		{
			try
			{
				this.conn.close();
			} catch (SQLException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}

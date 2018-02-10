/*
 * �ӿ�ʵ���ࣺ���ݿ�ľ������
 * 		ֻ�������ݿ������ɾ���ġ������
 * 		���������ݿ�����Ӻ͹ر�(��������ҵ���޹�)
 */

package org.useradmin.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import org.useradmin.dao.IUserDAO;
import org.useradmin.vo.User;


public class IUserDAOImpl implements IUserDAO
{
	private Connection conn = null;
	
	public IUserDAOImpl(Connection conn)
	{
		this.conn = conn;	// ���ⲿʵ�����ӣ�������
	}
	
	public boolean doCreate(User user) throws Exception
	{
		// TODO Auto-generated method stub
		boolean flag = false;
		PreparedStatement pstmt = null;
		String sql = "INSERT INTO user(name, sex, birthday) VALUES (?, ?, ?)";
		try
		{
			pstmt = this.conn.prepareStatement(sql);
			pstmt.setString(1, user.getName());		// ���е����ݴ�user����ȡ��
			pstmt.setString(2, user.getSex());
			pstmt.setDate(3, new java.sql.Date(user.getBirthday().getTime()));
			if (pstmt.executeUpdate() > 0)
			{
				// �����Ѿ�������һ��
				flag = true;
			}
		}
		catch (Exception e)
		{
			throw e;
		}
		finally
		{
			// ��������׳��������ձ���ر����ݿ�
			if (pstmt != null)
			{
				try
				{
					pstmt.close();
				}
				catch (Exception e1)
				{
					
				}
			}
		}
		return flag;
	}

	public boolean doUpdate(User user) throws Exception
	{
		// TODO Auto-generated method stub
		boolean flag = false;
		PreparedStatement pstmt = null;
		String sql = "UPDATE user SET name = ?, sex = ?, birthday = ? WHERE id = ?";
		try
		{
			pstmt = this.conn.prepareStatement(sql);
			pstmt.setString(1, user.getName());		// ���е����ݴ�user����ȡ��
			pstmt.setString(2, user.getSex());
			pstmt.setDate(3, new java.sql.Date(user.getBirthday().getTime()));
			pstmt.setInt(4, user.getId());
			if (pstmt.executeUpdate() > 0)
			{
				// �����Ѿ�������һ��
				flag = true;
			}
		}
		catch (Exception e)
		{
			throw e;
		}
		finally
		{
			// ��������׳��������ձ���ر����ݿ�
			if (pstmt != null)
			{
				try
				{
					pstmt.close();
				}
				catch (Exception e1)
				{
					
				}
			}
		}
		return flag;
	}

	public boolean doDelete(int id) throws Exception
	{
		// TODO Auto-generated method stub
		boolean flag = false;
		PreparedStatement pstmt = null;
		String sql = "DELETE FROM user WHERE id = ?";
		try
		{
			pstmt = this.conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			if (pstmt.executeUpdate() > 0)
			{
				// �����Ѿ�������һ��
				flag = true;
			}
		}
		catch (Exception e)
		{
			throw e;
		}
		finally
		{
			// ��������׳��������ձ���ر����ݿ�
			if (pstmt != null)
			{
				try
				{
					pstmt.close();
				}
				catch (Exception e1)
				{
					
				}
			}
		}
		return flag;
	}

	public User findByID(int id) throws Exception
	{
		// TODO Auto-generated method stub
		User user = null;
		PreparedStatement pstmt = null;
		String sql = "SELECT id,name,sex,birthday FROM user WHERE id=?";
		try
		{
			pstmt = this.conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();	// ִ�в�ѯ����
			while (rs.next())
			{
				user = new User();
				user.setId(rs.getInt(1));
				user.setName(rs.getString(2));
				user.setSex(rs.getString(3));
				user.setBirthday(rs.getDate(4));
			}
			rs.close();
		}
		catch (Exception e)
		{
			throw e;
		}
		finally
		{
			// ��������׳��������ձ���ر����ݿ�
			if (pstmt != null)
			{
				try
				{
					pstmt.close();
				}
				catch (Exception e1)
				{
					
				}
			}
		}
		return user;
	}

	public List<User> findAll(String keyWord) throws Exception
	{
		// TODO Auto-generated method stub
		List<User> all = new ArrayList<User>();
		PreparedStatement pstmt = null;
		String sql = "SELECT id,name,sex,birthday FROM user WHERE name LIKE ? OR sex LIKE ? OR birthday LIKE ?";
		try
		{
			pstmt = this.conn.prepareStatement(sql);
			pstmt.setString(1, "%" + keyWord + "%");
			pstmt.setString(2, "%" + keyWord + "%");
			pstmt.setString(3, "%" + keyWord + "%");
			ResultSet rs = pstmt.executeQuery();	// ִ�в�ѯ����
			while (rs.next())
			{
				User user = new User();
				user.setId(rs.getInt(1));
				user.setName(rs.getString(2));
				user.setSex(rs.getString(3));
				user.setBirthday(rs.getDate(4));
				all.add(user);	// �ѽ�������뵽�б���
			}
			rs.close();
		}
		catch (Exception e)
		{
			throw e;
		}
		finally
		{
			// ��������׳��������ձ���ر����ݿ�
			if (pstmt != null)
			{
				try
				{
					pstmt.close();
				}
				catch (Exception e1)
				{
					
				}
			}
		}
		return all;
	}
}

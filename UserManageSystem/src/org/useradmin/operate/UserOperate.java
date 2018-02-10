package org.useradmin.operate;

import java.util.Iterator;
import java.util.List;
import org.useradmin.factory.DAOFactory;
import org.useradmin.util.InputData;
import org.useradmin.vo.User;

public class UserOperate
{
	public static void insert()
	{
		User user = new User();
		InputData input = new InputData();
		user.setName(input.getString("������������"));
		user.setSex(input.getString("�������Ա�"));
		user.setBirthday(input.getDate("���������գ�", "���ڸ�ʽ�������㣺yyyy-mm-dd��"));
		
		try
		{
			DAOFactory.getIUserDAOInstance().doCreate(user);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}
	
	public static void update()
	{
		InputData input = new InputData();
		int id = input.getInt("������Ҫ���µ��û���ţ�", "��ű�����������");
		User user = null;
		
		try
		{
			user = DAOFactory.getIUserDAOInstance().findByID(id);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		if (user != null)
		{
			user.setName(input.getString("����������(ԭ������" + user.getName() + ")��"));
			user.setSex(input.getString("�������Ա�(ԭ�Ա�" + user.getSex() + ")��"));
			user.setBirthday(input.getDate("����������(ԭ���գ�" +user.getBirthday() +")��", "���ڸ�ʽ�������㣺yyyy-mm-dd��"));
			
			try
			{
				DAOFactory.getIUserDAOInstance().doUpdate(user);
			} catch (Exception e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else
		{
			System.out.println("Ҫ���ҵ��û������ڣ�");
		}
	}

	public static void delete()
	{
		InputData input = new InputData();
		int id = input.getInt("������Ҫɾ�����û���ţ�", "��ű�����������");
		try
		{
			DAOFactory.getIUserDAOInstance().doDelete(id);
		} catch (Exception e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void findId()
	{
		InputData input = new InputData();
		int id = input.getInt("������Ҫ��ѯ�ı�ţ�", "��ű�����������");
		User user = null;
		
		try
		{
			user = DAOFactory.getIUserDAOInstance().findByID(id);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		if (user != null)
		{
			System.out.println(user);
		}
		else
		{
			System.out.println("Ҫ���ҵ��û������ڣ�");
		}
	}

	public static void findAll()
	{
		InputData input = new InputData();
		String keyWord = input.getString("������Ҫ��ѯ�Ĺؼ��֣�");
		List<User> allUser = null;
		try
		{
			allUser = DAOFactory.getIUserDAOInstance().findAll(keyWord);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		Iterator<User> iter = allUser.iterator();
		while (iter.hasNext())
		{
			System.out.println(iter.next());
		}
	}
}

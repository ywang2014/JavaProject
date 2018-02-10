/*
 * ����ʹ�ô�����ʹ�þ��������ʵ����
 */

package org.useradmin.factory;

import org.useradmin.dao.IUserDAO;
import org.useradmin.dao.proxy.IUserDAOProxy;


public class DAOFactory
{
	public static IUserDAO getIUserDAOInstance()
	{
		return new IUserDAOProxy();
	}
}

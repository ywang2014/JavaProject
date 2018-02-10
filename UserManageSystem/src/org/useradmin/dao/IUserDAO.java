/*
 * �����ӿڣ��ƶ��������������׼
 * 
 * �ӿ�����������"I"
 * 		�ӿ�����Ҫ�����Ĵ�����й���
 * 		DAO�����ݿ�������󣬱�ʾ���ǲ������ݵ�
 * 
 * ###############################################################
 * 1.���г�������Ƶ�ʱ�򣬶�Ӧ���Խӿ�Ϊ������׼
 * 2.ÿһ����ֻ���һ������Ĺ��ܣ�����ж�����ܣ���Ҫ�ֿ������ʵ��
 * 3.�������в˵��Ͳ����඼�����ص㣬�ؼ������ݲ�����ͽӿڵĹ�ϵ
 
 * 4.������ƺʹ���������ڿ�����ʹ���������˼·���ص����գ�������
 
 * 5.���ϲ����ڿ����д������ʹ�õ�������
 * 
 * ��ѧϰ˼�룬�ٴ��º͸ĸ�
 */

package org.useradmin.dao;

import java.util.List;
import org.useradmin.vo.User;

public interface IUserDAO
{
	/**
	 * ��ʾ���ݿ����Ӳ��������²���
	 * 
	 * @param user
	 * @return
	 * @throws Exception
	 * @author ywang
	 */
	public boolean doCreate(User user) throws Exception;
	
	public boolean doUpdate(User user) throws Exception;
	
	/**
	 * ��ʾ���ݿ��ɾ������
	 * 
	 * @param id(int)
	 * @return
	 * @throws Exception
	 * @author ywang
	 */
	public boolean doDelete(int id) throws Exception;
	
	/**
	 * ��ʾ���ݿ�Ĳ�ѯ����
	 * 
	 * @param id(int)
	 * @return
	 * @throws Exception
	 * @author ywang
	 */
	public User findByID(int id) throws Exception;
	
	/**
	 * ���ݿ�Ĳ�ѯ����������һ�����
	 * 
	 * @param id(int)
	 * @return
	 * @throws Exception
	 * @author ywang
	 */
	public List<User> findAll(String keyWord) throws Exception;
}

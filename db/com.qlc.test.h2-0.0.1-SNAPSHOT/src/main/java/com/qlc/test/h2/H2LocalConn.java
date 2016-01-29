package com.qlc.test.h2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * h2�������Ӳ���
 * @author Linden
 * �������ӷ�ʽĬ�������ֻ������һ���ͻ������ӵ����ݿ⣬����ʱ
 * ���ݿ��ļ��ᱻ���������Բ���ʱWebConsole����̨�в��ܵ�¼�����ݿ�
 */
public class H2LocalConn {
	private static final String h2_url = "jdbc:h2:~/test";
	private static final String h2_user = "sa";
	private static final String h2_password = "123";
	private static final String h2_driver = "org.h2.Driver";
	static{
		try {
			Class.forName(h2_driver);
		} catch (ClassNotFoundException e) {
			System.out.println("����h2����ʧ�ܣ�");
			e.printStackTrace();
		}
	}
	
	public Connection getCon() throws SQLException{
		return DriverManager.getConnection(h2_url,h2_user,h2_password);
	}
	
}

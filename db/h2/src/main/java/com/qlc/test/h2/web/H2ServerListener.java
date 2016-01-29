package com.qlc.test.h2.web;

import java.sql.SQLException;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.h2.tools.Server;

/**
 * ��������h2����ļ�����
 * ������Ŀʱ��h2����ҵ����������ֱ������h2�����ű�Ч����ͬ
 * @author Linden
 *
 */
public class H2ServerListener implements ServletContextListener{

	private Server server;
	
	public void contextDestroyed(ServletContextEvent arg0) {
		if(server!= null){
			server.stop();
			this.server = null;
			System.out.println("***h2����ֹͣ�ɹ�***");
		}
	}

	public void contextInitialized(ServletContextEvent arg0) {
		try {
			System.out.println("***h2���ݿ���������***");
			server = Server.createTcpServer().start();
			System.out.println("***h2���ݿ������ɹ�***");
		} catch (SQLException e) {
			System.out.println("����h2���ݿ�ʧ�ܣ�" + e.getMessage());
			e.printStackTrace();
		}
		
	}
	
		
}

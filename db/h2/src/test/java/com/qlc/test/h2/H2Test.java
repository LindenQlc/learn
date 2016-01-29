package com.qlc.test.h2;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.Test;

/**
 * h2��Ԫ����
 * @author Linden
 *
 */
public class H2Test {
	@Test
	/**
	 * ���Ա������ӣ�ʵ���Ƿ��ʱ������ݿ��ļ������ܿ���WebConsole
	 * @throws SQLException
	 */
	public void testLocalConn() throws SQLException{
		Connection conn = new H2LocalConn().getCon();
		Statement statement = conn.createStatement();
		String sql = "select * from test";
		ResultSet rs = statement.executeQuery(sql);
		while (rs.next()) {
			System.out.println("ID:"+rs.getString(1)+"\tNAME:"+rs.getString(2));
		}
		statement.close();
		conn.close();
	}
	
	@Test
	/**
	 * ����Զ�����ӣ��뿪��h2����
	 * @throws SQLException
	 */
	public void testRemoteConn() throws SQLException{
		Connection conn = new H2RemoteConn().getCon();
		Statement statement = conn.createStatement();
		String sql = "select * from test";
		ResultSet rs = statement.executeQuery(sql);
		while (rs.next()) {
			System.out.println("ID:"+rs.getString(1)+"\tNAME:"+rs.getString(2));
		}
		statement.close();
		conn.close();
	}
	
	@Test
	/**
	 * ����Զ������h2�ڴ�ģʽ���뿪��h2����
	 * @throws SQLException
	 */
	public void testMemoryConn() throws SQLException{
		Connection conn = new H2MemoryConn().getCon();
		Statement statement = conn.createStatement();
		
		String dropIfExistSql = "DROP TABLE IF EXISTS TEST;";
		String createSql = "CREATE TABLE TEST(ID INT PRIMARY KEY,NAME VARCHAR(255));";
		String insertSql1 = "INSERT INTO TEST VALUES(1, 'Hello');";
		String insertSql2 = "INSERT INTO TEST VALUES(2, 'World');";
		statement.addBatch(dropIfExistSql);
		statement.addBatch(createSql);
		statement.addBatch(insertSql1);
		statement.addBatch(insertSql2);
		statement.executeBatch();
		
		String sql = "select * from test";
		ResultSet rs = statement.executeQuery(sql);
		while (rs.next()) {
			System.out.println("ID:"+rs.getString(1)+"\tNAME:"+rs.getString(2));
		}
		statement.close();
		conn.close();
	}
}

package com.qlc.test.h2.web;

import java.util.UUID;

/** 
 * H2�ṩ�ĵ����ݿ⺯�����ޣ�����֧���Զ������ݿ⺯����ʵ��
 * ��H2���ݿ�ע��uuid������CREATE ALIAS uuid [IF NOT EXISTS] FOR "com.qlc.test.h2.web.H2FunctionExt.uuid";
 * �÷���SELECT uuid();
 * ��Ҫע����ǣ���ͷ��������ǹ���(Public)��,�ҷ�����Ϊ��̬(static)�ģ��緽����ʹ����Connection�����轫��ر�
 * @description H2���ݿ���չ����
 * @author Linden
 * @time   2016��1��29�� ����2:45:14
 */
public class H2FunctionExt {
	
	public static String uuid(){
		return UUID.randomUUID().toString();
	}
}

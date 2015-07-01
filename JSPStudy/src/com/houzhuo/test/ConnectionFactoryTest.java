package com.houzhuo.test;

import java.sql.Connection;

import com.houzhuo.util.ConnectionFactory;

public class ConnectionFactoryTest {

	public static void main(String[] args)throws Exception {
		// TODO Auto-generated method stub
		ConnectionFactory cf = ConnectionFactory.getInstance();
		
		Connection conn = cf.makeConnection();
		
		System.out.println(conn.getAutoCommit());
	}

}

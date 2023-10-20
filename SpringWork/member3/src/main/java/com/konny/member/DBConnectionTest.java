package com.konny.member;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnectionTest {
	public static void main(String[] args) throws Exception {
		Class.forName("oracle.jdbc.driver.OracleDriver");
        String url = "jdbc:oracle:thin:@localhost:1521:xe";
        Connection conn = DriverManager.getConnection(url, "scott", "1111");

        System.out.println(conn);
        conn.close();
	}
}

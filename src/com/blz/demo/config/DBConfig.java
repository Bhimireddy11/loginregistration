package com.blz.demo.config;
public class DBConfig {
	private final String DbName = "raji";
	private final String Driver = "com.mysql.cj.jdbc.Driver";
	private final String Connection_Url = "jdbc:mysql://localhost:3306/" + DbName;
	private final String Dbusername = "root";
	private final String DBUSERPASS = "Admin@123";
	private final String TableName = "RegisterForm";
	private final String findUserByEmailAndPass = "select * from " + TableName + " where email=? and password=?";
	private final String insertQuery = "INSERT into RegisterForm values(?,?,?,?,?,?,?,?)";
	public DBConfig() {
	}

	public String getDRIVER() {
		return Driver;
	}

	public String getFindUserByEmailAndPass() {
		return findUserByEmailAndPass;
	}

	public String getCONNECTION_URL() {
		return Connection_Url;
	}

	public String getDbusername() {
		return Dbusername;
	}

	public String getDBUSERPASS() {
		return DBUSERPASS;
	}

	public String getInsertQuery() {
		return insertQuery;
	}

	
	}

	



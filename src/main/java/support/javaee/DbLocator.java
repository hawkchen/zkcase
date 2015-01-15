package support.javaee;

import java.io.*;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.sql.Connection;

import org.zkoss.util.resource.Locator;

public class DbLocator implements Locator {
	Connection con;

	@Override
	public String getDirectory() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public URL getResource(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public InputStream getResourceAsStream(String name) {
		/*
		Class.forName("org.hsqldb.jdbc.JDBCDriver");
		con = DriverManager.getConnection("jdbc:hsqldb:mydatabase","SA","");
		// get a connection from a database
		Statement stmt = con.createStatement();
		String SQL = "SELECT Data FROM LABEL WHERE id=1"; //query property file
		ResultSet rs = stmt.executeQuery(SQL);
		if (rs.next ()){
			//Retrieve data from input stream
			InputStream propertiesInputStream = rs.getUnicodeStream(1);
			return propertiesInputStream;
		}
		*/
//		StringBuffer buffer = new StringBuffer("prop1=val1\nprop2=val2\n");
//		return new ByteArrayInputStream(buffer.toString().getBytes(StandardCharsets.UTF_8));
		return this.getClass().getResourceAsStream(name);
	}

}

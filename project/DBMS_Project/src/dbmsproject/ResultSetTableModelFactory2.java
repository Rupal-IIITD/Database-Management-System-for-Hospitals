package dbmsproject;

import java.sql.*;
import javax.swing.table.*;


public class ResultSetTableModelFactory2 {
    Connection connection;  

  
    public ResultSetTableModelFactory2()
        throws ClassNotFoundException, SQLException
    {
	
	Class driver = Class.forName("org.gjt.mm.mysql.Driver");

	
	connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital", "root", "MyNewPass");
    }

   
    public int getResultSetTableModel2(String query)
        throws SQLException
    {
	
	if (connection == null)
	    throw new IllegalStateException("Connection already closed.");

	
	Statement statement =
	    connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
				       ResultSet.CONCUR_READ_ONLY);

	int r = statement.executeUpdate(query);
	
	return r;
    }

   
    public void close() {
	try { connection.close(); } 
	catch (Exception e) {}     
	connection = null; 
    }

   
    protected void finalize2() { close(); }
}

package test.filterchain;

public class RifleConnectionPool implements ConnectionPool{

	@Override
	public Connection getPooledConnection(long maxWait) {
         Connection con=null;
		
         try {
			con=new RifleConnection();
			con.setName("init");
		} catch (Exception e) {
           //...
		}
		
		return con;
	}

}

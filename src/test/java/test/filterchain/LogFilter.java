package test.filterchain;

public class LogFilter implements Filter {

	@Override
	public Connection getConnection(FilterChain chain, ConnectionPool pool, long maxWait) {
          Connection con=chain.getConnection(pool, maxWait);
          
          if(con!=null) con.setName("log-filter:"+con.getName());
        		  
		
		return con;
	}

}

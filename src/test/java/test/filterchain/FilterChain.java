package test.filterchain;

public interface FilterChain {
	
	Connection getConnection(ConnectionPool pool,long maxWait);

}

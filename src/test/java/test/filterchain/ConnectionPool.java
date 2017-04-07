package test.filterchain;

public interface ConnectionPool {
	
	 Connection getPooledConnection(long maxWait);
}

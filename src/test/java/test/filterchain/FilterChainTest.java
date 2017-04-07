package test.filterchain;

import org.junit.Test;

public class FilterChainTest {
	
	@Test
	public void test(){
		
		FilterChainImpl chain=new FilterChainImpl();
		
		long maxWait=100;
		ConnectionPool pool=new RifleConnectionPool();
		chain.addFilter(new LogFilter());
		chain.addFilter(new StatFilter());
		Connection con = chain.getConnection(pool, maxWait);
		con.execute();
	}

}

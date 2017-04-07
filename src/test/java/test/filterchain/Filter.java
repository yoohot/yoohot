package test.filterchain;

public interface Filter {

	Connection getConnection(FilterChain chain,ConnectionPool pool,long maxWait);
}

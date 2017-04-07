package test.filterchain;

import java.util.ArrayList;
import java.util.List;

public class FilterChainImpl implements FilterChain {

	private List<Filter> filters = new ArrayList<Filter>();
	
	private int pos=-1;

	public void addFilter(List<Filter> filters) {
		this.filters.addAll(filters);
	}

	public void addFilter(Filter filter) {
		this.filters.add(filter);
	}

	@Override
	public Connection getConnection(ConnectionPool pool, long maxWait) {

		Connection con = null;

		if(filters.size() > pos+1) {
			pos++;
			con=filters.get(pos).getConnection(this, pool, maxWait);
			return con;
		}
		if(con==null)
		con = pool.getPooledConnection(maxWait);
		return con;
	}

}

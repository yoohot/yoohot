package cn.yoohot.controller;

public class Address {
	
	private String addr;

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	@Override
	public String toString() {
		sysCls();
		sysHCd();
		return "Address [addr=" + addr + "]";
	}
	
	
	private void sysCls(){
		System.out.println("class-"+getClass());
	}
	
	public void sysHCd(){
		System.out.println("hashCode"+this.hashCode());
	}
	
	

}

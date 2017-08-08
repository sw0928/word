package tst.project.module;

import tst.project.utils.UUIDUtils;

public class UUIDMoudle {
	private UUIDUtils uuidUtils;
	
	public UUIDMoudle(){
		uuidUtils=new UUIDUtils(0,0);
	}
	
	private static class Moudle {
		protected final static UUIDMoudle mInstance = new UUIDMoudle();
	}

	public static UUIDMoudle getInstance() {
		return Moudle.mInstance;
	}
	
	
	public long UUID(){
		return uuidUtils.nextId(true,1);
	}
}

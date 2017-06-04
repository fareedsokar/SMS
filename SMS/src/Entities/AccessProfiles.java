package Entities;

public class AccessProfiles {

	private int Access;
	/*Access Profile Guide
	 * 1:VIEWER:Parent,School administrator
	 * 2:USER:Student,Teacher
	 * 3:ADMIN:System administrator
	 * DEFAULT: Viewer
	 * */
	public AccessProfiles(){
		setAccess(1);//DEFAULT CONSTRUCTOR
	}
	public AccessProfiles(int Acc){
		setAccess(Acc);
	}
	public int getAccess() {
		return Access;
	}

	public void setAccess(int access) {
		Access = access;
	}
	
}

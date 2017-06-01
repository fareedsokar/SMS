package Entities;

public class User {

	private int ID;
	private String Name;
	private String Password;
	private String Email;
	private int Status;
	private AccessProfiles Access;

	//ID Getters & Setters
	public int getID(){return this.ID;}
	public void setID(int id){this.ID=id;}
	//Name Getters & Setters
	public String getName(){return this.Name;}
	public void setName(String name){this.Name=name;}
	//Password Getters & Setters
	public String getPassword(){return this.Password;}
	public void setPassword(String password){this.Password=password;}
	//Email Getters & Setters
	public String getEmail(){return this.Email;}
	public void setEmail(String email){this.Email=email;}
	//Status Getters & Setters
	public int getStatus(){return this.Status;}
	public void setStatus(int Status){this.Status=Status;}
	//Access Getters & Setters
	public AccessProfiles getAccess() {return Access;}
	public void setAccess(AccessProfiles access) {Access = access;}
}

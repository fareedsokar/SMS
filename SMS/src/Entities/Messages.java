package Entities;

public class Messages {

	private int Message_ID;
	private int User_ID;
	private String Message_Subject;
	private String Message_Context;
	private Date Message_date;
	private boolean Status;//read or unread!
	public int getMessage_ID() {
		return Message_ID;
	}
	public void setMessage_ID(int message_ID) {
		Message_ID = message_ID;
	}
	public String getMessage_Subject() {
		return Message_Subject;
	}
	public void setMessage_Subject(String message_Subject) {
		Message_Subject = message_Subject;
	}
	public int getUser_ID() {
		return User_ID;
	}
	public void setUser_ID(int user_ID) {
		User_ID = user_ID;
	}
	public String getMessage_Context() {
		return Message_Context;
	}
	public void setMessage_Context(String message_Context) {
		Message_Context = message_Context;
	}
	public Date getMessage_date() {
		return Message_date;
	}
	public void setMessage_date(Date message_date) {
		Message_date = message_date;
	}
	public boolean isStatus() {
		return Status;
	}
	public void setStatus(boolean status) {
		Status = status;
	}
	
}

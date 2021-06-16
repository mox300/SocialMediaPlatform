import java.io.Serializable;

public class Message implements Serializable{
	private java.util.Date time;
	private String to, from;
	private String text;
	
	public Message (String from, String to, String text) {
		time = new java.util.Date();
		this.from = from;
		this.to = to;
		this.text = text;
	}

	public String ShowTime() {
		return time.toString();
	}

	public java.util.Date getTime() {
		return time;
	}
	public String getFrom() {
		return from;
	}

	public String getTo() {
		return to;
	}

	public String getText() {
		return text;
	}
}
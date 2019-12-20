package LocalNoticeBoard;

import java.util.Date;

public class Notice {
	private int noticeId;
	private String title;
	private String text;
	private User postedBy;
	//private Date date = new Date(System.currentTimeMillis());
	private Date timeStamp;
	
	private int counter = 1000; //use for id
	
	public Notice(String title, String text, User user) {
		this.noticeId = counter;
		counter++;
		this.text = text;
		this.title = title;
		this.postedBy = user;
		this.timeStamp = new Date(System.currentTimeMillis());
	}
	
	public User getPostedBy() {
		return postedBy;
	}

	public void setPostedBy(User postedBy) {
		this.postedBy = postedBy;
	}

	public int getNoticeId() {
		return noticeId;
	}
	public void setNoticeId(int noticeId) {
		this.noticeId = noticeId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}

	public Date getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(Date timeStamp) {
		this.timeStamp = timeStamp;
	}
}

package LocalNoticeBoard;

import java.util.*;

public class Location {
	private int locationId;
	private String name;
	private NoticeBoard noticeBoard;

	private Set<User> usersSet;
	
	private int counter = 200;

	public Location(String name) {
		this.locationId = counter;
		counter++;
		this.name = name;

		usersSet = new HashSet<User>();
	}

	public int getLocationId() {
		return locationId;
	}

	public void setLocationId(int locationId) {
		this.locationId = locationId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean userPresentInLocation(User user) {
		return usersSet.contains(user);
	}

	public void addUserToLocation(User user) {
		usersSet.add(user);
		System.out.println("User: " + user.getName() + " has been addded to " + this.getName());
	}

	public NoticeBoard getNoticeBoard() {
		return noticeBoard;
	}

	public void setNoticeBoard(NoticeBoard noticeBoard) {
		this.noticeBoard = noticeBoard;
	}
}

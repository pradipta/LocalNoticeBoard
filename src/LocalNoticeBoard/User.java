package LocalNoticeBoard;

import java.util.*;

public class User {
	private int userId;
	private String name;
	private String phone;

	private Location location;

	private int counter = 5000;

	private List<Notice> listOfNotice;
	
	private Map<Location, Integer> lastSeenNotice;

	public User(String name, Location location) {
		this.userId = counter;
		counter++;
		this.name = name;
		this.location = location;
		this.listOfNotice = new ArrayList<Notice>();
		lastSeenNotice = new HashMap<>();
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	public Notice createNotice(String title, String text) {
		Notice newNotice = new Notice(title, text, this);
		this.listOfNotice.add(newNotice);
		return newNotice;
	}

	public void getAllNotices() {
		if (this.listOfNotice.size() == 0) {
			System.out.println("No notices for this user");
			return;
		}
		System.out.println("\nNotices by " + this.name + " are: ");
		for (Notice notice : this.listOfNotice) {
			System.out.println(notice.getTitle());
		}
	}

	public void getNoticeForLocation(Location location) {
		List<Notice> newNotices = new ArrayList<Notice>();
		if (!this.lastSeenNotice.containsKey(location)) {
			//System.out.println("Here");
			newNotices = location.getNoticeBoard().getListOfNewNotice(-1);
			if (newNotices.size() == 0) {
				System.out.println("All updated");
			}
			
			int numberOfNewNotices = newNotices.size();
			int previousLastSeen = -1;
			int newLastSeen = previousLastSeen+numberOfNewNotices;
			this.lastSeenNotice.put(location,newLastSeen);
			
			for (Notice notice : newNotices) {
				System.out.println(notice.getTitle());
			}
			return;
		}
		
		newNotices = location.getNoticeBoard().getListOfNewNotice(this.lastSeenNotice.get(location));
		if (newNotices.size() == 0) {
			System.out.println("All updated");
			return;
		}
		int numberOfNewNotices = newNotices.size();
		int previousLastSeen = this.lastSeenNotice.get(location);
		int newLastSeen = previousLastSeen+numberOfNewNotices;
		this.lastSeenNotice.put(location,newLastSeen);
		for (Notice notice : newNotices) {
			System.out.println(notice.getTitle());
		}
	}
}

package LocalNoticeBoard;

import java.util.*;

public class NoticeBoard {
	private int boardId;
	private Location location;
	private List<Notice> listOfNotice;

	private int counter = 500;

	public NoticeBoard(Location location) {
		this.boardId = counter;
		counter++;
		this.location = location;

		listOfNotice = new ArrayList<Notice>();
	}

	public int getBoardId() {
		return boardId;
	}

	public void setBoardId(int boardId) {
		this.boardId = boardId;
	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	public void addNoticeToBoard(Notice notice) {
		this.listOfNotice.add(notice);
		System.out.println("Notice with title: "+notice.getTitle()+" has been added to notice board for "+this.getLocation().getName());
	}
	
	public void printNoticeByMostRecent() {
		for (int i = this.listOfNotice.size()-1; i>=0; i--) {
			System.out.println(this.listOfNotice.get(i).getTitle());
		}
	}
	
	public void printNoticeByOldest() {
		for (int i = 0; i<this.listOfNotice.size(); i++) {
			System.out.println(this.listOfNotice.get(i).getTitle());
		}
	}
	

	public List<Notice> getListOfNewNotice(Integer lastSeen) {
		// TODO Auto-generated method stub
		ArrayList<Notice> result = new ArrayList<>();
		
		if (lastSeen+1 == this.listOfNotice.size()) {
			System.out.println("No new feed");
			return result;
		}
		
		for (int i = lastSeen+1; i<this.listOfNotice.size(); i++) {
			result.add(this.listOfNotice.get(i));
		}
		return result;
	}

}

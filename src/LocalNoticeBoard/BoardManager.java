package LocalNoticeBoard;

import java.util.*;
//import java.util.Map.Entry;

public class BoardManager {
	public static void main(String[] args) {
		
		Map<Location, NoticeBoard> locationToBoardMap = new HashMap<>();
		
		Location HSR = new Location("HSR Layout");
		User pradipta = new User("Pradipta", HSR);
		
		Location Seattle = new Location("Seattle");
		User swaranga = new User("Swaranga", Seattle);
		
		NoticeBoard HSRBoard = new NoticeBoard(HSR);
		HSR.setNoticeBoard(HSRBoard);
		NoticeBoard SeattleBoard = new NoticeBoard(Seattle);
		Seattle.setNoticeBoard(SeattleBoard);
		
		locationToBoardMap.put(HSR,HSRBoard);
		locationToBoardMap.put(Seattle, SeattleBoard);
		
		
		HSRBoard.addNoticeToBoard(pradipta.createNotice("Food Fest", "Food Fest at HSR at 7 PM"));
		pradipta.setLocation(Seattle);

		SeattleBoard.addNoticeToBoard(pradipta.createNotice("Iron Maiden Concert", "Come all for Iron Maiden concert at Seattle ground tonight"));
		SeattleBoard.addNoticeToBoard(pradipta.createNotice("AWS Summit", "Come to AWS Summit tonight"));
		
		getNoticeByLocationByMostRecent(Seattle, locationToBoardMap);
		getNoticeByLocationByOldest(Seattle, locationToBoardMap);
		
		pradipta.getAllNotices();
		swaranga.getAllNotices();
		
		System.out.println("At time t = 0");
		
		swaranga.getNoticeForLocation(Seattle);
		swaranga.getNoticeForLocation(Seattle);
		swaranga.setLocation(HSR);
		SeattleBoard.addNoticeToBoard(pradipta.createNotice("Food Fest", "Food Fest at HSR at 7 PM"));
		swaranga.getNoticeForLocation(Seattle);


		
		SeattleBoard.addNoticeToBoard(swaranga.createNotice("Free money", "Come all free money"));
		SeattleBoard.addNoticeToBoard(swaranga.createNotice("free food", "Come"));
		
		System.out.println("At time t =1");
		
		swaranga.getNoticeForLocation(Seattle);
		
		
	}

	private static void getNoticeByLocationByMostRecent(Location location, Map<Location, NoticeBoard> map) {
		// TODO Auto-generated method stub
		System.out.println("\nNotices for "+location.getName()+":");
		map.get(location).printNoticeByMostRecent();
		
	}
	
	private static void getNoticeByLocationByOldest(Location location, Map<Location, NoticeBoard> map) {
		// TODO Auto-generated method stub
		System.out.println("\nNotices for "+location.getName()+":");
		map.get(location).printNoticeByOldest();
		
	}
}

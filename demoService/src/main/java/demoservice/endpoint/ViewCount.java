package demoservice.endpoint;

public class ViewCount {
	private long count;
	private static ViewCount viewCount = new ViewCount();
	
	private ViewCount() {
		
	}
	
	public static ViewCount newInstance() {
		return viewCount;
	}
	
	public static void addCount() {
		viewCount.count++;
	}
	
	public long getCount() {
		return count;
	}
	
	public void setCount(long count) {
		this.count = count;
	}
}

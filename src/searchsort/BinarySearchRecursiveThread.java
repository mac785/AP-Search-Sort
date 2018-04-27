package searchsort;

public class BinarySearchRecursiveThread extends AbstractSearchThread{

	public BinarySearchRecursiveThread(BarArray array, StatsThread stats, ThreadCompletedDelegate del, double searchValue){
		super("Binary Search", array, stats, del, searchValue);
	}
	
	public int executeAlgorithm() throws InterruptedException{
		int len = mainArray.size();
		binarySearch(0,len);
		return AbstractSearchSortThread.STATUS_FINISHED_FAILED;
	}
	public void binarySearch(int start, int end){
		int middle = (end+start)/2;
		if (end-start<=1){
			if(searchTarget.compareTo(mainArray.get(start))==0){
				announceFoundBar(mainArray.get(start),start);
				return;
			}
			else{
				announceMissedBar();
			}
		}
		else{
			if(searchTarget.compareTo(mainArray.get(middle))>=0){
				binarySearch(middle, end);
			}
			else{
				binarySearch(start, middle);
			}
		}
	}
}

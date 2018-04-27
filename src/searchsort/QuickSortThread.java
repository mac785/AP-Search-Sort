package searchsort;

public class QuickSortThread extends AbstractSearchSortThread{
	
	public QuickSortThread(BarArray barArrayToSort, StatsThread stats, ThreadCompletedDelegate del){
		super ("QuickSortThread", barArrayToSort, stats, del);
	}
	
	@Override
	public int executeAlgorithm() throws InterruptedException{
		int numBars = mainArray.size();
		quickSort(0,numBars);
		return STATUS_FINISHED;
	}
	public void quickSort(int start, int end) throws InterruptedException{
		if(end-start<=1){
			return;
		}
		else{
			checkIn();
			int pivot = end-1;
			int wall = start;
			for(int i=start;i<end-1;i++){
				if (mainArray.get(pivot).compareTo(mainArray.get(i))>=0){
					mainArray.swap(wall,i);
					wall++;
				}
			}
			mainArray.swap(wall, pivot);
			quickSort(start,wall);
			quickSort(wall,end);
		}
	}
}

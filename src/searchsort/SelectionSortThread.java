package searchsort;

public class SelectionSortThread extends AbstractSearchSortThread{
	
	public SelectionSortThread(BarArray barArrayToSort, StatsThread stats, ThreadCompletedDelegate del){
		
		super ("SelectionSortThread", barArrayToSort, stats, del);
	}
	
	@Override
	public int executeAlgorithm() throws InterruptedException{
		int numBars = mainArray.size();
		for (int i=0; i<numBars; i++){
			int minimum = i;
			for (int j=i; j<numBars;j++){
				//If the place being checked is lower that the place that is the current minimum
				if(mainArray.get(minimum).compareTo(mainArray.get(j))>0){
					minimum = j;
					checkIn();
				}
			}
			mainArray.swap(i, minimum);
			checkIn();
		}
		checkIn();
		return STATUS_FINISHED;
	}
	
	
	
	
	
//	public int executeAlgorithm() throws InterruptedException{
//		int numBars = mainArray.size();
//		for (int i=0; i<numBars; i++){
//			int currentMinimum = i;
//			int newLoc = 0;
//			for (int j=i; j<numBars;j++){
//				if(mainArray.get(currentMinimum).compareTo(mainArray.get(j))>0){
//					mainArray.swap(currentMinimum, j);
//					checkIn();
//				}
//			}
//			checkIn();
//		}
//		checkIn();
//		return STATUS_FINISHED;
//	}

}

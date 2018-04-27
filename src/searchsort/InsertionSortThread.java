package searchsort;

public class InsertionSortThread extends AbstractSearchSortThread{
	
	public InsertionSortThread(BarArray barArrayToSort, StatsThread stats, ThreadCompletedDelegate del){
		super ("InsertionSortThread", barArrayToSort, stats, del);
	}

	@Override
	public int executeAlgorithm() throws InterruptedException{
		int numBars = mainArray.size();
		boolean isDone = false;
		for (int i=1; i<numBars; i++){
			SortableBar temp = mainArray.get(i);
			isDone = false;
			for (int j=i-1;j>=-1;j--){
				if(!isDone){
					if(temp.compareTo(mainArray.get(j))<0){
						mainArray.set(j+1, mainArray.get(j));
						if(j==0){
							mainArray.set(j, temp);
							isDone = true;
							
						}
					}
					else{
						mainArray.set(j+1, temp);
						isDone = true;
					}
					checkIn();
				}
			}
			checkIn();
		}
		checkIn();
		return STATUS_FINISHED;
	}
}

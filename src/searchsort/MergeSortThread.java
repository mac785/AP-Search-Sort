package searchsort;

public class MergeSortThread extends AbstractSearchSortThread{

	public MergeSortThread(BarArray barArrayToSort, StatsThread stats, ThreadCompletedDelegate del){
        super("MergeSortThread",barArrayToSort, stats,del);
	}
	@Override
	public int executeAlgorithm() throws InterruptedException{
		
		int numBars = mainArray.size();
		mergeSort(0,numBars);
		return STATUS_FINISHED;
	}
	public void mergeSort(int start, int end) throws InterruptedException{
		if(end-start<=1){
			return;
		}
		else{
			int half = (end+start)/2;
			mergeSort(start, half);
			checkIn();
			mergeSort(half,end);
			checkIn();
			BarArray tempL = mainArray.subarray(start, half);
			BarArray tempR = mainArray.subarray(half, end);
			int placeInTempL = 0;
			int placeInTempR = 0;
			for (int i=start;i<end; i++){
				checkIn();
				if(placeInTempL < tempL.size()&&placeInTempR < tempR.size()){
					if (tempL.get(placeInTempL).compareTo(tempR.get(placeInTempR))<=0){
						//tempL is bigger than tempR
						mainArray.set(i, tempL.get(placeInTempL));
						placeInTempL ++;
					}
					else{
						mainArray.set(i, tempR.get(placeInTempR));
						placeInTempR ++;
					}
				}
				else{
					if (placeInTempL >= tempL.size()){
						mainArray.set(i, tempR.get(placeInTempR));
						placeInTempR++;
					}
					else{
						mainArray.set(i, tempL.get(placeInTempL));
						placeInTempL++;
					}
				}
			}	
		}
	}
}

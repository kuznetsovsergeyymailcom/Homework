package ru.skuznetsov;


public class Counter {
    public int add(int start, int finish){

      int counter = 0;
        if(start<finish){

            for(int i=start;i<finish;i++){
                if(i%2==0) counter+=i;
            }

         return counter;
/**
* If start number grater than finish number
*/
        }else if(start>finish){

            for(int i=finish;i<start;i++){
                if(i%2==0) counter+=i;
            }

         return counter;
        }else{
         
	 return 0;
        }

    }
}

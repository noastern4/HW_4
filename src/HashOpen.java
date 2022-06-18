public class HashOpen {
    int size;
    int[] arr;

    public HashOpen(int m){
        this.arr = new int[m];
        this.size = m;
    }

    public int insert(int id, int hashFunc){
        int steps_right = 0;
        int steps_left = 0;
        int chair = id%this.size;
        int reversed = 0;

        if (hashFunc == 2){
            while (id != 0) {
                int digit = id % 10;
                reversed = reversed * 10 + digit;
                id = id / 10;
            }
            chair = reversed%this.size;
            }
        if (arr[chair] == 0){
            arr[chair] = 1;
            return 0;
        }

            while (this.arr[chair-steps_left] != 0){
                steps_left++;
                if (chair-steps_left<0){
                    break;
                    }
                }

            while (this.arr[chair+steps_right] != 0){
                steps_right++;
                if (chair+steps_right>=this.size){
                    break;
                }
            }

            if ((steps_right <= steps_left) && (chair+steps_right<this.size)){
                            this.arr[chair+steps_right] = 1;
                            return steps_right*2-1;
            }

            if ((steps_left < steps_right) && (chair-steps_left>=0)){
                this.arr[chair-steps_left] = 1;
                return steps_left*2;
        }

            if (!(chair+steps_right<this.size)){
                this.arr[chair-steps_left] = 1;
            }

            else {
                this.arr[chair+steps_right] = 1;
            }

            return steps_left+steps_right-1;

        }



    public int getNumberElements(){
        int count = 0;
        for (int i=0; i<this.size; i++){
            if (this.arr[i] != 0) count++;
        }
        return count;
    }

    public int getSize(){
        return this.size;
    }
}

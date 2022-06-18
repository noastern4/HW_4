public class HashClosed {
    LinkedList[] HashTable;
    int m;
    int size;

    public HashClosed(int m){
        this.size = Math.floorDiv(m,3);
       this.HashTable = new LinkedList[size];
       this.m = m;
       for (int i=0; i<size; i++){
           this.HashTable[i] = new LinkedList();
       }
    }

    public void insert(String[] person){
        int id = Integer.valueOf(person[0]);
        int index = id % this.size;
        this.HashTable[index].add(person);

    }

    public int[] getNodeSizes(){
        int[] sizes = new int[this.size];
        for (int i=0; i<this.size; i++){
            sizes[i] = this.HashTable[i].getSize();
        }
        return sizes;
    }

    public int[] search(String[] person){
        int count = 1;
        int[] res = new int[]{0,count};
        int id = Integer.valueOf(person[0]);
        int index = id % this.size;
        if (this.HashTable[index] == null){
            return res;
        }
        else {
            int size = this.HashTable[index].getSize();
            Node node = this.HashTable[index].getHead();
            for (int i=0; i<size; i++){
                if (node.id.equals(person[0])){
                    res[0] = 1;
                    res[1] = count;
                    return res;
                }
                node = node.getNext();
                count++;
            }
            res[1] = count;
            return res;
        }

    }

    public int getSize(){
        return this.size;
    }

}

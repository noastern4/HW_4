import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Concert {

    public static LinkedList getFromFile(String FileName) throws FileNotFoundException {
        LinkedList crowd = new LinkedList();
        String[] person = new String[4];
        File file = new File(FileName);
        Scanner read = new Scanner(file);
        while (read.hasNextLine()) {
            String line = read.nextLine();
            String data = "";
            int index = 0;
            for (int i = 0; i < line.length(); i++) {
                if (line.charAt(i) == ',') {
                    person[index] = data;
                    data = "";
                    index ++;
                }
                else{data = data + line.charAt(i);}

            }
            crowd.add(person);

        }
        read.close();
        return crowd;
    }

    public static HashClosed registerCrowd(String file_path) throws FileNotFoundException {
        LinkedList crowed_linkList = new LinkedList();
        crowed_linkList = getFromFile(file_path);
        int size = crowed_linkList.getSize();
        HashClosed hash_reg = new HashClosed(size);
        Node node = crowed_linkList.getHead();
        for (int i = 0; i < size; i++) {
            hash_reg.insert(node.getData());
            node = node.getNext();

        }
        return hash_reg;

    }


    public static int[] reception(String file_path, HashClosed registered) throws FileNotFoundException {
        LinkedList crowed_linkList = new LinkedList();
        crowed_linkList = getFromFile(file_path); //get data from file
        int size = crowed_linkList.getSize(); //number of people
        int index = 0; //index for the new array
        Node node = crowed_linkList.getHead();
        int[] after_reception = new int[registered.m];
        LinkedList not_register = new LinkedList();
        for (int i = 0; i < size; i++) {
            int[] res = registered.search(node.getData()); //checking if the person is registered
            if (res[0] == 1) {  //if true, insert to the array
                int id = Integer.valueOf(node.id);
                after_reception[index] = id;
                index++;
            } else {
                not_register.add(node.getData());
            }
            node = node.getNext();
        }

        int ticket_type = 4;
        node = not_register.getHead();
        while ((not_register.getSize() != 0) && (registered.m - index > 0)) {
            if (node.value == ticket_type) {   //if true, insert to the array
                int id = Integer.valueOf(node.id);
                after_reception[index] = id;
                index++;
            }
            node = node.getNext();
            if (node == not_register.getTail()) {
                ticket_type--;
                node = not_register.getHead();

            }
        }
        insertionSort(after_reception, after_reception.length);
        return after_reception;

    }


    public static void insertionSort(int arr[], int n) {
        int i, key, j;
        for (i = 1; i < n; i++) {
            key = arr[i];
            j = i - 1;

            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key;
        }
    }

    public static int reception_AverageSteps(String file_path, HashClosed registered) throws FileNotFoundException {
        LinkedList crowed_linkList = new LinkedList();
        int steps_counter = 0;
        crowed_linkList = getFromFile(file_path); //get data from file
        int size = crowed_linkList.getSize(); //number of people
        Node node = crowed_linkList.getHead();
        for (int i = 0; i < size; i++) {
            int[] res = registered.search(node.getData()); //checking if the person is registered
            steps_counter += res[1]; //counting the steps of each person

            node = node.getNext();
        }

        int av_steps = Math.floorDiv(steps_counter, size);
        return av_steps;

    }

    public static int[] seatingArrangement(int[] sortedCrowed, HashClosed registered, int functionNum) {
        int size = sortedCrowed.length;
        int[] res = new int[4];
        HashOpen seat_Arr = new HashOpen(registered.m);
        int steps_counter = 0;
        for (int i = 0; i < size; i++) {
            steps_counter = seat_Arr.insert(sortedCrowed[i], functionNum);
            if (i < Math.floorDiv(size, 2)) {
                res[0] += steps_counter;
            }

            if (i < Math.floorDiv(3 * size, 4)) {
                res[1] += steps_counter;
            }
            double sqrt = Math.sqrt(size);

            if (i < Math.floor(size - sqrt)) {
                res[2] += steps_counter;
            }

            if (i < Math.floor(sqrt)) {
                res[3] += steps_counter;
            }
        }

        return res;
    }
}

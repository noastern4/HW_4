//public class Main {
//    public static void main(String[] args){
////            HashClosed hash = Concert.registerCrowd("input1.txt");
////            int[] arrived = Concert.reception("input2.txt", hash);
////            int avg = Concert.reception_AverageSteps("input2.txt", hash);
////            int[] steps1 = Concert.seatingArrangement(arrived, hash, 1);
////            int[] steps2 = Concert.seatingArrangement(arrived, hash, 2);
//        HashClosed hash_c = new HashClosed(6);
//        String[] person1 = {"111111116","FIRST_NAME_1","LAST_NAME_1","OUTER_RING"};
//        String[] person2 = {"123456683","JERRY","SEINFELD","VIP"};
//        String[] person3 = {"777777779","KURT","COBAIN","INNER_RING"};
//        String[] person4 = {"103456685","KATE","MOSS","GOLDEN_RING"};
//        String[] person5 = {"123456696","HOMER","SIMPSON","OUTER_RING"};
//        String[] person6 = {"123456697","MARGE","SIMPSON","INNER_RING"};
//        String[] person7 = {"123456691","sash","SIMPSON","INNER_RING"};
//
//
//
//        hash_c.insert(person1);
//        hash_c.insert(person2);
//        hash_c.insert(person3);
//        hash_c.insert(person4);
//        hash_c.insert(person5);
//        hash_c.insert(person6);
//
//        int[] sizes = hash_c.getNodeSizes();
//        int[] search = hash_c.search(person7);
//        int size = hash_c.getSize();
//        System.out.println(sizes[1]);
//        System.out.println(search[0]);
//        System.out.println(size);
//
//
//        HashOpen hash_c2 = new HashOpen(6);
//        int x1 = hash_c2.insert(9,1);
//        int x2 =hash_c2.insert(8,1);
//
//        int x4 =hash_c2.insert(10,1);
//        int x6 =hash_c2.insert(15,1);
//        System.out.println(x1);
//        System.out.println(x2);
////       System.out.println(x3);
//        System.out.println(x4);
//        System.out.println(x6);
//
//
//
//
//
//
//
//    }
//}

import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        HashClosed hash = Concert.registerCrowd("C:\\Users\\noast\\IdeaProjects\\HW4\\src\\input1_1.dat");
        int[] arrived = Concert.reception("C:\\Users\\noast\\IdeaProjects\\HW4\\src\\input2_1.dat", hash);
        int avg = Concert.reception_AverageSteps("C:\\Users\\noast\\IdeaProjects\\HW4\\src\\input2_1.dat", hash);
        int[] steps1 = Concert.seatingArrangement(arrived, hash, 1);
        int[] steps2 = Concert.seatingArrangement(arrived, hash, 2);
        for (int i = 0; i< arrived.length;i++){
            System.out.println(arrived[i]);
        }

        System.out.println(avg);
//        System.out.println(arrived);
//        System.out.println(arrived);
    }
}
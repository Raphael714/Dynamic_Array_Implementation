import java.util.*;
class DynamicArray{
    private static final int initialCapacity =16;
    private int arr[];
    private int size;
    private int capacity;

    DynamicArray(){
        size=0;
        arr=new int[initialCapacity];
        capacity=initialCapacity;
    }
    private void expandArray(){
        capacity*=2;
        arr=java.util.Arrays.copyOf(arr,capacity);
    }

    public void add(int val){
        if(size==capacity){
            expandArray();
        }
        arr[size]=val;
        size++;

    }

    public void display(){
        System.out.println("Elements in the List:");
        for(int i=0;i<size;i++){
            System.out.print(arr[i]+" ");
        }
    }

    public void insertAtPos(int pos,int val){
        if(size==capacity){
            expandArray();
        }
        for(int i=size-1;i>=pos;i--){
            arr[i+1]=arr[i];
        }
        arr[pos]=val;
        size++;
    }

    public void deleteAtpos(int pos){
        for(int i=pos+1;i<size;i++) {
            arr[i - 1] = arr[i];
        }
        size--;
            if(capacity>initialCapacity&&capacity>3*size){
                shrinkArray();
            }

    }

    private void shrinkArray(){
        capacity/=2;
        arr=java.util.Arrays.copyOf(arr,capacity);
    }


}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        DynamicArray list = new DynamicArray();
        int val,pos;

while(true) {
    System.out.println("\n -------List Menu------\n");
    System.out.println("1.Insert at End\n");
    System.out.println("2.Display the list\n");
    System.out.println("3.Insert at specified position \n");
    System.out.println("4.Delete from specified position\n");
    System.out.println("5.Exit\n");
    System.out.println("\n------------------------\n");
    System.out.println("Enter your choice:\t");
    int choice = sc.nextInt();
    switch(choice){
        case 1: System.out.println("Enter the data: ");
                val=sc.nextInt();
                list.add(val);
                break;
        case 2: list.display();
                break;
        case 3: System.out.println("Enter the position:");
                pos = sc.nextInt();
                if(pos<0){
                    System.out.print("Invalid Position");
                    break;
                }
                System.out.println("Enter the data: ");
                val=sc.nextInt();
                list.insertAtPos(pos,val);
                break;
        case 4: System.out.println("Enter the position:");
            pos = sc.nextInt();
            if(pos<0){
                System.out.print("Invalid Position");
                break;
            }
            list.deleteAtpos(pos);
            break;
        case 5: System.exit(0);
        default: System.out.print("Invalid choice");




    }



}

}
}
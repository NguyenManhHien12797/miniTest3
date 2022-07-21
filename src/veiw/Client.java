package veiw;

import controller.MaterialManager;
import model.CrispyFlour;
import model.Material;
import model.Meat;

import java.sql.SQLOutput;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.TreeMap;

public class Client {
    private static ArrayList<Material>materials= MaterialManager.materials;
    static {

        CrispyFlour cr1= new CrispyFlour(1,"bột chiên1","2022-07-20",100,10);
        CrispyFlour cr2= new CrispyFlour(2,"bột chiên2","2022-07-21",110,11);
        CrispyFlour cr3= new CrispyFlour(3,"bột chiên3","2022-07-22",120,12);
        CrispyFlour cr4= new CrispyFlour(4,"bột chiên4","2022-07-23",130,13);
        CrispyFlour cr5= new CrispyFlour(5,"bột chiên5","2022-07-24",140,14);
        materials.add(cr1);
        materials.add(cr2);
        materials.add(cr3);
        materials.add(cr4);
        materials.add(cr5);
        Meat pork = new Meat(6,"Lợn nái1","2022-07-15",110,2);
        Meat pork1 = new Meat(7,"Lợn nái2","2022-07-16",120,3);
        Meat pork2= new Meat(8,"Lợn nái3","2022-07-17",130,4);
        Meat pork3 = new Meat(9,"Lợn nái4","2022-07-18",140,5);
        Meat pork4 = new Meat(10,"Lợn nái5","2022-07-19",150,6);
        materials.add(pork);
        materials.add(pork1);
        materials.add(pork2);
        materials.add(pork3);
        materials.add(pork4);

    }
    public static void main(String[] args) {
        TreeMap<String,Integer> arr= new TreeMap<>();
        for(int i= 0; i< 3;i++){
            String id= "id: "+ materials.get(i).getId();
            arr.put(id,i);
        }

        System.out.println(arr);
        MaterialManager materialManager = new MaterialManager();
        Scanner scanner= new Scanner(System.in);
        int choice=-1;
        do {
            displayMenu();
            System.out.print("Nhập lựa chọn: ");
           choice= scanner.nextInt();
            switch (choice){
                case 1:
                    System.out.println(materials);
                    break;
                case 2:
                    System.out.println("Nhập info sản phẩm CrispuDlour: ");
                    materialManager.addMaterial(addCrispyFlour());
                    break;
                case 3:
                    System.out.println("Nhập info sản phẩm Meat: ");
                    materialManager.addMaterial(addMeat());
                    break;
                case 4:
                    materialManager.deleteMaterial(materials);
                    break;
                case 5:
                    System.out.println("Chênh lệch chiết khấu của sản phẩm ngày hôm nay: "+LocalDate.now() +" theo Id là:");
                    System.out.println(materialManager.getDiscountDifferenceToday(materials));
                    break;

                case 6:
                    System.out.println("Get out :v :v :v");
                    break;
                default:
                    System.out.println("Nhập sai rồi");

            }

        }while (choice != 6);

    }
    public static void displayMenu(){
        System.out.printf("%s\n%s\n%s\n%s\n%s\n%s\n%s\n","Menu",
                "1. In các sản phẩm hiện có",
                "2. Thêm sản phẩm CrispyFlour",
                "3. Thêm sản phẩm Meat",
                "4. Xóa sản phẩm theo id",
                "5. In ra chênh lệch chiết khấu sản phẩm",
                "6. Thoát");
    }

    public static CrispyFlour addCrispyFlour(){
        Scanner scanner = new Scanner(System.in);
        int id= MaterialManager.materials.size()+1;
        System.out.print("Enter name: ");
        Scanner inName= new Scanner(System.in);
        String name= inName.nextLine();
        System.out.print("Enter manufacturingDate (yyyy-MM-dd): ");
        Scanner inputmanufacturingDate= new Scanner(System.in);
        String manufacturingDate = inputmanufacturingDate.nextLine();
        System.out.print("Enter cost: ");
        int cost= scanner.nextInt();
        System.out.print("Enter quantity: ");
        int quantity= scanner.nextInt();
        CrispyFlour newCris= new CrispyFlour(id,name,manufacturingDate,cost,quantity);
        return newCris;
    }



    public static Meat addMeat(){

        Scanner scanner = new Scanner(System.in);
        int id= MaterialManager.materials.size()+1;
        System.out.print("Enter name: ");
        Scanner inName= new Scanner(System.in);
        String name= inName.nextLine();
        System.out.print("Enter manufacturingDate (yyyy-MM-dd): ");
        Scanner inputmanufacturingDate= new Scanner(System.in);
        String manufacturingDate = inputmanufacturingDate.nextLine();
        System.out.print("Enter cost: ");
        int cost= scanner.nextInt();
        System.out.print("Enter weight: ");
        double weight= scanner.nextDouble();
        Meat newMeat= new Meat(id,name,manufacturingDate,cost,weight);

        return newMeat;
    }

}

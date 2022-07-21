package controller;

import model.CrispyFlour;
import model.Material;
import model.Meat;
import veiw.Client;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.TreeMap;

public class MaterialManager {

    public static ArrayList<Material>materials= new ArrayList<>();
    public void addMaterial(Material material){
        materials.add(material);
    }
    public void editMaterial(ArrayList<Material> material){
        System.out.print("Nhập id vật liệu cần sửa: ");
        Scanner scanner= new Scanner(System.in);
        int id= scanner.nextInt();
        for(int i=0; i<material.size();i++){
            int materId= material.get(i).getId();
            if(id== materId){
                if(material.get(i) instanceof CrispyFlour){
                    material.set(i, Client.addCrispyFlour());
                    material.get(i).setId(i+1);
                } else {
                    if(material.get(i) instanceof  Meat){
                        material.set(i, Client.addMeat());
                        material.get(i).setId(i+1);
                    }
                }

            }
        }
    }
    public void deleteMaterial(ArrayList<Material> material){
        System.out.print("Nhập id vật liệu cần xóa: ");
        Scanner scanner= new Scanner(System.in);
        int id= scanner.nextInt();
        for(int i=0; i<material.size();i++){
            int materId= material.get(i).getId();
            if(id== materId){
                material.remove(i);
            }
        }
    }
    public TreeMap<String, Double> getDiscountDifferenceToday(ArrayList<Material> material){
        double realMoney;
        double costMoney;
        double discountDifference=0;
        TreeMap<String,Double> listDiscountDifferenceToday= new TreeMap<>();
        for(int i= 0; i<material.size(); i++){
            int materId= material.get(i).getId();
            String id= "id: "+materId;
            if(material.get(i) instanceof CrispyFlour){

                realMoney= ((CrispyFlour) material.get(i)).getRealMoney();
                costMoney= ((CrispyFlour) material.get(i)).getCost();
                discountDifference= costMoney - realMoney;
                listDiscountDifferenceToday.put(id,discountDifference);
            }
            if(material.get(i) instanceof Meat){
                realMoney=((Meat) material.get(i)).getRealMoney();
                costMoney= ((Meat) material.get(i)).getCost();
                discountDifference= costMoney- realMoney;
                listDiscountDifferenceToday.put(id,discountDifference);
            }
        }
        return listDiscountDifferenceToday;
    }
}

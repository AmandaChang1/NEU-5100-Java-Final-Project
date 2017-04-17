package com.neu.jan17.data;

import java.util.*;

public class SortInventory {
    ArrayList<Vehicle> arr;

    public void sortVehiclesByYear(Inventory inventory) {
        arr = new ArrayList<Vehicle>(inventory.getVehicles());
        Collections.sort(arr, (o1, o2) -> (o1.getYear()).compareTo(o2.getYear()));
        inventory.setVehicles(arr);
    }

    public void sortVehiclesByModel(Inventory inventory){
        arr = new ArrayList<Vehicle>(inventory.getVehicles());
        Collections.sort(arr, (o1, o2) -> (o1.getModel()).compareTo(o2.getModel()));
        inventory.setVehicles(arr);
    }

    public void sortVehiclesByCategory(Inventory inventory){
        arr = new ArrayList<Vehicle>(inventory.getVehicles());
        Collections.sort(arr, (o1, o2) -> (o1.getCategory()).compareTo(o2.getCategory()));
        inventory.setVehicles(arr);
    }




//    public static void main(String args[]){
//        Inventory inventory = new Inventory();
//        Vehicle v1 = new Vehicle();
//        v1.setYear(100);
//        v1.setModel("BMW");
//        v1.setCategory(Category.NEW);
//        Vehicle v2 = new Vehicle();
//        v2.setYear(111);
//        v2.setModel("Tokyo");
//        v2.setCategory(Category.CERTIFIED);
//        Vehicle v3 = new Vehicle();
//        v3.setYear(99);
//        v3.setModel("Apple");
//        v3.setCategory(Category.NEW);
//        Collection<Vehicle> coll = new ArrayList<Vehicle>();
//        coll.add(v1);
//        coll.add(v2);
//        coll.add(v3);
//        inventory.setVehicles(coll);
//        SortInventory so = new SortInventory();
//        System.out.println(inventory.getVehicles().toString());
//        so.sortVehiclesByYear(inventory);
//        so.sortVehiclesByModel(inventory);
//        System.out.println(inventory.getVehicles().toString());
//    }

}

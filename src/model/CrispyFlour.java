package model;

import java.time.LocalDate;

public class CrispyFlour extends Material implements Discount {
    public static void main(String[] args) {
        CrispyFlour crispyFlour= new CrispyFlour(1,"bột chiên1","2022-07-20",100,10);
        System.out.println(crispyFlour.getRealMoney());
    }
    private int quantity;

    public CrispyFlour() {
    }

    public CrispyFlour(int id, String name, String manufacturingDate, int cost, int quantity) {
        super(id, name, manufacturingDate, cost);
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "CrispyFlour{" +
                ", id='" + getId() + '\'' +
                ", name='" + getName() + '\'' +
                ", manufacturingDate=" + getManufacturingDate() +
                ", quantity=" + quantity +
                ", cost=" + getCost() +
                '}'+"\n";
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public double getAmount() {
        return quantity*getCost();
    }

    @Override
    public LocalDate getExpiryDate() {

        return  getManufacturingDate().plusYears(1);
    }

    @Override
    public double getRealMoney() {
        LocalDate localDate= LocalDate.now();

        if(getExpiryDate().getMonth().minus(2)== localDate.getMonth()){
           return (getCost()-(getCost()*40)/100);
        }else {
            if(getExpiryDate().getMonth().minus(4)== localDate.getMonth()){
                return (getCost()-(getCost()*20)/100);
            }
        }
        return (getCost()-(getCost()*5)/100);
    }
}

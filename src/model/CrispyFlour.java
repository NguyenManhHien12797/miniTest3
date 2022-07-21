package model;

import java.time.LocalDate;

public class CrispyFlour extends Material implements Discount {

    public static final int EXPIRATION_YEAR = 1;
    public static final double PERCENT_DISCOUNT_1 = 0.4;
    public static final double PERCENT_DISCOUNT_2 = 0.2;
    public static final double PERCENT_DISCOUNT_3 = 0.05;

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

        return  getManufacturingDate().plusYears(EXPIRATION_YEAR);
    }

    @Override
    public double getRealMoney() {
        LocalDate localDate= LocalDate.now();

        if(getExpiryDate().getMonth().minus(2)== localDate.getMonth()){
           return (getCost()-getCost()* PERCENT_DISCOUNT_1);
        }else {
            if(getExpiryDate().getMonth().minus(4)== localDate.getMonth()){
                return (getCost()-getCost()* PERCENT_DISCOUNT_2);
            }
        }
        return (getCost()-getCost()*PERCENT_DISCOUNT_3);

    }
}

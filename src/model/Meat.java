package model;

import java.time.LocalDate;

public class Meat extends Material implements Discount{
    public static final int COUNT_THE_EXPIRATION_DATE = 5;
    private double weight;

    public Meat() {
    }

    public Meat(int id, String name, String manufacturingDate, int cost, double weight) {
        super(id, name, manufacturingDate, cost);
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Meat{" +
                ", id='" + getId()+ '\'' +
                ", name='" + getName() + '\'' +
                ", manufacturingDate=" + getManufacturingDate() +
                ", weight=" + weight +
                ", cost=" + getCost() +
                '}'+"\n";
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    @Override
    public double getAmount() {
        return getCost()*weight;
    }

    @Override
    public LocalDate getExpiryDate() {
        return getManufacturingDate().plusDays(7);
    }

    @Override
    public double getRealMoney() {
        LocalDate localDate= LocalDate.now();

        if(getExpiryDate().getDayOfMonth()- localDate.getDayOfMonth()== COUNT_THE_EXPIRATION_DATE){
            return (getCost()-(getCost()*30)/100);
        }
        return (getCost()-(getCost()*10)/100);
    }
}

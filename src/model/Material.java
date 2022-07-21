package model;

import java.time.LocalDate;

public abstract class Material {
    private int id;
   private String name;
  private LocalDate manufacturingDate;
   private int cost;

    public Material() {
    }

    public Material(int id, String name, String manufacturingDate, int cost) {
        this.id = id;
        this.name = name;
        this.manufacturingDate = LocalDate.parse(manufacturingDate);
        this.cost = cost;
    }

    @Override
    public String toString() {
        return "Material{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", manufacturingDate=" + manufacturingDate +
                ", cost=" + cost +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getManufacturingDate() {
        return manufacturingDate;
    }

    public void setManufacturingDate(LocalDate manufacturingDate) {
        this.manufacturingDate = manufacturingDate;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public abstract double getAmount();

    public abstract LocalDate getExpiryDate();
}

package Car;

import java.util.Objects;

public class CarOwner {
    private int id;
    private String name;
    private String lastname;

    public CarOwner(int id, String name, String lastname) {
        this.id = id;
        this.name = name;
        this.lastname = lastname;
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

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    //because we work with hashSets we need override methods equals() and hashcode()
    //they will be created by inteliJ alt+insert

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        CarOwner carOwner = (CarOwner) object;
        return id == carOwner.id && Objects.equals(name, carOwner.name) && Objects.equals(lastname, carOwner.lastname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, lastname);
    }
}

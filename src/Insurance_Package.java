public class Insurance_Package extends Type_Package{
    private int id_Insurance;
    private String Name_Insurance_Package;
    private int id_Car;

    public Insurance_Package(String package_Type, int id_Insurance, String name_Insurance_Package, int id_Car) {
        super(package_Type);
        this.id_Insurance = id_Insurance;
        Name_Insurance_Package = name_Insurance_Package;
        this.id_Car = id_Car;
    }

    public int getId_Insurance() {
        return id_Insurance;
    }

    public void setId_Insurance(int id_Insurance) {
        this.id_Insurance = id_Insurance;
    }

    public String getName_Insurance_Package() {
        return Name_Insurance_Package;
    }

    public void setName_Insurance_Package(String name_Insurance_Package) {
        Name_Insurance_Package = name_Insurance_Package;
    }

    public int getId_Car() {
        return id_Car;
    }

    public void setId_Car(int id_Car) {
        this.id_Car = id_Car;
    }

    @Override
    public String toString() {
        return "Insurance_Package{" +
                "id_Insurance=" + id_Insurance +
                ", Name_Insurance_Package='" + Name_Insurance_Package + '\'' +
                ", id_Car=" + id_Car +
                ", id_Car=" + id_Car +
                '}';
    }

    public void Insurance_Package(){}
}

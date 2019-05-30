import java.util.Comparator;

public class Car implements Comparator<Car> {
    private int id;
    private int id_Insurance_Package;
    private String NameCar;
    private String NumberPlate;
    private int YearManufacture;
    private String Brand;
    private int HaveInsurance;
    private int Support;

    public Car() {
    }

    public String getStatusSupport(int support){
        if(support == 1){
            return "True";
        }else {
            return "False";
        }
    }

    public String getStatusInsurance(int haveInsurance){
        if(haveInsurance == 1){
            return "True";
        }else {
            return "False";
        }
    }

    public String getCarType(int yearManufacture){
        if(yearManufacture >= 2005){
            return "Modern Car";
        }else if ( yearManufacture <= 2004 && yearManufacture >= 1996){
            return "Medium Car";
        }else {
            return "Old Car";
        }
    }

    public Car(int id, int id_Insurance_Package, String nameCar, String numberPlate, int yearManufacture, String brand, int haveInsurance, int support) {
        this.id = id;
        this.id_Insurance_Package = id_Insurance_Package;
        NameCar = nameCar;
        NumberPlate = numberPlate;
        YearManufacture = yearManufacture;
        Brand = brand;
        HaveInsurance = haveInsurance;
        Support = support;
    }

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", id_Insurance_Package=" + id_Insurance_Package +
                ", NameCar='" + NameCar + '\'' +
                ", NumberPlate='" + NumberPlate + '\'' +
                ", YearManufacture=" + YearManufacture +
                ", Brand='" + Brand + '\'' +
                ", HaveInsurance=" + HaveInsurance +
                ", Support=" + Support +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_Insurance_Package() {
        return id_Insurance_Package;
    }

    public void setId_Insurance_Package(int id_Insurance_Package) {
        this.id_Insurance_Package = id_Insurance_Package;
    }

    public String getNameCar() {
        return NameCar;
    }

    public void setNameCar(String nameCar) {
        NameCar = nameCar;
    }

    public String getNumberPlate() {
        return NumberPlate;
    }

    public void setNumberPlate(String numberPlate) {
        NumberPlate = numberPlate;
    }

    public int getYearManufacture() {
        return YearManufacture;
    }

    public void setYearManufacture(int yearManufacture) {
        YearManufacture = yearManufacture;
    }

    public String getBrand() {
        return Brand;
    }

    public void setBrand(String brand) {
        Brand = brand;
    }

    public int getHaveInsurance() {
        return HaveInsurance;
    }

    public void setHaveInsurance(int haveInsurance) {
        HaveInsurance = haveInsurance;
    }

    public int getSupport() {
        return Support;
    }

    public void setSupport(int support) {
        Support = support;
    }

    @Override
    public int compare(Car o1, Car o2) {
        return o1.getYearManufacture() - o2.getYearManufacture();
    }
}

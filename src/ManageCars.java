import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ManageCars {

    public void SignUpInsurance(String numberCar,String nameInsurance,List<Car> cars,List<Insurance_Package> insurance_packageList){
        int status = 0;
        int invalid = 0;
        int Id_Insurance = 0;
        String typePackage = "";
        boolean Allow = false;
        for (Insurance_Package is:insurance_packageList){
            if (is.getName_Insurance_Package().equals(nameInsurance)){
                if(is.getId_Car()==0){
                    typePackage = is.getPackage_Type();
                    Id_Insurance = is.getId_Insurance();
                    Allow = true;
                }
            }
        }
        if(Allow == true){
            for (Car c:cars){
                if(c.getNumberPlate().equals(numberCar)){
                    if(c.getHaveInsurance() == 0){
                        if(c.getYearManufacture() >= 2005 && typePackage.equals("A")){
                            this.AllowInsurance(c.getId(),Id_Insurance);
                        }else if(c.getYearManufacture() >= 1996 && c.getYearManufacture() <=2004 && typePackage.equals("B")){
                            this.AllowInsurance(c.getId(),Id_Insurance);
                        }else if(c.getYearManufacture() <= 1995 && typePackage.equals("C")){
                            this.AllowInsurance(c.getId(),Id_Insurance);
                        }else {
                            System.out.println("Invalid Package!");
                        }
                    }else {
                        System.out.println("Unavailable Buying!");
                    }
                    status = 1;
                }
            }
        }
        if(status == 0){
            System.out.println("Unsuccessful Buying");
        }
    }

    public void AllowInsurance(int id,int Id_Insurance){
        try {
            dbContext db = new dbContext();
            Connection conn = db.getConnection();
            Statement stmt=conn.createStatement();
            stmt.executeQuery("UPDATE BT_INSURANCE_PACKAGE SET ID_CAR = "+id+" where ID = "+Id_Insurance+"");
            stmt.executeQuery("UPDATE BT_CAR SET HAVEINSURANCE = 1 where ID="+id+"");
            System.out.println("Successful Buying");
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void assignAssurance(String name, List<Car> cars, List<Insurance_Package> Insurance){
        for (Insurance_Package is:Insurance){
            if(is.getName_Insurance_Package().equals(name)){
                System.out.println("-----Thong tin chi tiet loai bao hiem-----");
                System.out.println("-"+
                        is.getPackage_Type()+"-"+
                        is.getName_Insurance_Package()
                );
                System.out.println("----Thong tin cac loai xe dang ki ----");
                this.GetDetailCarInsurance(is.getId_Car(),cars);
            }
        }
    }

    public void GetDetailCarInsurance(int id,List<Car> cars){
        for (Car c:cars) {
            if (c.getId() == id) {
                System.out.println(c.getNameCar() + " " +
                        c.getNumberPlate() + "-" +
                        c.getYearManufacture() + "-" +
                        c.getBrand() + "-" +
                        c.getStatusInsurance(c.getHaveInsurance()) + "-" +
                        c.getCarType(c.getYearManufacture())
                );
            }
        }
    }

    public void showCarInfo(String number,List<Car> cars,List<Insurance_Package> Insurance ){
        for (Car c:cars){
            if(c.getNumberPlate().equals(number)){
                System.out.println(c.getNameCar()+" "+
                        c.getNumberPlate()+"-"+
                        c.getYearManufacture()+"-"+
                        c.getBrand()+"-"+
                        c.getStatusInsurance(c.getHaveInsurance())+"-"+
                        c.getCarType(c.getYearManufacture())
                );
                System.out.println("Goi bao hiem:");
                this.FilterInsurance(c.getId(),Insurance);
            }
        }
    }

    public void FilterInsurance(int id,List<Insurance_Package> Insurance){
        int status = 0;
        for(Insurance_Package is:Insurance){
            if(is.getId_Car() == id){
                System.out.println("-"+
                        is.getPackage_Type()+"-"+
                        is.getName_Insurance_Package()
                );
                status = 1;
            }

        }
        if(status == 0){
            System.out.println("Xe nay chua mua bao hiem nao");
        }
    }

    public void ShowCars(List<Car> list){
        list.sort(new Car());
        for (Car c:list){
            System.out.println(c.getNameCar()+" "+ c.getNumberPlate()+"-"+c.getYearManufacture()+"-"+c.getBrand()+"-"+c.getStatusInsurance(c.getHaveInsurance())+"-"+c.getCarType(c.getYearManufacture()));
        }
    }
    public void ShowInsurancePackage(List<Insurance_Package> list){
        for (Insurance_Package p:list){
            System.out.println(p.getId_Insurance()+"-"+p.getName_Insurance_Package());
        }
    }

}

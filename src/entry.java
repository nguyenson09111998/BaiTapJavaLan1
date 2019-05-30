import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class entry {
//https://www.mkyong.com/jdbc/connect-to-oracle-db-via-jdbc-driver-java/
    private static Scanner sc3 = new Scanner(System.in);
    public static void main(String[] args) {
        List<Car> list = GetCars();
        List<Insurance_Package> insurance_packageList = GetInsurancePackage();
        ManageCars mn = new ManageCars();
        while (true){
            System.out.println("-------------------------------\n" +
                    "1.Hien thi danh sach xe\n" +
                    "2.Thong tin chi tiet moi xe\n"+
                    "3.Thong tin chi tiet goi bao hiem\n"+
                    "4.Dang ki bao hiem o to"
            );
            System.out.println("Chon: ");
            Scanner sc1 = new Scanner(System.in);
            int choose = sc1.nextInt();
            switch (choose){
                case 1:
                    mn.ShowCars(list);
                    break;

                case 2:
                    System.out.println("Nhap bien so xe: ");
                    Scanner sc = new Scanner(System.in);
                    String number = sc.nextLine();
                    mn.showCarInfo(number,list,insurance_packageList);
                    break;

                case 3:
                    System.out.println("Nhap ten goi bao hiem: ");
                    Scanner sc2 = new Scanner(System.in);
                    String name = sc2.nextLine();
                    mn.assignAssurance(name,list,insurance_packageList);
                    break;
                case 4:
                    System.out.println("Nhap Bien so: ");
                    String numberCar = sc3.nextLine();
                    System.out.println("Nhap Goi bao hiem: ");
                    String nameInsurance = sc3.nextLine();
                    mn.SignUpInsurance(numberCar,nameInsurance,list,insurance_packageList);
                    break;

                default: break;
            }
        }
    }

    public static List<Insurance_Package> GetInsurancePackage(){
        List<Insurance_Package> list = new ArrayList<>();
        try {
            dbContext db = new dbContext();
            Connection conn = db.getConnection();
            Statement stmt=conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT *\n" +
                    "FROM bt_Insurance_Package\n" +
                    "join BT_INSURANCE on BT_INSURANCE.ID = BT_INSURANCE_PACKAGE.ID_INSURANCE");
            while (rs.next()){
                list.add(new Insurance_Package(rs.getString("Package_Type"),rs.getInt(1),rs.getString("NAME_INSURANCE_PACKAGE"),rs.getInt("ID_CAR")));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return list;
    }

    public static List<Car> GetCars(){
        List<Car> list = new ArrayList<>();
        try {
            dbContext db = new dbContext();
            Connection conn = db.getConnection();
            Statement stmt=conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM BT_CAR");
            while (rs.next()) {
                list.add(new Car(rs.getInt(1),rs.getInt(2), rs.getString("NameCar"),rs.getString("NumberPlate"),rs.getInt("YearOfManufacture"),rs.getString("Brand"), rs.getInt("HaveInsurance"), rs.getInt("Support")));
            }
            conn.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return list;
    }
}

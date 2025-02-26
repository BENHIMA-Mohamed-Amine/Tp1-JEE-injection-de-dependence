package dao;

public class DaoImplV1 implements IDao {
    @Override
    public double getData() {
        System.out.println("Version DB");
        double temp = 27;
        return temp;
    }
}

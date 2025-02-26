package dao;

import org.springframework.stereotype.Repository;

@Repository("dao1")
public class DaoImplV1 implements IDao {
    @Override
    public double getData() {
        System.out.println("Version DB");
        double temp = 27;
        return temp;
    }
}

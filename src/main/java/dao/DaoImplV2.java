package dao;

import org.springframework.stereotype.Repository;

@Repository("dao2")
public class DaoImplV2 implements IDao{
    @Override
    public double getData() {
        System.out.println("Version web service");
        return 40;
    }
}

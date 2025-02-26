package metier;

import dao.IDao;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service("metier")
public class MetierImpl implements IMetier {
    IDao dao;

    public MetierImpl(@Qualifier("dao1") IDao dao) {
        this.dao = dao;
    }

    @Override
    public double calcule() {
        double temp = dao.getData();
        return temp * 10;
    }
}

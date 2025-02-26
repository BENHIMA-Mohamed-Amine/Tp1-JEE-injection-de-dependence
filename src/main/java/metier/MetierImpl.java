package metier;

import dao.IDao;

public class MetierImpl implements IMetier {
    IDao dao;

    public MetierImpl(IDao dao) {
        this.dao = dao;
    }

    @Override
    public double calcule() {
        double temp = dao.getData();
        return temp * 10;
    }
}

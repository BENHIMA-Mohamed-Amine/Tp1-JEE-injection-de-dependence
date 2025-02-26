package pres;

import dao.DaoImplV1;
import dao.IDao;
import metier.IMetier;
import metier.MetierImpl;

public class PresStatic {
    public static void main(String[] args) {
        IDao dao = new DaoImplV1();
        IMetier metier = new MetierImpl(dao);
        System.out.println("RES="+metier.calcule());
    }
}

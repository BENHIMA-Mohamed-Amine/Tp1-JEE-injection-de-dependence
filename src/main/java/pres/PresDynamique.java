package pres;

import dao.IDao;
import metier.IMetier;

import java.io.File;
import java.util.Scanner;

public class PresDynamique {
    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(new File("./config.txt"));
            String daoClassName = scanner.nextLine();
            Class<?> cDao = Class.forName(daoClassName);
            IDao dao = (IDao) cDao.getConstructor().newInstance();

            String metierClassName = scanner.nextLine();
            Class<?> cMetier = Class.forName(metierClassName);
            IMetier metier = (IMetier) cMetier.getConstructor(IDao.class).newInstance(dao);
            System.out.println("Res="+metier.calcule());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

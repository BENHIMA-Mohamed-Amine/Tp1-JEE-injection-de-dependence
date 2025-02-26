# Tp1-JEE-injection-de-dependence
## 1. Vetsion Static
**Code main**
```java
public class PresStatic {
    public static void main(String[] args) {
        IDao dao = new DaoImplV1();
        IMetier metier = new MetierImpl(dao);
        System.out.println("RES="+metier.calcule());
    }
}
```
**Diagramme de classes**

![Diagramme de classes](/readme-images/DC-Static.png)

**Resultat**

![Resultat](/readme-images/resultat-static.png)

## 2. Veriosn Dynamique
```java
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
```
**Diagramme de classes**

![Diagramme de classes](/readme-images/DC-Dynamique.png)

**Fichier config.txt**

![config.txt](/readme-images/config.png)

**Resultat**

![Resultat](/readme-images/resultat-dynamique.png)

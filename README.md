# Tp1-JEE-injection-de-dependence
## 1. Version Static
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

## 2. Version Dynamique
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

## 3. Version Spring
**Ajout des dependences**
Ajouter ces dependences dans pom.xml
![dependences](/readme-images/dependences.png)

### 3.1 XML
![xml spring file](/readme-images/xml-spring.png)
### 3.2 Annotation
J'ai ajouter les annotations @Service et @Reposotiry dans les classes qui conviennent,
et pour utiliser la version DB j'ai utilier @Qualifier("dao1") dans le constucteur.
finallement voila le code de methode main:
```java
public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext("dao", "metier");
        IMetier metier = (IMetier) context.getBean("metier");
        System.out.println("Res="+metier.calcule());
    }
```
# Tp1-JEE-injection-de-dependence
## Vetsion Static
Code main
```java
public class PresStatic {
    public static void main(String[] args) {
        IDao dao = new DaoImplV1();
        IMetier metier = new MetierImpl(dao);
        System.out.println("RES="+metier.calcule());
    }
}
```
Diagramme de classes
![Diagramme de classes](/readme-images/DC-Static.png)
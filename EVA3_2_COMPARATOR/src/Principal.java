import java.util.Comparator;
import java.util.LinkedList;

public class Principal {

    public static void main(String[] args) {
        LinkedList<Integer> listaInt = new LinkedList<Integer>();
        LinkedList<String> listaString = new LinkedList<String>();
        
        for (int i = 0; i < 10; i++) {
            listaInt.add((int) (Math.random()*100));
        }
        Comparator c = new Comparator(){
            @Override
            public int compare(Object o1, Object o2) {
                int resu;
                //CERO=IGUAL
                //POSITIVO=MAYOR
                //NEGATIVO=MENOR
                Integer iVal1, iVal2;
                iVal1 = (Integer)o1;
                iVal2 = (Integer)o2;
                resu = iVal2 - iVal1;
                
                return resu;
            }
            
        };
        
        System.out.println(listaInt);
        listaInt.sort(c);
        System.out.println(listaInt);
        
        //Strings
        listaString.add("Hola");
        listaString.add(" ");
        listaString.add("Mundo");
        listaString.add(" ");
        listaString.add("Cruel");
        listaString.add("!!!");
        
        Comparator compStr = new Comparator(){
            @Override
            public int compare(Object o1, Object o2) {
                String cade1 = (String) o1;
                String cade2 = (String) o2;
                char c1 = cade1.charAt(0);
                char c2 = cade2.charAt(0);
                return c1 - c2;
            }
            
        };
        System.out.println(listaString);
        listaString.sort(compStr);
        System.out.println(listaString);
    }
    
}

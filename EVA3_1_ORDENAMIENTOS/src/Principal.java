
import java.util.Scanner;

public class Principal {

    public static void main(String[] args) {
        int[] data = new int[20];        
        long ini, fin;

//        llenar(data);
//        imprimirA(data);
//        ini = System.nanoTime();
//        selectionSort(data);
//        fin = System.nanoTime();
//        imprimirA(data);
//        System.out.println("Tiempo = " + (fin - ini));
//        
//        llenar(data);
//        imprimirA(data);
//        ini = System.nanoTime();
//        insertionSort(data);
//        fin = System.nanoTime();
//        imprimirA(data);
//        System.out.println("Tiempo = " + (fin - ini));
        
        llenar(data);
        imprimirA(data);
        //ini = System.nanoTime();
        quickSort(data);
        //fin = System.nanoTime();
        imprimirA(data);
        //System.out.println("Tiempo = " + (fin - ini));
        
        Scanner input = new Scanner(System.in);
        System.out.println("Valor a buscar");
        int iVal = input.nextInt();
        System.out.println("Posicion: " + busquedaBin(data, iVal));
        

    }
    
    public static void llenar(int[] arreglo){
        for (int i = 0; i < arreglo.length; i++) {
            arreglo[i] = (int)(Math.random() * 100);
        }
    }
    
    public static void imprimirA(int[] arreglo){
        for (int i = 0; i < arreglo.length; i++) {
            System.out.print("[" + arreglo[i] + "]");
        }
        System.out.println("");
    }
    
    //O(n^2) Hace mas comparaciones, menos intercambios
    public static void selectionSort(int[] arreglo){
        for (int i = 0; i < arreglo.length; i++) {
            int iMin = i;
            for (int j = i+1; j < arreglo.length; j++) {
                if(arreglo[iMin] > arreglo[j]){
                    iMin = j;
                }
            }
            //SWAP
            int value = arreglo[iMin];
            arreglo[iMin] = arreglo[i];
            arreglo[i] = value;
        }
    }
    
    //O(n^2) Hace mas intercambios, menos comparaciones
    public static void insertionSort(int[] arreglo){
        for (int i = 1; i < arreglo.length; i++) {
            int iTemp = arreglo[i];
            int insP;
            for (insP = i; insP > 0 ; insP--) {
                int iPrev = insP - 1;
                if(arreglo[iPrev] > iTemp){
                    //SWAP
                    arreglo[insP] = arreglo[iPrev];
                }else
                    break;
            }
           arreglo[insP] = iTemp;
        }
    }
    
    public static void bubbleSort(int[] arreglo){
        for (int i = 0; i < arreglo.length; i++) {
            for (int j = 0; j < arreglo.length - 1; j++) {
                if(arreglo[j] > arreglo[j + 1]){
                    //SWAP
                    int iTemp = arreglo[j];
                    arreglo[j] = arreglo[j + 1];
                    arreglo[j + 1] = iTemp;
                }
            }
        }
    }
    
    public static void quickSort(int[] arreglo){
        quickSortRec(arreglo, 0, arreglo.length -1);
    }
    
    private static void quickSortRec(int[] arreglo, int ini, int fin){
        //DETENERNOS
        if((ini < fin) && (ini >= 0) && (fin < arreglo.length)){
            int iPiv = ini;
            int too_Big = ini + 1;
            int too_Small = fin;
            int iTemp;
            while(too_Big < too_Small){
                while((too_Big < fin) && (arreglo[too_Big] < arreglo[iPiv])){
                    too_Big++;
                }
                while((too_Big > (ini + 1)) && (arreglo[too_Small] < arreglo[iPiv])){
                    too_Small--;
                }
                
                if(too_Big < too_Small){//NO HAY CRUCE
                    iTemp = arreglo[too_Big];
                    arreglo[too_Big] = arreglo[too_Small];
                    arreglo[too_Small] = iTemp;
                }
            }
            //SWAP EL PIVOTE
            iTemp = arreglo[iPiv];
            arreglo[iPiv] = arreglo[too_Small];
            arreglo[too_Small] = iTemp;
            
            quickSortRec(arreglo, ini, too_Small - 1);//IZQ
            quickSortRec(arreglo, too_Small + 1, fin);//DER
            }
        }
    
    
    public static int busquedaBin(int[] arreglo, int iVal){
        return busquedaBinRec(arreglo, iVal, 0, arreglo.length - 1);
    }
    
    private static int busquedaBinRec(int[] arreglo, int iVal, int ini, int fin){
       if(ini <= fin){
        int mid = ini + ((fin - ini) / 2);

        if(iVal == arreglo[mid]){//IGUAL
            return mid;
        }else if(iVal > arreglo[mid]){//MAYOR
            return busquedaBinRec(arreglo, iVal, mid + 1, fin);
        }else{//MENOR
            return busquedaBinRec(arreglo, iVal, ini, mid - 1);
        }
      }else{
           return -1;
       }
    }
}

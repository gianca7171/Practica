public class DemoMetodoGenerico {

    // Método genérico que compara si dos arreglos contienen los mismos elementos
    static <T extends Comparable<T>> boolean igualArrays(T[] x, T[] y) {
        // Si las longitudes de los arreglos son diferentes, retorna false
        if (x.length != y.length)
            return false;

        // Comparar cada elemento del arreglo
        for (int i = 0; i < x.length; i++) {
            if (!x[i].equals(y[i])) // Si un solo elemento es diferente, retorna false
                return false;
        }

        return true; // Si todos los elementos son iguales, retorna true
    }

    public static void main(String[] args) {
        // Declaración de arreglos de enteros
        Integer nums[]  = {1, 2, 3, 4, 5};
        Integer nums2[] = {1, 2, 3, 4, 5};
        Integer nums3[] = {1, 2, 7, 4, 5};
        Integer nums4[] = {1, 2, 7, 4, 5, 6};

        // Comparaciones de arreglos e impresión de resultados
        if (igualArrays(nums, nums))
            System.out.println("nums es igual a nums");

        if (igualArrays(nums, nums2))
            System.out.println("nums es igual a nums2");

        if (igualArrays(nums, nums3))
            System.out.println("nums es igual a nums3");

        if (igualArrays(nums, nums4))
            System.out.println("nums es igual a nums4");

        // Crea un array de tipo double (Descomentar para ver el error de tipos)
        // Double dvals[] = {1.1, 2.2, 3.3, 4.4, 5.5};  // B
        // if (igualArrays(nums, dvals))               // C
        //     System.out.println("nums es igual a dvals"); // D
    }
}

package com.campusdual.classroom;

public class Exercise19 {

    private static String getTridimensionalString(int[][][] intArrayTri, int[][] flatMatrix) {

        int rows = intArrayTri[0].length;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < rows; i++) {
            sb.append(stringFlatMatrixRow(flatMatrix, i));
            sb.append("   →   ");
            sb.append(stringTriMatrixRow(intArrayTri, i));
            sb.append("\n");
        }
        sb.delete(sb.length()-1, sb.length());
        return sb.toString();

    }

    private static String stringTriMatrixRow(int[][][] intArrayTri, int row) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < intArrayTri.length-1; i++){
            sb.append(getUnidimensionalString(intArrayTri[i][row]));
            sb.append("   ");
        }
        sb.append(getUnidimensionalString(intArrayTri[intArrayTri.length-1][row]));

        return sb.toString();
    }

    private static String stringFlatMatrixRow(int[][] flatMatrix, int row) {
        return getUnidimensionalString(flatMatrix[row]);
    }

    public static String getTridimensionalString(int[][][] intArrayTri) {
        int[][] flatMatrix = flatTridimensionalArray(intArrayTri);
        return getTridimensionalString(intArrayTri, flatMatrix);
    }

    //TODO
    public static int[][] flatTridimensionalArray(int[][][] intArrayTri) {
         int profundidad = intArrayTri[0][0].length;
         int columnas = intArrayTri[0].length;
         int filas= intArrayTri.length;
         int[][] array2d = new int[filas][columnas];
        for (int i = 0; i < columnas; i++) {
            for (int j = 0; j < profundidad; j++) {
                int suma = 0;
                for (int k = 0; k < filas; k++) {
                    suma += intArrayTri[k][i][j];
                }
                array2d[i][j] = suma;
            }
        }
        return array2d;
    }


    // TODO
    public static String getBidimensionalString(int[][] intArrayBi) {
         StringBuilder string = new StringBuilder();

        for (int i = intArrayBi.length-1; i >=0; i--) {
                string.append(stringFlatMatrixRow(intArrayBi, (intArrayBi.length-i)-1));
                if(i != 0){
                    string.append("\n");
                }

        }
         return string.toString();
    };

    // TODO
    public static String getUnidimensionalString(int[] uniArray) {
        StringBuilder string = new StringBuilder();
        for (int i = 0; i < uniArray.length; i++) {
            if(i != uniArray.length-1){
                string.append(uniArray[i]+" ");
            }else {
                string.append(uniArray[i]);
            }
        }
        return string.toString();
    }

    // TODO
    public static int[] createAndPopulateUnidimensionalArray(int columns) {
        int[] uniDimensional = new int[columns];
        for (int i = 0; i < columns; i++) {
            uniDimensional[i] = i+1;
        }
        return uniDimensional;
    }

    // TODO
    public static int[][] createAndPopulateBidimensionalArray(int rows, int columns) {
        int[][] biDimensional = new int[rows][columns];
        int z= 1;
        for (int i = 0; i < columns; i++) {
            for (int j = 0; j < rows; j++) {
                biDimensional[i][j] = z;
                z +=1;
            }
        }

        return biDimensional;
    }

    // TODO
    public static int[][][] createAndPopulateTridimensionalArray(int depth, int rows, int columns) {
        int[][][] triDimensional = new int[rows][columns][depth];
        int z = 1;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j <columns ; j++) {
                for (int k = 0; k < depth; k++) {
                    triDimensional[i][j][k] = z;
                    z +=1;
                }
            }
        }

        return triDimensional;
    }

    public static void main(String[] args) {
        int[] uniArray = createAndPopulateUnidimensionalArray(5);
        System.out.println(getUnidimensionalString(uniArray));
        System.out.println("===================");
        int[][] intArrayBi = createAndPopulateBidimensionalArray(5, 5);
        System.out.println(getBidimensionalString(intArrayBi));
        System.out.println("===================");
        int[][][] intArrayTri = createAndPopulateTridimensionalArray(3, 3, 3);
        System.out.println(getTridimensionalString(intArrayTri));
    }
}

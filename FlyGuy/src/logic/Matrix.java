package logic;

/**
 * Klasa reprezentuje macierz 4x4 wartości typu double.
 * @author alebar
 */
public class Matrix {
    private Double[][] m;

    /**
     * Konstruktor tworzy pustą macierz - niczym nie wypełnioną.
     */
    public Matrix () {
        m = new Double[4][4];
    }

    /**
     * Konstruktor tworzy macierz na podstawie gotowej tablicy.
     * Przyjmuje parametr typu Double[][], zawierający wartości macierzy.
     * @param tab
     */
    public Matrix (Double[][] tab) {
        m = tab.clone();
    }

    /**
     * Ten konstruktor tworzy macierz jednostkową I.
     */
    public Matrix (char c) {
        m = new Double[4][4];
        if (c=='I') {
            for (int w=0; w<4; w++) {
                for (int k=0; k<4; k++) {
                    if (w==k) m[w][k] = 1.0;
                    else m[w][k] = 0.0;
                }
            }
        }
    }

    /**
     * Zwraca tablicę zawierającą elementy macierzy.
     * @return
     */
    protected Double[][] getTab () {
        Double[][] tab = m.clone();
        return tab;
    }

    /**
     * Metoda ustawia wartość elementu w wierszu 'w' i kolumnie 'k' na wartość 'd'.
     * Jest to prosty sposób na zmianę parametrów macierzy.
     * @param w
     * @param k
     * @param d
     */
    protected void setVal (int w, int k, double d) {
        m[w][k] = d;
    }

    /**
     * Metoda mnoży macierz kwadratową 4x4 przez drugą macierz, też 4x4.
     * Parametrem metody jest macierz, przez którą mnożymy.
     * Wynik nadpisuje macierz, która jest mnożona.
     * Jest to mnożenie lewostronne: po lewej stronie mnożenia macierzy jest
     * ta z parametru, po prawej macierz mnożona. Czyli: p*m=m'
     * @param p
     */
    protected void multiple (Matrix p) throws Exception {
        // m musi byc po prawej stronie mnozenia, czyli y*m=x
        if (this.m == null)
            throw new Exception("macierz nie została zainicjowana");
        // x to bedzie macierz wynikowa
        Double[][] x = new Double[4][4];
        Double[][] y = p.getTab();
        for (int w=0; w<4; w++) { // dla każdego wiersza macierzy y
            for (int k=0; k<4; k++) { // dla każdej kolumny macierzy m
                x[w][k] = y[w][0]*m[0][k]+y[w][1]*m[1][k]+y[w][2]*m[2][k]+y[w][3]*m[3][k];
            }
        }
        m = x.clone();
    }

    /**
     * Prosta metoda do wyświetlenia zawartości macierzy na wyjściu systemowym (System.out).
     */
    public void show () {
        for (int w=0; w<4; w++) {
            System.out.print("| ");
            for (int k=0; k<4; k++) {
                System.out.print(m[w][k]+" ");
            }
            System.out.print(" |\n");
        }
    }
}

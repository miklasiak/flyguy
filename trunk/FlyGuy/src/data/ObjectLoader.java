package data;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import logic.Triangle3D;
import logic.Point;

import java.io.*;



/**
 * Klasa odpowiada za czytanie plików.
 * @author alebar
 */
public class ObjectLoader {

    /**
     * Zadaniem tej statycznej metody jest wczytanie wszystkich trójkątnych
     * płaszczyzn z pliku tekstowego.
     * @param filename Nazwa pliku
     * @return Lista wczytanych trójkątów
     */
    public static ArrayList<Triangle3D> getTriangleList(String filename) {
        BufferedReader br;
        DataInputStream in;
        try {
            FileInputStream fstream = new FileInputStream(filename);
            in = new DataInputStream(fstream);
            br = new BufferedReader(new InputStreamReader(in));
            String strLine;
            String[] strTab;
            Point p1, p2, p3;
            double[] d = new double[9];
            ArrayList<Triangle3D> trojkaty = new ArrayList<Triangle3D>();

            while ((strLine = br.readLine()) != null) {
                if (strLine.length() == 0) continue;
                if (strLine.charAt(0)=='/') continue;
                if (strLine.charAt(0)=='*') continue;
                    
                strTab = strLine.split(";");
                for (int i=0; i<9; i++) {
                    d[i] = Double.valueOf(strTab[i]);
                }
                p1 = new Point(d[0], d[1], d[2]);
                p2 = new Point(d[3], d[4], d[5]);
                p3 = new Point(d[6], d[7], d[8]);

                trojkaty.add(new Triangle3D(p1, p2, p3));
            }
            in.close();
            return trojkaty;
        } catch (Exception ex) {
            Logger.getLogger(ObjectLoader.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }

    }
}

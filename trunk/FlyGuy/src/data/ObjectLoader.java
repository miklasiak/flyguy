package data;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import logic.Line3D;
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
    public static ArrayList<Line3D> getTriangleList(String filename) {
        BufferedReader br;
        DataInputStream in;
        try {
            FileInputStream fstream = new FileInputStream(filename);
            in = new DataInputStream(fstream);
            br = new BufferedReader(new InputStreamReader(in));
            String strLine;
            String[] strTab;
            Point p1, p2;
            double[] d = new double[6];
            ArrayList<Line3D> linie = new ArrayList<Line3D>();

            while ((strLine = br.readLine()) != null) {
                if (strLine.length() == 0) continue;
                if (strLine.charAt(0)=='/') continue;
                if (strLine.charAt(0)=='*') continue;
                    
                strTab = strLine.split(";");
                for (int i=0; i<6; i++) {
                    d[i] = Double.valueOf(strTab[i]);
                }
                p1 = new Point(d[0], d[1], d[2]);
                p2 = new Point(d[3], d[4], d[5]);

                linie.add(new Line3D(p1, p2));
            }
            in.close();
            return linie;
        } catch (Exception ex) {
            Logger.getLogger(ObjectLoader.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }

    }
}

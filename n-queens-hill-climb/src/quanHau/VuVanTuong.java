/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package quanHau;

import java.util.Vector;

/**
 *
 * @author TRITUEVIET
 */
public class VuVanTuong {

    static int N = 1000;
    Hau hau;
    Vector<Hau> items = new Vector<Hau>();

    public VuVanTuong() {
        int[] mang = new int[N];
        for (int i = 0; i < N; i++) {
            mang[i] = i;
        }
        hau = new Hau(mang);
        items.addElement(hau);

        xuLy();
    }

    public static void main(String[] args) {
        new VuVanTuong();
    }

    public void xuLy() {
        int dem = 0;
        hau.setXungDot(heuristics(hau));
        while (hau.getXungDot() != 0) {
            //in(hau);
            dem++;

            if (items.size() == 0) {
                System.out.println("break");
                break;
            }
            hau = items.elementAt(0);
            items.removeElementAt(0);
            hangXom(hau);
        }
        System.out.println("\n" + dem);
        in(hau);
        System.out.println("xung dot :"+hau.getXungDot());
    }

    private void in(Hau hau) {
        for (int i = 0; i < N; i++) {
            System.out.print(" " + hau.getMangHau()[i]);
        }
        System.out.println("\n");
    }

    private int heuristics(Hau hau) {
        int n = 0;
        for (int i = 0; i < N - 1; i++) {
            for (int j = i + 1; j < N; j++) {
                if (hau.getMangHau()[i] + i == hau.getMangHau()[j] + j
                        || hau.getMangHau()[i] - i == hau.getMangHau()[j] - j) {
                    n++;
                }
            }
        }
        return n;
    }

    private void hangXom(Hau item) {

        for (int i = 0; i < N - 1; i++) {
            for (int j = i + 1; j < N; j++) {
                Hau hangXom = new Hau(item.getMangHau(), i, j, item.getXungDot());
                //in(hangXom);
                if (hangXom.getXungDot() < item.getXungDot()) {
                    items.addElement(hangXom);
                    return;
                }
            }
        }

    }
}

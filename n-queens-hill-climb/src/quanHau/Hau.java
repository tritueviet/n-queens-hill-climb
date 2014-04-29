/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package quanHau;

/**
 *
 * @author TRITUEVIET
 */
public class Hau {

    private int[] mangHau;
    private int xungDot = 0;

    public Hau() {
    }

    public int[] getMangHau() {
        return mangHau;
    }

    public void setMangHau(int[] mangHau) {
        this.mangHau = mangHau;
    }

    public int getXungDot() {
        return xungDot;
    }

    public void setXungDot(int xungDot) {
        this.xungDot = xungDot;
    }

    public Hau(int[] mangHau) {
        this.mangHau = new int[mangHau.length];
        for (int i = 0; i < mangHau.length; i++) {
            this.mangHau[i] = mangHau[i];
        }
    }

    public Hau(int[] mangHau, int i, int j, int xungDot) {

        this.mangHau = new int[mangHau.length];

        int ii = mangHau[j];
        int jj = mangHau[i];

        int dem1 = 0, dem2 = 0;

        for (int k = 0; k < this.mangHau.length; k++) {
            if (k != i) {
                if (k == j) {
                    if (ii + i == jj + k
                            || ii - i == jj - k) {
                        dem1++;
                    }
                } else {
                    if (ii + i == mangHau[k] + k
                            || ii - i == mangHau[k] - k) {
                        dem1++;
                    }
                }

                if (mangHau[i] + i == mangHau[k] + k
                        || mangHau[i] - i == mangHau[k] - k) {
                    dem2++;
                }
            }
            if (k != j) {
                if (k == i) {
                    if (jj + j == ii + k
                            || jj - j == ii - k) {
                        dem1++;
                    }
                } else {
                    if (jj + j == mangHau[k] + k
                            || jj - j == mangHau[k] - k) {
                        dem1++;
                    }
                }
                if (mangHau[j] + j == mangHau[k] + k
                        || mangHau[j] - j == mangHau[k] - k) {
                    dem2++;
                }
            }
            setXungDot(xungDot - dem2 + dem1);

            this.mangHau[k] = mangHau[k];
        }
        this.mangHau[i] = ii;
        this.mangHau[j] = jj;
    }
}

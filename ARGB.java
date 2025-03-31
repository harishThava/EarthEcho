public class ARGB {
    public int alpha, red, green, blue;

    //ntakes a single int representing a pixel's ARGB value
    public ARGB(int pixel) {
        this.alpha = (pixel >> 24) & 0xff;
        this.red   = (pixel >> 16) & 0xff;
        this.green = (pixel >> 8) & 0xff;
        this.blue  = pixel & 0xff;
    }

    public ARGB(int a, int r, int g, int b) {
        this.alpha = a;
        this.red = r;
        this.green = g;
        this.blue = b;
    }

    public int toInt() {
        //  combine each color component back into one 32-bit integer
        return (this.alpha << 24) | (this.red << 16) | (this.green << 8) | blue;
    }
}

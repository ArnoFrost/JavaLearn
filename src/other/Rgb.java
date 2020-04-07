package other;

import java.util.Objects;

/**
 * <pre>
 *     author: xuxin
 *     time  : 2020/3/29
 *     desc  :
 * </pre>
 */
public class Rgb {
    private int red;
    private int green;
    private int blue;

    public Rgb(int red, int green, int blue) {
        this.red = red;
        this.green = green;
        this.blue = blue;
    }

    public int getRed() {
        return red;
    }

    public void setRed(int red) {
        this.red = red;
    }

    public int getGreen() {
        return green;
    }

    public void setGreen(int green) {
        this.green = green;
    }

    public int getBlue() {
        return blue;
    }

    public void setBlue(int blue) {
        this.blue = blue;
    }

    @Override
    public String toString() {
        return "Rgb{" +
                "red=" + red +
                ", green=" + green +
                ", blue=" + blue +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Rgb rgb = (Rgb) o;
        return red == rgb.red &&
                green == rgb.green &&
                blue == rgb.blue;
    }

    @Override
    public int hashCode() {
        return Objects.hash(red, green, blue);
    }
}

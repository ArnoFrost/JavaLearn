package other;

/**
 * @Author: ArnoFrost
 * @Date: 2020/4/1 20:14
 * @Version 1.0
 */
public class ColorTest {
    public static void main(String[] args) {
//        System.out.println(isArrow(138,111,29));
//        System.out.println(isArrow(116,90,23));
//
//        System.out.println(isArrow(127,100,25));
//        System.out.println(isArrow(200,205,121));
//        System.out.println(isArrow(206,206,107));
        System.out.println(isBlue(0, 0, 255));
    }

    private static boolean isArrow(int red, int green, int blue) {
        //道路与箭头颜色偏移量
        int yellowOffset = 40;
        //黄色道路 255,223,0
        Rgb arrowRgb = new Rgb(255, 223, 0);
        Rgb arrowRgb2 = new Rgb(255, 255, 52);
        int yellowOffset2 = 15;
        int blueoffset = 15;
        Rgb arrowRgb3 = new Rgb(158, 139, 120);
        int yellowOffset3 = 12;
        Rgb arrowRgb4 = new Rgb(214, 207, 115);

        Rgb arrowRgb5 = new Rgb(223, 206, 86);
        Rgb arrowRgb6 = new Rgb(193, 194, 118);
        Rgb arrowRgb7 = new Rgb(127, 100, 25);

        if (Math.abs(red - arrowRgb.getRed()) <= yellowOffset
                && Math.abs(green - arrowRgb.getGreen()) <= yellowOffset
                && Math.abs(blue - arrowRgb.getBlue()) <= yellowOffset) {
            return true;
        } else if (Math.abs(red - arrowRgb2.getRed()) <= yellowOffset
                && Math.abs(green - arrowRgb2.getGreen()) <= yellowOffset
                && Math.abs(blue - arrowRgb2.getBlue()) <= yellowOffset) {
            return true;
        } else if (Math.abs(red - arrowRgb3.getRed()) <= yellowOffset2
                && Math.abs(green - arrowRgb3.getGreen()) <= yellowOffset2
                && Math.abs(blue - arrowRgb3.getBlue()) <= blueoffset) {
            return true;
        } else if (Math.abs(red - arrowRgb4.getRed()) <= yellowOffset3
                && Math.abs(green - arrowRgb4.getGreen()) <= yellowOffset3
                && Math.abs(blue - arrowRgb4.getBlue()) <= blueoffset) {
            return true;
        } else if (Math.abs(red - arrowRgb5.getRed()) <= yellowOffset3
                && Math.abs(green - arrowRgb5.getGreen()) <= yellowOffset3
                && Math.abs(blue - arrowRgb5.getBlue()) <= blueoffset) {
            return true;
        } else if (Math.abs(red - arrowRgb6.getRed()) <= yellowOffset3
                && Math.abs(green - arrowRgb6.getGreen()) <= yellowOffset3
                && Math.abs(blue - arrowRgb6.getBlue()) <= blueoffset) {
            return true;
        } else if (Math.abs(red - arrowRgb7.getRed()) <= yellowOffset3
                && Math.abs(green - arrowRgb7.getGreen()) <= yellowOffset3
                && Math.abs(blue - arrowRgb7.getBlue()) <= blueoffset) {
            return true;
        }

        return false;
    }

    private static boolean isBlue(int red, int green, int blue) {
        int redOffset = 10;
        int greenOffset = 2;
        int offSet10Min = 50;
        int offSet10Max = 255;

        Rgb blueRgb10 = new Rgb(10, 0, 50);
//        Rgb blueRgb160 = new Rgb(160, 98, 252);
//        Rgb blueRgb111 = new Rgb(111, 109, 191);
        if (Math.abs(red - blueRgb10.getRed()) <= redOffset
                && Math.abs(green - blueRgb10.getGreen()) <= greenOffset
                && (blue >= offSet10Min && blue <= offSet10Max)) {
            return true;
        }
//        else if ((red >= blueRgb160.getRed() - blue10Offset && red <= blueRgb160.getRed() + blue10Offset)
//                && Math.abs(green - 98) <= blue10Offset
//                && (Math.abs(blue - )) {
//            return true;
//        }

        return false;
    }

}

//package utils;
//
//import org.jbarcode.JBarcode;
//import org.jbarcode.JBarcodeFactory;
//import org.jbarcode.encode.Code128Encoder;
//import org.jbarcode.encode.InvalidAtributeException;
//import org.jbarcode.paint.TextPainter;
//import org.jbarcode.util.ImageUtil;
//
//import java.awt.*;
//import java.awt.image.BufferedImage;
//import java.io.*;
//import java.util.ArrayList;
//import java.util.List;
//
///**
// * 类名称：JbarcodeUtil
// * 类描述：条形码的生成
// * 创建人：MFJ
// * 创建时间：2019/1/10 9:05
// * 修改备注：条形码生成工具类   ，需导入jbarcode-0.2.8.jar架包
// *
// * @version 1.0
// */
//public class JbarcodeUtil {
//    //设置条形码高度
//    private static final int BARCODE_HEIGHT = 20;
//    //设置条形码默认分辨率
//    private static final int BARCODE_DPI = ImageUtil.DEFAULT_DPI;
//    //设置条形码字体样式
////    private static final String FONT_FAMILY = "console";
//    private static final String FONT_FAMILY = "Monospaced";
//    //设置条形码字体大小
//    private static final int FONT_SIZE = 16;
//    //设置条形码文本
//    public static String TEXT = "";
//    //创建jbarcode
//    private static JBarcode jbc = null;
//
//    static JBarcode getJBarcode() throws InvalidAtributeException {
//        /**
//         * 参考设置样式：
//         *barcode.setEncoder(Code128Encoder.getInstance()); //设置编码
//         *barcode.setPainter(WidthCodedPainter.getInstance());// 设置Painter
//         *barcode.setTextPainter(BaseLineTextPainter.getInstance()); //设置TextPainter
//         *barcode.setBarHeight(17); //设置高度
//         *barcode.setWideRatio(Double.valueOf(30).doubleValue());// 设置宽度比率
//         *barcode.setXDimension(Double.valueOf(2).doubleValue()); // 设置尺寸，大小 密集程度
//         *barcode.setShowText(true); //是否显示文本
//         *barcode.setCheckDigit(true); //是否检查数字
//         *barcode.setShowCheckDigit(false); //是否显示检查数字
//         */
//        if (jbc == null) {
//            //生成code128
//            jbc = JBarcodeFactory.getInstance().createCode128();
//            jbc.setEncoder(Code128Encoder.getInstance());
//            jbc.setTextPainter(CustomTextPainter.getInstance());
//            jbc.setBarHeight(BARCODE_HEIGHT);
//            jbc.setXDimension(0.4);
//            jbc.setCheckDigit(true);
//            jbc.setShowText(true);
//        }
//        return jbc;
//    }
//
//    /**
//     * @param message 条形码内容
//     * @param file    生成文件
//     * @descript:生成条形码文件
//     */
//    public static void createBarcode(String message, File file, String text) {
//        try {
//            FileOutputStream fos = new FileOutputStream(file);
//            createBarcode(message, fos, text);
//            fos.close();
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//    }
//
//    /**
//     * @param message 条形码内容
//     * @param os      输出流
//     * @descript:生成条形码并写入指定输出流
//     */
//    public static void createBarcode(String message, OutputStream os, String text) {
//        try {
//            //设置条形码文本
//            TEXT = text;
//            //创建条形码的BufferedImage图像
//            BufferedImage image = getJBarcode().createBarcode(message);
//            ImageUtil.encodeAndWrite(image, ImageUtil.PNG, os, BARCODE_DPI, BARCODE_DPI);
//            os.flush();
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        }
//    }
//
//    /**
//     * 静态内部类
//     * 自定义的 TextPainter， 允许定义字体，大小，文本等
//     * 参考底层实现：BaseLineTextPainter.getInstance()
//     */
//
//    protected static class CustomTextPainter implements TextPainter {
//        private static final CustomTextPainter instance = new CustomTextPainter();
//
//        public static CustomTextPainter getInstance() {
//            return instance;
//        }
//
//        public void paintText(BufferedImage barCodeImage, String text, int width) {                //绘图
//            Graphics g2d = barCodeImage.getGraphics();                //创建字体
//            Font font = new Font(FONT_FAMILY, Font.PLAIN, FONT_SIZE * width);
//            g2d.setFont(font);
//            FontMetrics fm = g2d.getFontMetrics();
//            int height = fm.getHeight();
//            int center = (barCodeImage.getWidth() - fm.stringWidth(text)) / 2;
//            g2d.setColor(Color.WHITE);
//            g2d.fillRect(0, 0, barCodeImage.getWidth(), barCodeImage.getHeight() / 20);
//            g2d.fillRect(0, barCodeImage.getHeight() - (height * 9 / 10), barCodeImage.getWidth(), (height * 9 / 10));
//            g2d.setColor(Color.BLACK);                //绘制文本
//            g2d.drawString(TEXT, 0, 145);                //绘制条形码
////            g2d.drawString(text, center, barCodeImage.getHeight() - (height / 10) - 2);
//            g2d.drawString(text, center, barCodeImage.getHeight() - (height / 10) - 2);
//        }
//    }
//
//    //测试
//    public static void main(String[] args) throws FileNotFoundException, IOException {
//        List<String> list = new ArrayList<String>();
//        list.add("1234567890");
//        list.add("19950108");
//        list.add("19941218");
//        String rootPath = "/Users/arno/Desktop/条形码/";
//        String DESC = "";
//
//        String fileName;
//        System.out.println("开始生成");
//        if (list.size() > 0) {
//            for (String message : list) {
//                fileName = rootPath + message + ".png";
//                JbarcodeUtil.createBarcode(message, new File(fileName), DESC);
//                System.out.println("生成 :" + fileName);
//            }
//        }
//        System.out.println("生产完毕");
//    }
//}
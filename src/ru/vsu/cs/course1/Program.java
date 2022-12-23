package ru.vsu.cs.course1;

import org.apache.commons.cli.CommandLine;
import ru.vsu.cs.util.ArrayUtils;
import ru.vsu.cs.util.SwingUtils;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.PixelGrabber;
import java.awt.image.Raster;
import java.awt.image.WritableRaster;
import java.io.*;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.Locale;
import java.util.Objects;
import java.util.Optional;


public class Program {

    public static void winMain() throws Exception {
        //SwingUtils.setLookAndFeelByName("Windows");
        Locale.setDefault(Locale.ROOT);
        //UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        SwingUtils.setDefaultFont("Microsoft Sans Serif", 18);

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrameMain().setVisible(true);
            }
        });
    }

    public static void main(String[] args) throws Exception {
       System.out.println((RLE.solve(new int[]{0, 1, 2, 2, 3, 4, 4, 5, 6})));
        System.out.println(RLE.unSolve(RLE.solve(new int[]{0, 1, 2, 2, 3, 4, 4, 5, 6})));
        System.out.println(pixelsToBinary(colorsOfImg("22.jpg")).length());
        System.out.println(RLE.solve(colorsOfImg("22.jpg")).length());
        System.out.println(pixelsToBinary(colorsOfImg("105.jpg")).length() -
                (RLE.solve(colorsOfImg("105.jpg"))).length());
//        System.out.println(colorsOfImg("pypka.jpg").length);
//        System.out.println((Arrays.toString(colorsOfImg("pypka.jpg"))));
//        System.out.println((Objects.requireNonNull(colorsOfImg("60.jpg"))).length);
//        System.out.println((RLE.unSolve(RLE.solve(Objects.requireNonNull(colorsOfImg("60.jpg"))))).size());
//        int[] img = colorsOfImg("pypka.jpg");
        //winMain();
    }



    public static int[] colorsOfImg(String filename, Raster r) {
        return r.getPixels(0,0,r.getWidth(), r.getHeight(), (int[])null);
    }

//    public static String solveToString(int[] arr) {
//        StringBuilder stringBuilder = new StringBuilder();
//
//        for (int pixel : arr) {
//            stringBuilder.append()
//        }
//    }

    public static String pixelsToBinary(int[] arr) {
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < arr.length; i++) {
            stringBuilder.append(RLE.toBinary(arr[i], 8));
        }
        return stringBuilder.toString();
    }

    public static int[] colorsOfImg(String filename) {
        try {
            BufferedImage img = ImageIO.read(new File(filename)); // Throws IOException
            Raster r = img.getData();
            return r.getPixels(0, 0, r.getWidth(), r.getHeight(), (int[]) null);
        } catch (IOException e) {

        }
        return null;
    }

    public static Image getImageFromArray(int[] pixels, int width, int height, BufferedImage img) {
        BufferedImage image = new BufferedImage(width, height, img.getType());
        WritableRaster raster = (WritableRaster) image.getData();
        raster.setPixels(0,0,width,height,pixels);
        return image;
    }

    public static byte[] fileToByte(String fileName) throws IOException {
        File fi = new File(fileName);
        return Files.readAllBytes(fi.toPath());
    }
}

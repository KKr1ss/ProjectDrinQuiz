/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Helpers;

import java.awt.Font;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author akile
 */
public class ViewHelper {

    public static void infoBox(String infoMessage) {
        JOptionPane.showMessageDialog(null, infoMessage, "A nap értesítése", JOptionPane.INFORMATION_MESSAGE);
    }

    public static void scaleImageInLabel(String path, JLabel label) {
        ImageIcon icon = new ImageIcon(path);
        Image img = icon.getImage();
        Image imgScale = img.getScaledInstance(label.getWidth(),
                label.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(imgScale);
        label.setIcon(scaledIcon);
    }

    public static void switchPanelView(JPanel oldPanel, JPanel newPanel) {
        oldPanel.setVisible(false);
        newPanel.setVisible(true);
    }

    public static void fontResizer(JLabel label) {
        Font labelFont = label.getFont();
        String labelText = label.getText();

        int stringWidth = label.getFontMetrics(labelFont).stringWidth(labelText);
        int componentWidth = label.getWidth();

        double widthRatio = (double) componentWidth / (double) stringWidth;

        int newFontSize = (int) (labelFont.getSize() * widthRatio);
        int componentHeight = label.getHeight();

        int fontSizeToUse = Math.min(newFontSize, componentHeight);

        label.setFont(new Font(labelFont.getName(), Font.PLAIN, fontSizeToUse));
    }
}

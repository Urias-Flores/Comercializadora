package Resources;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Utilities {
    
    private static int UsuarioID;
    private static String UsuarioActual;
    private static String AccesoUsuario;

    public static String getUsuarioActual() {
        return UsuarioActual;
    }
    
    public static int getUsuarioIDActual() {
        return UsuarioID;
    }

    public static void setUsuarioActual(int UsuarioID, String UsuarioActual) {
        Utilities.UsuarioID = UsuarioID;
        Utilities.UsuarioActual = UsuarioActual;
    }

    public static String getAccesoUsuario() {
        return AccesoUsuario;
    }

    public static void setAccesoUsuario(String AccesoUsuario) {
        Utilities.AccesoUsuario = AccesoUsuario;
    }
    
    public ImageIcon ResizeImage(int width, int height, String URL) {
        
        BufferedImage bufferedImage;
        Image image = null;
        try {
            bufferedImage = ImageIO.read(new File(URL));
            image = bufferedImage.getScaledInstance(width, height, Image.SCALE_DEFAULT);
            return  new ImageIcon(image);
        } catch (IOException ex) {
            Logger.getLogger(Utilities.class.getName()).log(Level.SEVERE, null, ex);
        }
        return new ImageIcon(image);
    }
    
    public static MouseListener CloseBotonEfect = new MouseListener() {
        @Override
        public void mouseClicked(MouseEvent e) {
        }
        @Override
        public void mousePressed(MouseEvent e) {
        }
        @Override
        public void mouseReleased(MouseEvent e) {
        }
        @Override
        public void mouseEntered(MouseEvent e) {
            JLabel l = (JLabel) e.getComponent();
            l.setOpaque(true);
            l.setBackground(Color.red);
        }
        @Override
        public void mouseExited(MouseEvent e) {
            JLabel l = (JLabel) e.getComponent();
            l.setBackground(new Color(39, 49, 65));
            l.setOpaque(true);
        }
    };
}

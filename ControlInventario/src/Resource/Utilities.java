package Resource;

import Controllers.UsuarioJpaController;
import Models.Usuario;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JTextField;

public class Utilities {

    private static Object[] UsuarioActual = {1, "Admin"};
    
    private static MouseListener mlButtonClose = new MouseListener() {
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
            l.setIcon(new ImageIcon(getClass().getResource("/Icons/closeWhite.png")));
            l.setBackground(Color.red);
        }

        @Override
        public void mouseExited(MouseEvent e) {
            JLabel l = (JLabel) e.getComponent();
            l.setIcon(new ImageIcon(getClass().getResource("/Icons/closeBlue.png")));
            l.setBackground(Color.white);
        }
    };
    private static MouseListener mlGeneralButton = new MouseListener() {
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
            JLabel btn = (JLabel) e.getComponent();
            btn.setBackground(new Color(4, 78, 141));
        }

        @Override
        public void mouseExited(MouseEvent e) {
            JLabel btn = (JLabel) e.getComponent();
            btn.setBackground(new Color(3, 57, 103));
        }
    };
    private static MouseListener mlGrayButton = new MouseListener() {
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
            l.setBackground(new Color(210, 210, 210));
        }

        @Override
        public void mouseExited(MouseEvent e) {
            JLabel l = (JLabel) e.getComponent();
            l.setBackground(Color.white);
        }
    };
    private static MouseListener mlButtonCloseBlue = new MouseListener() {
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
            l.setBackground(Color.red);
        }

        @Override
        public void mouseExited(MouseEvent e) {
            JLabel l = (JLabel) e.getComponent();
            l.setBackground(new Color(3, 57, 103));
        }
    };
    
    private static FocusListener flSearchTextField = new FocusListener() {
        @Override
        public void focusGained(FocusEvent e) {
            JTextField text = (JTextField) e.getComponent();
            if(text.getText().equals("Buscar...")){
                text.setForeground(Color.black);
                text.setText("");
            }
        }

        @Override
        public void focusLost(FocusEvent e) {
            JTextField text = (JTextField) e.getComponent();
            if(text.getText().isEmpty()){
                text.setForeground(new Color(180, 180, 180));
                text.setText("Buscar...");
            }
        }
    };
    private static FocusListener flPlaceHolderEffect = new FocusListener() {
        String placeHolder;
        @Override
        public void focusGained(FocusEvent e) {
            JTextField text = (JTextField) e.getComponent();
            if(text.getForeground().equals(new Color(180, 180, 180))){
                placeHolder = text.getText();
                text.setText("");
                text.setForeground(Color.black);
            }
        }

        @Override
        public void focusLost(FocusEvent e) {
            JTextField text = (JTextField) e.getComponent();
            if(text.getForeground().equals(Color.black) && text.getText().isEmpty()){
                text.setText(placeHolder);
                text.setForeground(new Color(180, 180, 180));
            }
        }
    };
    
    public static void EditarTableHeader(JTable Tabla){
        Tabla.getTableHeader().setFont(new Font("Roboto", Font.BOLD, 22));
    }

    public static int IniciarSesion(String Nombre, String Contrasena) {
        UsuarioJpaController usuarioJpaController = new UsuarioJpaController(Conection.CreateEntityManager());
        List<Usuario> usuarios = usuarioJpaController.findUsuarioEntities();
        Usuario user = new Usuario();
        usuarios.forEach((usuario) -> {
            System.out.println(usuario.getNombre());
            if (usuario.getNombre().equals(Nombre)) {
                user.setNombre(usuario.getNombre());
                
                if (Security.validatePassword(Contrasena, usuario.getContrasena())) {
                    
                    user.setUsuarioID(usuario.getUsuarioID());
                    user.setContrasena(usuario.getContrasena());
                    user.setEstado(usuario.getEstado());
                    
                }
                
            }
        });

        if (user.getNombre() != null) {
            
            if (user.getContrasena() != null) {
                
                if(user.getEstado() == 1){
                    return user.getUsuarioID();
                }else{
                    return -2;
                }
                
            } else {
                
                return 0;
                
            }
        }
        return -1;
    }
    public static void setUsuarioActual(int UsuarioID, String Nombre){
        UsuarioActual[0] = UsuarioID;
        UsuarioActual[1] = Nombre;
    }
    public static Object[] getUsuarioActual(){
        return UsuarioActual;
    }

    public static MouseListener getMLButtonClose() {
        return mlButtonClose;
    }
    
    public static MouseListener getMLButtonCloseBlue(){
        return mlButtonCloseBlue;
    }

    public static MouseListener getMLGeneralButton() {
        return mlGeneralButton;
    }
    
    public static MouseListener getMLGrayButton(){
        return mlGrayButton;
    }
    
    public static FocusListener getFLSearchTextField(){
        return flSearchTextField;
    }
    
    public static FocusListener getFLPlaceHolderEfect(){
        return flPlaceHolderEffect;
    }

}

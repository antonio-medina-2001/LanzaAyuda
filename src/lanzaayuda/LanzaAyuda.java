package lanzaayuda;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.io.File;
import java.net.URL;
import javax.help.HelpBroker;
import javax.help.HelpSet;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;

public class LanzaAyuda implements ActionListener, ItemListener {

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });   
    }
    
    public static JMenuBar createMenuBar() 
    {
        // Creamos el menuBar
        JMenuBar menuBar = new JMenuBar();
        
        // Creamos el menu y lo añadimos al menubar
        JMenu menu = new JMenu("Ayuda");
        menu.setMnemonic(KeyEvent.VK_A);
        menu.getAccessibleContext().setAccessibleDescription("Menu donde encontraras informacion sobre AppHotel.");
        menuBar.add(menu);
        
        // Creamos los menuitems y los añadimos al menu
        JMenuItem menuItem = new JMenuItem("Contenido de Ayuda");
        menuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F1, 0));
        menu.add(menuItem);
        
        JMenuItem menuItem2 = new JMenuItem("About");
        menuItem.setMnemonic(KeyEvent.VK_B);
        menu.add(menuItem2);
        
        // Creamos el helpset y helpbroker
        HelpSet hs = obtenFicAyuda();
        HelpBroker hb = hs.createHelpBroker();
        
        // Asociamos el evento  los items
        hb.enableHelpOnButton(menuItem, "general", hs);
        
        
        return menuBar;
    }
    
    public static HelpSet obtenFicAyuda(){
    try 
    {
        ClassLoader cl = LanzaAyuda.class.getClassLoader();
        File file = new File(LanzaAyuda.class.getResource("/JAVAHELP/helpset.hs").getFile());
        URL url = file.toURI().toURL();
        // crea un objeto Helpset
        HelpSet hs = new HelpSet(null,url);
        return hs;
        } catch (Exception ex) {
        JOptionPane.showMessageDialog(null,"Fichero HelpSet no encontrado");
        return null;
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
         
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
           
    }
    
    private static void createAndShowGUI() {
        //Create and set up the window.
        JFrame frame = new JFrame("Ayuda");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Create and set up the content pane.
        LanzaAyuda demo = new LanzaAyuda();
        frame.setJMenuBar(demo.createMenuBar());

        //Display the window.
        frame.setSize(450, 260);
        frame.setVisible(true);
    }
}

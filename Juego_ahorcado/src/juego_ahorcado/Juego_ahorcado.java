
package juego_ahorcado;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;


public class Juego_ahorcado extends JFrame implements ActionListener
{
    private JButton boton_buscar, boton_salir, boton_nuevo;
    private JTextField edt1, edt2;
    private JLabel labl1, lbl2, lbl4, imagenn, imagenn1, imagenn2, imagenn3, imagenn4, imagenn5, imagenn6;
    private String palabra;
    private String []lineas = new String[100];
    public int contador = 0, correctas = 0, intentos = 0;
    private JLabel imagen, imagen2, imagen3, imagen4, imagen5, imagen6;
    
    public Juego_ahorcado()
    {
        super("Hangman Game");
        setLocationRelativeTo(null);
        labl1 = new JLabel("Palabra: ");
        labl1.setBounds(100, 20, 100, 20);
        lbl2 = new  JLabel("Letra: ");
        lbl2.setBounds(200, 90, 100, 20);
        lbl4 = new  JLabel("");
        lbl4.setBounds(50, 90, 200, 20);
        
        edt1 = new JTextField("");
        edt1.setEditable(false);
        edt1.setBounds(170, 20, 200, 20);
        edt2 = new JTextField("");
        edt2.setBounds(250, 90, 80, 20);
        
        boton_buscar = new JButton("Verificar");
        boton_buscar.setBounds(200, 120, 100, 20);
        
        boton_salir = new JButton("Salir");
        boton_salir.setBounds(200, 200, 100, 20);
        
        boton_nuevo = new JButton("Nueva palabra");
        boton_nuevo.setBounds(200, 160, 100, 20);
        
        boton_salir.addActionListener(this);
        boton_buscar.addActionListener(this);
        boton_nuevo.addActionListener(this);
        
        Icon imagenInicio = new ImageIcon("0.png");
        imagenn = new JLabel(imagenInicio);
        imagenn.setBounds(30, 110, 160, 130);
        
        Icon imagen1 = new ImageIcon("6.jpg");
        imagenn1 = new JLabel(imagen1);
        imagenn1.setBounds(30, 110, 160, 130);
        
        Icon imagen2 = new ImageIcon("5.jpg");
        imagenn2 = new JLabel(imagen2);
        imagenn2.setBounds(30, 110, 160, 130);
        
        Icon imagen3 = new ImageIcon("4.jpg");
        imagenn3 = new JLabel(imagen3);
        imagenn3.setBounds(30, 110, 160, 130);
        
        Icon imagen4 = new ImageIcon("3.jpg");
        imagenn4 = new JLabel(imagen4);
        imagenn4.setBounds(30, 110, 160, 130);
        
        Icon imagen5 = new ImageIcon("2.jpg");
        imagenn5 = new JLabel(imagen5);
        imagenn5.setBounds(30, 110, 160, 130);
        
        Icon imagen6 = new ImageIcon("1.jpg");
        imagenn6 = new JLabel(imagen6);
        imagenn6.setBounds(30, 110, 160, 130);
        
        imagenes();
        crearPalabra();
        
        getContentPane().add(labl1);
        getContentPane().add(lbl2);
        getContentPane().add(lbl4);
        getContentPane().add(edt1);
        getContentPane().add(edt2);
        getContentPane().add(boton_salir);
        getContentPane().add(boton_buscar);
        getContentPane().add(boton_nuevo);
        
        getContentPane().setLayout(null);
        setSize(400, 350);
        setVisible(true);
        
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    
    private void crearPalabra()
    {
        String [][] lista={{"television", "ventilador", "refrigerador", "microondas", "congelador", "telefono ", "computadora"},
                                {"playera", "tenis", "zapatos", "pantalon", "blusa", "calzones", "calcetines"},
                                {"mercurio", "venus", "tierra", "marte", "jupiter", "saturno", "namekusein"},
                                {"naranja", "amarillo", "purpura", "negro", "marron", "verde", "magenta"}};
        
        int categoria = (int)(Math.random()*4);
        int pala = (int)(Math.random()*7);
        palabra = lista[categoria][pala];
        if(categoria == 0)
        {
            lbl4.setText("Electronicos");
        }
        if(categoria == 1)
        {
            lbl4.setText("Prendas de vestir");
        }
        if(categoria == 2)
        {
            lbl4.setText("Planetas");
        }
        if(categoria == 3)
        {
            lbl4.setText("Colores");
        }
        
        for(int j=0; j<palabra.length(); j++)
        {
            contador++;
            lineas[j] = "_";
            edt1.setText(edt1.getText()+lineas[j]+" ");
        }
    }
    
    private void imagenes()
    {
        if(intentos == 0)
        {
            imagenn.setVisible(true);
        }
        if(intentos == 1)
        {
            imagenn1.setVisible(true);
        }
        if(intentos == 2)
        {
            imagenn2.setVisible(true);
        }
        if(intentos == 3)
        {
            imagenn3.setVisible(true);
        }
        if(intentos == 4)
        {
            imagenn4.setVisible(true);
        }
        if(intentos == 5)
        {
            imagenn5.setVisible(true);
        }
        if(intentos == 6)
        {
            imagenn6.setVisible(true);
        }
        
        if(intentos == 0)
        {
            getContentPane().add(imagenn);
        }
        if(intentos == 1)
        {
            imagenn.setVisible(false);
            getContentPane().add(imagenn1);
        }
        if(intentos == 2)
        {
            imagenn1.setVisible(false);
            getContentPane().add(imagenn2);
        }
        if(intentos == 3)
        {
            imagenn2.setVisible(false);
            getContentPane().add(imagenn3);
        }
        if(intentos == 4)
        {
            imagenn3.setVisible(false);
            getContentPane().add(imagenn4);
        }
        if(intentos == 5)
        {
            imagenn4.setVisible(false);
            getContentPane().add(imagenn5);
        }
        if(intentos == 6)
        {
            imagenn5.setVisible(false);
            getContentPane().add(imagenn6);
        }
    }


    public static void main(String[] args) 
    {
        Juego_ahorcado x =new Juego_ahorcado();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(e.getSource().equals(boton_salir))
        {
            JOptionPane.showMessageDialog(null, "Gracias por jugar, vuelva pronto.");
            System.exit(0);
        }
        if(e.getSource().equals(boton_buscar))
        {
            char letra = caracter(edt2.getText());
            String letra2 = (edt2.getText());
            String temp = edt1.getText();
            intentos++;
            
            for(int i=0; i<palabra.length(); i++)
            {
                if(letra == palabra.charAt(i))
                {
                    lineas[i]=letra2;
                    correctas++;
                    edt1.setText(null);
                    intentos--;
                    
                    for(int j=0; j<palabra.length(); j++)
                    {
                        edt1.setText(edt1.getText() + lineas[j] + " ");
                    }
                }
            }
        }
        imagenes();
        
        if(correctas == contador)
        {
            JOptionPane.showMessageDialog(null, "Felicidades, has ganado.");
            edt2.setEditable(true);
            imagenn.setVisible(true);
        }
        if(intentos == 6)
        {
            JOptionPane.showMessageDialog(null, "Lastima, has perdido. ");
            edt2.setEditable(true);
        }
        edt2.setText(null);
        
        if(e.getSource().equals(boton_nuevo))
        {
            edt1.setText(null);
            contador = 0;
            crearPalabra();
            intentos = 0;
            correctas = 0;
            edt2.setEnabled(true);
            
            imagenn.setVisible(true);
            imagenn1.setVisible(true);
            imagenn2.setVisible(true);
            imagenn3.setVisible(true);
            imagenn4.setVisible(true);
            imagenn5.setVisible(true);
            imagenn6.setVisible(true);
        }
    }
    
    private char caracter(String text)
    {
        return text.charAt(0);
    }
}

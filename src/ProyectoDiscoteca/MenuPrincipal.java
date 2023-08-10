package ProyectoDiscoteca;

import java.io.File;
import java.util.List;
import java.util.Scanner;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;

/* MENU PRINCIPAL----------------------------------------------------------------------------------
    metodo que inicia el menu con las opciones a elegir por el usuario
    JOptionPane como herramienta para visualizar fuera de la consola
    La variable opcion es para que se respete el orden de las opcion dadas al usuario (0,1,2) *
    * crear,iniciar,salir. lo mismo el switch
    Agregué un icono para el menu principal con ImageIcon*/
    /* SE ACCEDE AL MENU PRINCIAL EN EL CUAL SE BRIDAN LAS OPCIONES CREAR USUARIO, INICIAR SESION O SALIR
     * A TRAVES DEL SWITCH EL USUARIO OPTA POR LAS OPCIONES A TRAVES DEL MENU, LINKEADO CON LA VARIABLE OPCION,
     * LA CUAL LEE LA RESPUESTA DEL USUARIO
     */


public class MenuPrincipal {

    public static void menu(File archivoDiscos, File archivoUsuarios, List<Usuario> usuarios, Scanner scan){
       
      
        ImageIcon icon = new ImageIcon(App.class.getResource("/vini2.jpg"));
      
        int opcion = JOptionPane.showOptionDialog(null, "Bienvenido a la Discoteca! Que desea hacer?", "Menu", 1, 3, icon, new Object[]{"Crear usuario", "Iniciar sesión", "Salir"}, null);
      
       opcion = opcion + 1;  //SE SUMA 1 PARA COINCIDIR EL INDICE DE LOS BOTONES CON EL CASE DEL SWITCH

        switch(opcion){
            
            case 1:
                MenuCrearUsuario.crearUsuario(archivoUsuarios, usuarios);
                menu(archivoDiscos, archivoUsuarios, usuarios, scan);
                break;
            
            case 2:
                Usuario usuarioConectado = MenuIniciarSesion.iniciarSesion(usuarios); //Guarda el usuario que inicia como objeto de la clase usuario
                if(usuarioConectado != null){
                    MenuDiscos.menuDiscos(archivoDiscos, archivoUsuarios, usuarios, usuarioConectado, scan);
                } else {
                    JOptionPane.showMessageDialog(null, "No se inicio la sesion");
                    menu(archivoDiscos, archivoUsuarios, usuarios, scan);
                }
                break;
        
            case 3:
                    JOptionPane.showMessageDialog(null, "Gracias por visitar la Disco! vuelva pronto");
                break;
    
        }

        }        

}
    


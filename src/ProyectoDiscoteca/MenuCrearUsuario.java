package ProyectoDiscoteca;

import java.io.File;
import java.util.List;

import javax.swing.JOptionPane;

 /* METODO CREAR USUARIO 
         * SE GUARDAN LAS RESPUESTAS EN LA VARIABLES
         * LUEGO SE AGREGAN AL USUARIO
        */
public class MenuCrearUsuario {

    public static void crearUsuario(File archivoUsuarios, List<Usuario> usuarios){

        JOptionPane.showMessageDialog(null, "*Creando Usuario* --> Elige un nombre");

        String nombre = JOptionPane.showInputDialog("Nombre");

        JOptionPane.showMessageDialog(null, "*Creando Usuario* --> Establece una clave ");
        
        String clave = JOptionPane.showInputDialog("clave");

        // Comprobacion de que no se hayan dejado espacios en blanco ni caracteres especiales
        // de manera que no se agregue a la lista de usuarios
        
        if(nombre.isBlank() || clave.isBlank() ){
            JOptionPane.showMessageDialog(null, "No se admiten espacios en blanco", "Error", 0, null);
            
        } else if (nombre.isEmpty() || clave.isEmpty()){
            JOptionPane.showMessageDialog(null, "No se admiten espacios en blanco", "Error", 0, null);
        }
            else { 
            usuarios.add(new Usuario(nombre, clave));
            JOptionPane.showMessageDialog(null, "Usuario creado!");

            ManejoDeArchivos.grabarUsuarios(archivoUsuarios, usuarios);
        }
         
    } 
    
}

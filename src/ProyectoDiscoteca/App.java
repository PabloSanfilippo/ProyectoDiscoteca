package ProyectoDiscoteca; //paquete 


import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


/* IDEA DEL PROGRAMA:
 * SE TRATA DE UNA APLICACION DE GESTION DE STOCK DE DISCOS, EN LA CUAL PUEDE AGREGARSE LA INFORMACION DE LOS MISMOS,
 * CON LA POSIBILIDAD DE CAMBIAR DATOS O ELIMINAR ELEMENTOS. LA IDEA ES QUE FUNCIONE COMO UN CATALOGO PERSONAL.
 * UTILIZE JOPTIONPANE E IMAGENES PARA DARLE MEJOR ASPECTO A LOS MENUES, ANQUE TAMBIEN SE INTERACTUAN CON LA CONSOLA.
 * 
 */

public class App {
            


    ////////////MAIN////////////////////
    public static void main(String[] args) throws Exception {

        
        //CREA EL ARCHIVO DONDE SE GUARDARAN USUARIOS Y SUS CLAVES

        File archivoUsuarios = new File("src\\archivoUsuarios.txt");

        try {
            boolean archivoUsuariosCreado = archivoUsuarios.createNewFile();
        } catch (IOException e) {
            System.out.println(e);
        }
        
        //CREA EL ARCHIVO DONDE SE GUARDARAN LOS DISCOS

        File archivoDiscos = new File("src\\archivoDiscos.txt");

        boolean archivoDiscosCreado = archivoDiscos.createNewFile();

        // CREA LA LISTA DE USUARIOS
        
        List<Usuario> usuarios = new ArrayList<Usuario>();
        
        
        usuarios = ManejoDeArchivos.llamarArchivoUsuarios(archivoUsuarios); // DE ESTA MANERA SE COPIA LA LISTA DE USUARIOS PROV. A LA LISTA USUARIOS ORIGINAL
    
     
        // SE COMPRUEBA QUE COINCIDA EL NOMBRE DEL USUARIO CON EL ID DEL DISCO. EN ESE CASO SE SETEA EL DISCO AL USUARIO CORRESPONDIENTE
    
        for(Disco disco : ManejoDeArchivos.leerArchivoDisco(archivoDiscos)){
            for (Usuario usuario : usuarios){
                if (disco.getId().equals(usuario.getNombre())){
                    usuario.setDisco(disco);
    
                }
            }
        } 
        

        Scanner scan = new Scanner(System.in);
    
        MenuPrincipal.menu(archivoDiscos, archivoUsuarios, usuarios, scan);
    }
 }

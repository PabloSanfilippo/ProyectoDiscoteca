package ProyectoDiscoteca;

import java.io.File;
import java.util.List;
import java.util.Scanner;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/* MENU DISCOS
     * SE SUMA 1 A LA OPCION DEL USUARIO PARA COINCIDIR CON EL CASE DEL SWITCH
     * BOTONES: AGREGAR, MODIFICAR, ELIMINAR LISTAR Y CERRAR SESION.
     */
    
public class MenuDiscos {

    public static void menuDiscos(File archivoDiscos, File archivoUsuarios, List<Usuario> usuarios, Usuario usuarioConectado, Scanner scan){

        ImageIcon menuDiscosIcon = new ImageIcon(App.class.getResource("/menudiscosicon.png"));

        int opcionMenuDiscos = JOptionPane.showOptionDialog(null, "La discoteca de " + usuarioConectado.getNombre(), "Menu Discos", 1, 3, menuDiscosIcon, new Object[] {"Agregar Disco", " Modificar Disco", "Eliminar Disco", "Listar Discos", "Cerrar Sesion"}, null );

        if (opcionMenuDiscos != -1){
            opcionMenuDiscos = opcionMenuDiscos + 1;
        }
        
        switch (opcionMenuDiscos){
            
            case 1:
                agregarDisco(archivoDiscos, archivoUsuarios, usuarios, usuarioConectado, scan);
                break;
            case 2:
                modificarDisco(archivoDiscos, archivoUsuarios, usuarios, usuarioConectado, scan);
                break;
            case 3:
                eliminarDisco(archivoDiscos, archivoUsuarios, usuarios, usuarioConectado, scan);
                menuDiscos(archivoDiscos, archivoUsuarios, usuarios, usuarioConectado, scan);
                break;
            case 4:
                //LLAMA AL METODO CREADO EN LA CLASE USUARIO
                usuarioConectado.listardiscos();
                menuDiscos(archivoDiscos, archivoUsuarios, usuarios, usuarioConectado, scan);
                break;
            case 5:
                JOptionPane.showMessageDialog(null,"Gracias " + usuarioConectado.getNombre());
                MenuPrincipal.menu(archivoDiscos, archivoUsuarios, usuarios, scan);
                usuarioConectado = null;
                break;

        }
    
    }

    //AGREGAR DISCO OPCION 


    public static void agregarDisco(File archivoDiscos, File archivoUsuarios, List<Usuario> usuarios, Usuario usuarioConectado, Scanner scan){
        //guardo las respuestas del usuario en variables para luego enviarlas al disco
        String tituloDisco = JOptionPane.showInputDialog("Ingrese el titulo");

        String artistaDisco = JOptionPane.showInputDialog("Ingrese el artista");

        String fechaDisco = JOptionPane.showInputDialog("Ingrese año de publicacion");

        String generoDisco = JOptionPane.showInputDialog("Ingrese el género");

        String cantidadEnStockDisco = JOptionPane.showInputDialog("Ingrese la cantidad de ejemplares");

        String estadoDisco = JOptionPane.showInputDialog("Ingrese el estado");

        String valorDisco = JOptionPane.showInputDialog("Ingrese el valor");



        // el usuario que inicio sesion agrega un disco informando los datos que se le pide y se crea el disco en la lista. Al final, se obtiene el nombre del usuario conectado
        usuarioConectado.setDisco(new Disco(tituloDisco, artistaDisco, fechaDisco, generoDisco, usuarioConectado.getNombre(), cantidadEnStockDisco, estadoDisco, valorDisco));

        ManejoDeArchivos.guardarDisco(archivoDiscos, usuarios);

        JOptionPane.showMessageDialog(null, "Disco agregado!", null, 1);
        
        //una vez agregado, se muestra el mensaje y se vuelve al menu anterior
        menuDiscos(archivoDiscos, archivoUsuarios, usuarios, usuarioConectado, scan);

    }

    /* MENU ELIMINAR DISCO
     * 
     * Se reparte entre el JOPTION y la consola para interactuar con el usuario, solicitandole al mismo que indique
     * el n° id del disco que desea eliminar. El mismo se obtiene del menu LISTAR DISCOS.
     * Se le consulta previamente si esta seguro, a traves de un if se ejecuta o no la condicion. y vuelve 
     * al Menu Discos.
     */
   public static void eliminarDisco(File archivoDiscos, File archivoUsuarios, List<Usuario> usuarios, Usuario usuarioConectado, Scanner scan){
        JOptionPane.showMessageDialog(null, "Ingrese en la consola el Id del Disco que desea eliminar");
        System.out.println("Ingrese aquí el Id del disco que desea eliminar");

        int indice = scan.nextInt();
        scan.nextLine();

        int seguro = JOptionPane.showConfirmDialog(null, "Seguro desea borrar el Disco?");
        if(seguro == 0){
            usuarioConectado.getDiscos().remove(indice);
            ManejoDeArchivos.guardarDisco(archivoDiscos, usuarios);
            JOptionPane.showMessageDialog(null, "el disco ha sido borrado");    
        }
        else {
            menuDiscos(archivoDiscos, archivoUsuarios, usuarios, usuarioConectado, scan);
        } 
        
   }
   /* MENU MODIFICAR DISCOS 
    * C
    ontinua con la logica e interfaz del menu Discos. Se brindan varias opciones, limitada, para no tener
    que realizar validaciones.
   */
    
   public static void modificarDisco(File archivoDiscos,File archivoUsuarios, List<Usuario> usuarios, Usuario usuarioConectado, Scanner scan){
        
        ImageIcon menuDiscosIcon = new ImageIcon(App.class.getResource("/menudiscosicon.png"));
        
        //JOptionPane.showMessageDialog(null, "Ingrese en la consola el Id del Disco que desea modificar");
        //System.out.println("Ingrese aquí el Id del disco que desea modificar");
        //Se pide al usuario que ingrese el Id por consola

        int indice;
        indice = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el ID del Disco que desea modificar"));
        
        //int indice = scan.nextInt();
        //scan.nextLine();
       int opcionModificarDiscos;
       opcionModificarDiscos = JOptionPane.showOptionDialog(null, "La discoteca de " + usuarioConectado.getNombre(), "Modificar Discos", 1, 3, menuDiscosIcon, new Object[] {"Modificar Titulo", " Modificar Artista", "Modificar Año", "Modificar Género", "modificar Stock", "Modificar Estado", "Modificar Valor", "Volver"}, null );

       // Se agrega +1 a la respuesta para que coincida con los Id 
       opcionModificarDiscos = opcionModificarDiscos + 1;

       // Se brindan las opciones, seguido de la notificacion de modificacion exitosa, y la vuelta al menu anterior
       switch(opcionModificarDiscos){
            
            case 1 :
                String nuevoTitulo = JOptionPane.showInputDialog("Ingrese el nuevo Título: ");
                usuarioConectado.getDiscos().get(indice).setTitulo(nuevoTitulo);
                JOptionPane.showMessageDialog(null, "Título modificado!");
                menuDiscos(archivoDiscos, archivoUsuarios, usuarios, usuarioConectado, scan);
                break;
            
            case 2 :
                String nuevoArtista = JOptionPane.showInputDialog("Ingrese el nuevo Artista: ");
                usuarioConectado.getDiscos().get(indice).setArtista(nuevoArtista);
                JOptionPane.showMessageDialog(null, "Artista modificado!");
                menuDiscos(archivoDiscos, archivoUsuarios, usuarios, usuarioConectado, scan);
                break;
            
            case 3 :
                String nuevoAnio = JOptionPane.showInputDialog("Ingrese el nuevo Año: ");
                usuarioConectado.getDiscos().get(indice).setFechaDePublicacion(nuevoAnio);
                JOptionPane.showMessageDialog(null, "Año modificado!");
                menuDiscos(archivoDiscos, archivoUsuarios, usuarios, usuarioConectado, scan);
                break;
            
            case 4 :
                String nuevoGenero = JOptionPane.showInputDialog("Ingrese el nuevo Género: ");
                usuarioConectado.getDiscos().get(indice).setGenero(nuevoGenero);
                JOptionPane.showMessageDialog(null, "Género modificado!");
                menuDiscos(archivoDiscos, archivoUsuarios, usuarios, usuarioConectado, scan);
                break;
            
            case 5 :
                String nuevoStock = JOptionPane.showInputDialog("Ingrese el nuevo Stock: ");
                usuarioConectado.getDiscos().get(indice).setCantidadEnStock(nuevoStock);
                JOptionPane.showMessageDialog(null, "Stock modificado!");
                menuDiscos(archivoDiscos, archivoUsuarios, usuarios, usuarioConectado, scan);
                break;

            case 6 :
                String nuevoEstado = JOptionPane.showInputDialog("Ingrese el nuevo Estado: ");
                usuarioConectado.getDiscos().get(indice).setEstado(nuevoEstado);
                JOptionPane.showMessageDialog(null, "Estado modificado!");
                menuDiscos(archivoDiscos, archivoUsuarios, usuarios, usuarioConectado, scan);
                break;

            case 7 :
                String nuevoValor = JOptionPane.showInputDialog("Ingrese el nuevo Valor: ");
                usuarioConectado.getDiscos().get(indice).setValor(nuevoValor);
                JOptionPane.showMessageDialog(null, "Valor modificado!");
                menuDiscos(archivoDiscos, archivoUsuarios, usuarios, usuarioConectado, scan);
                break;

            case 8: // corresponde al boton "Volver"
                menuDiscos(archivoDiscos, archivoUsuarios, usuarios, usuarioConectado, scan);
                break;

       } ManejoDeArchivos.guardarDisco(archivoDiscos, usuarios);
        
       }
    
}

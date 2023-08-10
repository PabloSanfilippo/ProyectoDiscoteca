package ProyectoDiscoteca;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ManejoDeArchivos {

    public static void grabarUsuarios(File archivoUsuarios, List<Usuario> usuarios){
        try{ 
        FileWriter escribirArchivoUsuario = new FileWriter(archivoUsuarios);

       for(Usuario usuario : usuarios){
                escribirArchivoUsuario.write(usuario.getNombre() + "," + usuario.getClave() + "\n");
         } escribirArchivoUsuario.close();
            
         } catch(IOException e){
            System.out.println(e);
         }

    }

    /* METODO LECTURA DE ARCHIVO
     * EL METODO TRABAJA SOBRE LA LISTA DE USUARIOS Y EL ARCHIVO DONDE SE ENCUENTRAN ESCRITOS
     * SE CREA UNA LISTA PROVISORIA, LA CUAL SERA COPIADA A LA LISTA DE USUARIOS
     * PARA ELLO SE CREA UN ARREGLO QUE CONTENDRA LOS DATOS DE LOS USUARIOS, OBTENIDOS A TRAVES DEL SCANER
     * CON EL METODO SPLIT, PARA SEPARARLOS
     * LA FUNCION RETORNA LA LISTA PROVISORIA
     */

    public static List<Usuario> llamarArchivoUsuarios(File archivoUsuarios){
        List<Usuario> listaProv = new ArrayList<Usuario>();

        String[] atributosUsuarios = new String[2];
        
        try {
            Scanner scan = new Scanner(archivoUsuarios);
            
            while(scan.hasNextLine()){
                String datos = scan.nextLine();
                atributosUsuarios = datos.split(",");

                listaProv.add(new Usuario(atributosUsuarios[0], atributosUsuarios[1]));
            }  scan.close();
            
        } catch (FileNotFoundException e) {
            
            e.printStackTrace();
        } return listaProv;      

    }

    /*  METODO GRABAR DISCO EN ARCHIVO 
     * SIGUE LA MISMA LOGICA QUE LOS USUARIOS, SALVO QUE LOS DISCOS SON GUARDADOS PARA CADA USUARIO DE FORMA INDIVIDUAL
     * PARA ELLO SE USA UN DOBLE FOR EACH. PRIMERO SE ITERA LA LISTA DE USUARIOS, Y LUEGO DENTRO DE CADA USUARIO SE
     * ASIGNA EL DISCO CORRESPONDIENTE CON SU INFORMACION
    */
    
    public static void guardarDisco(File archivoDiscos, List<Usuario> usuarios){
    try {    
        FileWriter grabarDiscoArchivo = new FileWriter(archivoDiscos);
        for(Usuario usuario : usuarios){
            for(Disco disco : usuario.getDiscos()){
                grabarDiscoArchivo.write(disco.getTitulo() + ";" + disco.getArtista() + ";" + disco.getFechaDePublicacion() + ";" + disco.getGenero() + ";" + usuario.getNombre() + ";" + disco.getCantidadEnStock() + ";" + disco.getEstado() + ";" + disco.getValor() + "\n");
            }
        } grabarDiscoArchivo.close();
    } catch(IOException e){
        System.out.println(e);
         }
    }

    /*  METODO DE LECTURA DE ARCHIVO CON LISTA DE DISCOS 
     * SIGUE LA LOGICA DE USUARIOS
    */
    

    public static List<Disco> leerArchivoDisco (File archivoDiscos){
        List<Disco> listaProvDiscos = new ArrayList<Disco>();
        String [] atributosDiscos = new String [8];

        try{
            Scanner scaner = new Scanner(archivoDiscos);
            while(scaner.hasNextLine()){
                String datosDiscos = scaner.nextLine();
                atributosDiscos = datosDiscos.split(";");
                
                listaProvDiscos.add(new Disco(atributosDiscos[0], atributosDiscos[1], atributosDiscos[2], atributosDiscos[3], atributosDiscos[4], atributosDiscos[5], atributosDiscos[6], atributosDiscos[7]));

            } scaner.close();
        } catch (FileNotFoundException e) {
            System.out.println(e);
        } return listaProvDiscos;

    }
    
}

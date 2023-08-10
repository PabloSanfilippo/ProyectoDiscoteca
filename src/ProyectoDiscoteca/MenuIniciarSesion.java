package ProyectoDiscoteca;

import java.util.List;
import javax.swing.JOptionPane;

public class MenuIniciarSesion {

    public static Usuario iniciarSesion(List<Usuario> usuarios){
        
        JOptionPane.showMessageDialog(null, "INICIO DE SESION");
        
        String nombre = JOptionPane.showInputDialog("nombre");
        
        String clave = JOptionPane.showInputDialog("clave");
    
        //ITERACION DE LA LISTA USUARIOS PARA COMPROBAR SI YA EXISTE, A TRAVES DEL METODO EQUALS.
        int index = -1;
        
        for(int i = 0; i < usuarios.size(); i++){
            if(usuarios.get(i).getNombre().equals(nombre)){
                  index = i;
            }
        }
        
        // SI NO ENCUENTRA NINGUN NOMBRE QUE COINCIDA, RETORNA NULL. USUARIO NO ENCONTRADO
        if(index == -1){
            JOptionPane.showMessageDialog(null, "usuario no encontrado");
            return null;
    
        } else {
            // SI COINCIDE EL NOMBRE, BUSCA CON EL GET DEL USUARIO SI COINCIDE LA CLAVE CON EQUALS E INICIA SESION
            if(usuarios.get(index).getClave().equals(clave)){
                JOptionPane.showMessageDialog(null, "Sesion iniciada a nombre de : " + nombre);
                return usuarios.get(index);
    
            // DE LO CONTRARIO, MUESTRA CLAVE INCORRECTA
            } else {
                JOptionPane.showMessageDialog(null, "Clave incorrecta");
                return null;
                
            } 
        }   
               
    }
    
}

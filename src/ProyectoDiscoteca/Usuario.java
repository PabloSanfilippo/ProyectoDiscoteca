package ProyectoDiscoteca;


import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;


public class Usuario {
ImageIcon listarIcon = new ImageIcon(Usuario.class.getResource("/listarDiscosIcon.png"));
    
    private String nombre;
    private String clave;
    private List<Disco> discos = new ArrayList<Disco>();

    Usuario(String nombre, String clave){
        this.nombre = nombre;
        this.clave = clave;
    }

    Usuario(String nombre, String clave, List<Disco> discos){
        this.nombre = nombre;
        this.clave = clave;
        this.discos = discos;
    }

    public String getNombre(){
        return nombre;
    }

    public String getClave(){
        return clave;
    }

    public List<Disco> getDiscos() {
        return discos;
    }

    public void setNombre(String nombre){
        this.nombre = nombre;
    }
 
    public void setClave(String clave){
        this.clave = clave;
    }

    public void  setDisco(Disco disco){
        discos.add(disco);
        
    }    
    
    //Listar Discos
    // Con el for itera los elementos y muestra la informacion cargada por el ususario    
    
    public void listardiscos(){
        
        for(int i = 0; i < getDiscos().size(); i++){
        

        System.out.println("id : " + i);
        System.out.println(" Titulo: " + getDiscos().get(i).getTitulo());
        System.out.println(" Artista: " + getDiscos().get(i).getArtista());
        System.out.println(" Año : " + getDiscos().get(i).getFechaDePublicacion());
        System.out.println(" Genero: " + getDiscos().get(i).getGenero());
        System.out.println(" Stock: " + getDiscos().get(i).getCantidadEnStock());
        System.out.println(" Estado: " + getDiscos().get(i).getEstado());
        System.out.println(" Valor: " + getDiscos().get(i).getValor());

        

    /*Fuera del for, se le informa al usuario que los discos se muestra en consola, porque si estuviera dentro del mismo
    se abriria una ventana por vez por cada disco encontrado */
    } 
    JOptionPane.showMessageDialog(null, "La lista de Discos se muestra en Consola!", "Lista", 1, listarIcon);
       
    }

}

package ProyectoDiscoteca;

public class Disco {
    
    private String titulo;
    private String artista;
    private String fechaDePublicacion;
    private String genero;
    private String id;
    private String cantidadEnStock;
    private String estado;
    private String valor;
    

 

    public Disco(String titulo, String artista, String fechaDePublicacion, String genero, String id, String cantidadEnStock, String estado, String valor) {
        this.titulo = titulo;
        this.artista = artista;
        this.fechaDePublicacion = fechaDePublicacion;
        this.genero = genero;
        this.id = id;
        this.cantidadEnStock= cantidadEnStock;
        this.estado = estado;
        this.valor = valor;
        
    }

    
 
    public String getTitulo() {
        return this.titulo;
    }
 
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
 
    public String getArtista() {
        return this.artista;
    }
 
    public void setArtista(String artista) {
        this.artista = artista;
    }
 
    public String getFechaDePublicacion() {
        return this.fechaDePublicacion;
    }
 
    public void setFechaDePublicacion(String fechaDePublicacion) {
        this.fechaDePublicacion = fechaDePublicacion;
    }
 
    public String getGenero() {
        return this.genero;
    }
 
    public void setGenero(String genero) {
        this.genero = genero;
    }
 
    public String getId() {
        return this.id;
    }
 
    public void setId(String id) {
        this.id = id;
    }

    public String getCantidadEnStock(){
        return cantidadEnStock;
    }
    public void setCantidadEnStock(String cantidadEnStock){
        this.cantidadEnStock = cantidadEnStock;
    }

    public String getEstado(){
        return estado;
    }

    public void setEstado(String estado){
        this.estado = estado;
    }
 
    public String getValor(){
        return valor;
    }
    public void setValor(String valor){
        this.valor = valor;
    }


    public void add(Object disco) {
    }
 }
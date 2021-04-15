package PAC_DESARROLLO;

public class Usuario {

    //ATRIBUTOS DE LA CLASE

    private String nombre;
    private int edad;
    private String dni;

    //CONSTRUCTOR VACIO

    public Usuario(){}

    //GETS Y SETS DE LOS ATRIBUTOS

    public String getNombre(){
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getDni() {
        return dni;
    }

    public boolean setDni(String dni){
        if(dni.matches("^[0-9]{8}[a-zA-Z]$")
                || dni.matches("^[0-9]{8}[-][a-zA-Z]$")){
            this.dni=dni;
            return true;
        }
        else{
            return false;
        }
    }
@Override
    public String toString(){
        return "Nombre: " + nombre + "\n" + "Edad: " + edad + "\n" + "Dni: " + dni;
}
}


package PAC_DESARROLLO;

public class Ingreso extends Dinero{

    // CONSTRUCOR DE LA CLASE INGRESO QUE HEREDA LOS ATRIBUTOS DE LA CLASE PADRE DINERO

    public Ingreso(double ingreso, String descripción){
        this.dinero = ingreso;
        this.descripción = descripción;
    }
    @Override
    public String toString(){
        return "-Ingreso con el siguiente concepto: " + this.descripción + "\n" + "-El importe total es: " + this.dinero + " € ";
    }
}

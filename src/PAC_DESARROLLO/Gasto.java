package PAC_DESARROLLO;

public class Gasto extends Dinero{

    // CONSTRUCOR DE LA CLASE GASTO QUE HEREDA LOS ATRIBUTOS DE LA CLASE PADRE DINERO

    public Gasto(double gasto, String descripción){
        this.dinero = gasto;
        this.descripción = descripción;
    }
    @Override
    public String toString(){
        return "-Gasto con el siguiente concepto: :" + this.descripción + "\n" + "-El importe total es: " + this.dinero + " € ";
    }
}



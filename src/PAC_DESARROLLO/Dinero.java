package PAC_DESARROLLO;

abstract class Dinero {

    //ATRIBUTOS DE LA CLASE

    protected double dinero;
    protected String descripción;

    //GETS Y SETS DE LAS ATRUBUTOS DE LA CLASE

public double getDinero(){
        return dinero;
}
public void setDinero(double dinero) {
        this.dinero = dinero;
    }

public String getDescripción() {
        return descripción;
    }

public void setDescripción(String descripción) {
        this.descripción = descripción;
    }
}
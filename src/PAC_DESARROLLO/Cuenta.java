package PAC_DESARROLLO;

import java.util.ArrayList;
import java.util.List;

public class Cuenta {

    //ATRIBUTOS DE LA CLASE

    double saldo;
    Usuario usuario;
    List<Ingreso> ingresos;
    List<Gasto> gastos;

    //CONSTRUCTOR DE LA CLASE CUENTA PARA INICIAR UN USUARIO CON LA CUENTA A CERO

    public Cuenta(Usuario usuario){
        this.usuario = usuario;
        this.saldo = 0;
        this.ingresos = new ArrayList<Ingreso>();
        this.gastos = new ArrayList<Gasto>();
    }

    //GETS Y SETS DE LOS ATRIBUTOS

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public List<Ingreso> getIngresos() {
        return ingresos;
    }

    public List<Gasto> getGastos() {
        return gastos;
    }

        //LISTA DE METODOS

    //Metodo que nos permite crear un nuevo ingreso y agegarlo al ArrayList, ademas de actualizar el saldo general

    public double addIngresos(double cantidad_ingreso,String descripción){
        Ingreso Nw_Ingreso = new Ingreso(cantidad_ingreso,descripción);//Creamos el nuevo ingreso
        this.ingresos.add(Nw_Ingreso);// Lo agregamos a la lista de ingresos
        this.saldo = this.saldo +  cantidad_ingreso; //Le sumamos la cantidad de dinero del ingreso al saldo total
        return saldo;
    }
    public double addGastos(double gasto, String descripción){
        try{
            this.saldo = this.saldo - gasto;
            if(getSaldo()<0){
                throw new GastoException();
            }
        }catch(GastoException ge){
                return -1;
            }
            Gasto Nw_Gasto = new Gasto(gasto,descripción);
            this.gastos.add(Nw_Gasto);
            return gasto;
        }
    @Override

    public String toString(){
        return "El saldo de su cuenta es: " + saldo + " € ";
    }

    }



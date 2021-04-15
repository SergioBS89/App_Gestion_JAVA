package PAC_DESARROLLO;

public class GastoException extends Exception{

    private String error;

    //CONSTRUCTOR DE LA EXCEPCION
    public GastoException() {
        this.error = "Error al intentar agregar el gasto en la cuenta, no tiene suficiente saldo";
    }

    // Sobreescribimos el metodo getMessage
    @Override
    public String getMessage(){
        return error;
    }
}

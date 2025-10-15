package Calculator.src.Main.Java.Data;

public class Result {
    public double result;
    public boolean isError;
    public String errorMessage;

    public Result(Double result, boolean isError, String errorMessage){
        this.result = result;
        this.isError = isError;
        this.errorMessage = errorMessage;
    }
}

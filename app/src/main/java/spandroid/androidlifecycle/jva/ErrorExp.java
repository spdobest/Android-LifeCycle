package spandroid.androidlifecycle.jva;

public class ErrorExp {

    public static void main(String...args){

        ErrorExp errorExp = new ErrorExp();
        errorExp.call();

    }

    private void call(){

        try{

        }
        catch (Exception e){
            e.printStackTrace();
        }
        finally {

        }

    }

}

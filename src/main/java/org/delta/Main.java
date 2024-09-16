package org.delta;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        try{
            App app = new App();
            app.run();
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}
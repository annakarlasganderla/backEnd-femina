package main;

import main.java.com.femina.produto.Model.Cliente;
import main.java.com.femina.produto.View.*;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        MenuView menuView = new MenuView();
        menuView.menuPrincipal();
    }
}

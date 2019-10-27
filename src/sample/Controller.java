package sample;


import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Controller {

    @FXML
    private Button oblicz, reset, save;

    @FXML
    private TextField liczba_uczestnikow;

    @FXML
    private TextArea result;

    @FXML
    private RadioButton rb1, rb2;

    @FXML
    private FileWriter log;

    @FXML
    private BufferedWriter bw;

    @FXML
    private void checkAll(){
        if ((rb1.isSelected()) && (liczba_uczestnikow.getText().length()!=0))
        {
            oblicz.setDisable(false);
        }
        else if(rb2.isSelected() && (liczba_uczestnikow.getText().length()!=0) )
        {
            oblicz.setDisable(false);
        }
        else {
            oblicz.setDisable(true);
        }
    }

    @FXML
    private void klikOblicz(){
        oblicz.setOnAction((evt) -> {
            save.setDisable(false);
            int l_uczestnikow = Integer.parseInt(liczba_uczestnikow.getText());
            int wynik;
            double l_porzadkowych;
            double l_informacyjnych;

            if (rb1.isSelected()) {
                wynik = l_uczestnikow - 300;
                wynik = wynik/100;
                wynik = wynik+10;
                l_porzadkowych = 0.2*wynik;
                l_informacyjnych = wynik - l_porzadkowych;

                System.out.println("--------------------------------------------------------------------------------------------------------------");
                System.out.println("Wybrano imprezę masową niepodwyższonego ryzyka");
                System.out.println("Wprowadzono następującą liczbę uczestników imprezy masowej: "+l_uczestnikow+" os.");
                System.out.println("Liczba osób niezbędnych do zabezpieczenia imprezy masowej wynosi: "+wynik+" os.");
                System.out.println("Liczba służb porządkowych: "+(int)Math.ceil(l_porzadkowych)+" os.");
                System.out.println("Liczba służb informacyjnych: "+(int)(l_informacyjnych)+" os.");

                result.appendText("--------------------------------------------------------------------------------------------------------------");
                result.appendText("\n");
                result.appendText("Wybrano imprezę masową niepodwyższonego ryzyka");
                result.appendText("\n");
                result.appendText("Wprowadzono następującą liczbę uczestników imprezy masowej: "+l_uczestnikow+" os.");
                result.appendText("\n");
                result.appendText("Liczba osób niezbędnych do zabezpieczenia imprezy masowej wynosi: "+wynik+" os.");
                result.appendText("\n");
                result.appendText("Liczba służb porządkowych: "+(int)Math.ceil(l_porzadkowych)+" os.");
                result.appendText("\n");
                result.appendText("Liczba służb informacyjnych: "+(int)(l_informacyjnych)+" os.");
                result.appendText("\n");
            } else if (rb2.isSelected()) {
                wynik = l_uczestnikow - 200;
                wynik = wynik/100;
                wynik = wynik*2;
                wynik = wynik+15;
                l_porzadkowych = 0.5*wynik;
                l_informacyjnych = wynik - l_porzadkowych;

                System.out.println("--------------------------------------------------------------------------------------------------------------");
                System.out.println("Wybrano imprezę masową podwyższonego ryzyka");
                System.out.println("Wprowadzono następującą liczbę uczestników imprezy masowej: "+l_uczestnikow+" os.");
                System.out.println("Liczba osób niezbędnych do zabezpieczenia imprezy masowej wynosi: "+wynik+" os.");
                System.out.println("Liczba służb porządkowych: "+(int)Math.ceil(l_porzadkowych)+" os.");
                System.out.println("Liczba służb informacyjnych: "+(int)(l_informacyjnych)+" os.");

                result.appendText("--------------------------------------------------------------------------------------------------------------");
                result.appendText("\n");
                result.appendText("Wybrano imprezę masową podwyższonego ryzyka");
                result.appendText("\n");
                result.appendText("Wprowadzono następującą liczbę uczestników imprezy masowej: "+l_uczestnikow+" os.");
                result.appendText("\n");
                result.appendText("Liczba osób niezbędnych do zabezpieczenia imprezy masowej wynosi: "+wynik+" os.");
                result.appendText("\n");
                result.appendText("Liczba służb porządkowych: "+(int)Math.ceil(l_porzadkowych)+" os.");
                result.appendText("\n");
                result.appendText("Liczba służb informacyjnych: "+(int)(l_informacyjnych)+" os.");
                result.appendText("\n");
            }
            else{
                System.out.println("Nie wybrano żadnej opcji!");
            }
        });
    }

    @FXML
    private void saveToFile(){
        save.setOnAction((evt) -> {

            try{

                Date date = new Date();
                DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
                DateFormat timeFormat = new SimpleDateFormat("HH-mm-ss");
                DateFormat timeFormat2 = new SimpleDateFormat("HH:mm:ss");

                log = new FileWriter("log-"+dateFormat.format(date)+"-"+timeFormat.format(date)+".txt", true);
                bw = new BufferedWriter(log);

                bw.write("--------------------------------------------------------------------------------------------------------------");
                bw.newLine();
                bw.write("                                      LOG -  KALKULATOR IMPREZ MASOWYCH                                       ");
                bw.newLine();
                bw.write(result.getText());
                bw.newLine();
                bw.write("--------------------------------------------------------------------------------------------------------------");
                bw.newLine();
                bw.write("                Kalkulator Imprez Masowych by Szymon Pęczalski ©2019 "+dateFormat.format(date)+"r. godz. "+timeFormat2.format(date));
                bw.newLine();
                bw.write("--------------------------------------------------------------------------------------------------------------");
                bw.newLine();
                bw.flush();
                bw.close();

                ProcessBuilder ol = new ProcessBuilder("notepad.exe", "log-"+dateFormat.format(date)+"-"+timeFormat.format(date)+".txt");
                ol.start();

            } catch (IOException e) {
                e.printStackTrace();
            }

        });
    }



    @FXML
    private void resetApp() {
        reset.setOnAction((evt) -> {

            oblicz.setDisable(true);
            liczba_uczestnikow.clear();
            result.clear();
            rb1.setSelected(false);
            rb2.setSelected(false);
            save.setDisable(true);

        });
    }
}
package testParsing;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateParser {

    public static Date parseDateTime(String input) {
        // Formato di input: giorno-mese-anno ora:minuto
        SimpleDateFormat inputFormatter = new SimpleDateFormat("dd MMMM yyyy HH:mm");

        try {
            // Estrazione della parte data e ora dalla stringa di input
            String dateTimePart = input.split(" del ")[1].split(" - ")[0];
            Date dateTime = inputFormatter.parse(dateTimePart);
            return dateTime;
        } catch (ParseException e) {
            System.out.println("PARSER FALLITO: " + e.getMessage());
            return null;
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("FORMATO INPUT INCORRETTO: " + e.getMessage());
            return null;
        }
    }

    public static void main(String[] args) {
        String input = "Appuntamento del 27 novembre 2022 09:00 - Riepilogo";
        String input2 = "Appuntamento del 01 marzo 2023 12:00 - Riepilogo";
        Date dateTime = parseDateTime(input2);

        if (dateTime != null) {
            // Formattazione dell'output nel formato desiderato: anno-mese-giorno ora:minuto:secondo.millisec
            SimpleDateFormat outputFormatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
            String formattedDate = outputFormatter.format(dateTime);
            System.out.println("STRINGA FORMATTATA-> "+formattedDate);
        } else {
            System.out.println("Fallito");
        }
    }
}

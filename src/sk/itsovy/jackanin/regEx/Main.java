package sk.itsovy.jackanin.regEx;

import sk.itsovy.data.DataIP;
import sk.itsovy.data.Date;
import sk.itsovy.data.MacAddress;
import sk.itsovy.data.PersonalID;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        checkIPExpressions((List<String>) new DataIP().get());
        System.out.println("----------------------------------");
        checkIDExpression((List<String>) new PersonalID().get());
        System.out.println("----------------------------------");
        checkMACExpression((List<String>) new MacAddress().get());
        System.out.println("----------------------------------");
        checkDateExpression((List<String>) new Date().get());
    }

    public static void checkIPExpressions(List<String> list){
        final String regex = "^(([0-9]|[1-9][0-9]|1[0-9]{2}|2[0-4][0-9]|25[0-5])\\.){3}([0-9]|[1-9][0-9]|1[0-9]{2}|2[0-4][0-9]|25[0-5])$";

        final Pattern pattern = Pattern.compile(regex, Pattern.MULTILINE);
        Matcher matcher;

        for (int i=0; i<list.size(); i++){
            if (list.get(i) != null) {
                matcher = pattern.matcher(list.get(i));

                while (matcher.find()) {
                    System.out.println("Full match: " + matcher.group());
                }
            }
        }
    }

    public static void checkIDExpression(List<String> list){
        final String regex = "^[0-9]{2}[0156][0-9]{3}/?[0-9]{3,4}$";

        final Pattern pattern = Pattern.compile(regex, Pattern.MULTILINE);
        Matcher matcher;

        for (int i=0; i<list.size(); i++){
            if (list.get(i) != null) {
                matcher = pattern.matcher(list.get(i));

                while (matcher.find()) {
                    System.out.println("Full match: " + matcher.group());
                }
            }
        }
    }

    public static void checkMACExpression(List<String> list){
        final String regex = "^([0-9A-Fa-f]{2}[:-]){5}([0-9A-Fa-f]{2})$";

        final Pattern pattern = Pattern.compile(regex, Pattern.MULTILINE);
        Matcher matcher;

        for (int i=0; i<list.size(); i++){
            if (list.get(i) != null) {
                matcher = pattern.matcher(list.get(i));

                while (matcher.find()) {
                    System.out.println("Full match: " + matcher.group());
                }
            }
        }
    }

    public static void checkDateExpression(List<String> list){
        final String regex = "^((([1-9]|[12][0-9]|3[0-1])\\.(1|3|5|7|8|10|12))|(([1-9]|[12][0-9]|30)\\.(4|6|9|11))|(([1-9]|[12][0-9])\\.2))\\.(19|20)[0-9]{2}$";

        final Pattern pattern = Pattern.compile(regex, Pattern.MULTILINE);
        Matcher matcher;

        for (int i=0; i<list.size(); i++){
            if (list.get(i) != null) {
                matcher = pattern.matcher(list.get(i));

                while (matcher.find()) {
                    System.out.println("Full match: " + matcher.group());
                }
            }
        }
    }
}
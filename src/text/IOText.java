package text;

import java.io.*;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by rb on 1/29/16.
 */
public class IOText {
    IOText(){
        File f = new File("input.txt");
    }



    public String outputString(){
        ArrayList<String> sb = new ArrayList<String>();
        String tmp2 = "";
        try{
            BufferedReader br = new BufferedReader(new FileReader("output.txt"));
            String tmp = null;
            while ((tmp = br.readLine()) != null){
               sb.add(tmp);
            }
            br.close();
            tmp2 = Decorator(sb);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Text imported!");
        return tmp2;
    }

    public void inputString(String text){
        FileWriter fw = null;
        try{
            fw = new FileWriter("input.txt");

        } catch (IOException e) {
            e.printStackTrace();
        }
        BufferedWriter bw = new BufferedWriter(fw);
        PrintWriter pw = new PrintWriter(bw);
        pw.print(text);
        pw.close();
        System.out.println("Text exported! ");
    }

    private String Decorator(ArrayList<String> list){
        ArrayList<String> listOfWords = new ArrayList<String>();
        String resultString = "";
        Pattern p = Pattern.compile("[\\.|,|:|-|—]|[A-Za-z+’a-z+]+|[A-Za-z]+");
        for (String str : list){
            Matcher m1 = p.matcher(str);
            while (m1.find()) {
                listOfWords.add(m1.group());
            }
        }
        for(String str : listOfWords){
            if (str.equals(".")|str.equals(",")|str.equals(";")|str.equals(":")|str.equals("!")|str.equals("?")){
                resultString = resultString + str;
            } else resultString = resultString + " " + str;
        }

        return resultString.trim();
    }

}

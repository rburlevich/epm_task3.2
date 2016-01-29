package text;

public class MainClass {
	public static void main(String args[]){

        IOText iotext = new IOText();
        String someText = iotext.outputString();

		Text text = new Text(someText); // Creating of text

		text.printText(); // Displaying of text
		text.printSentences();
		text.test1();
		text.printSentences();
        System.out.println("REPEATED WORDS --->"+text.findWords());
        iotext.inputString(text.getText());

	}

}

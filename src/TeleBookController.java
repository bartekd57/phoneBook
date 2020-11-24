import java.util.List;
import java.util.Scanner;

public class TeleBookController {

    Scanner scan = new Scanner(System.in);
    TeleBook tb = new TeleBook();


    public void mainLoop() {
        boolean flag = true;
        while (flag) {
            Options yourOption = getYourOption();

            switch (yourOption) {
                case ADD_CONTACT:
                    String name = getName();
                    String number = getNumber();
                    tb.addContact(name, number);
                    break;
                case SEARCH_BY_NAME:
                    String nameSearched = getName();
                    List<Contact> contactByName = tb.findContactByName(nameSearched);
                    printList(contactByName);
                    break;
                case SEARCH_BY_TEL:
                    String numberSearched = getNumber();
                    List<Contact> contactByNumber = tb.findContactByNumber(numberSearched);
                    printList(contactByNumber);
                    break;
                case DELETE:
                    String nameToRemove = getName();
                    tb.removeContact(nameToRemove);
                    break;
                case EXIT:
                    return;
            }
        }
    }


    public void printOptions() {
        Options[] values = Options.values();
        System.out.println(">>>Opcje:");
        for (Options value : values) {
            System.out.println(value);
        }
    }

    public Options getYourOption() {
        int option;
        printOptions();
        option = scan.nextInt();
        scan.nextLine();
        Options optionEnum = Options.optionFromId(option);
        return optionEnum;

    }

    private String getName() {
        System.out.println("podaj imie/nazwisko ");
        return scan.nextLine();
    }

    private String getNumber() {
        System.out.println("podaj numer");
        return scan.nextLine();
    }
    public void printList(List<Contact> list){
        for (Contact contact : list) {
            System.out.println(contact);
        }
    }

}

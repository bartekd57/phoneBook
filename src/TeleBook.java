import javax.swing.*;
import java.util.*;
import java.util.concurrent.ConcurrentNavigableMap;

public class TeleBook {


    Map<String, Contact> contactBook = new HashMap<>();


    public boolean addContact(String name, String number) {
        if (name == null || number == null)
            throw new IllegalArgumentException("name and telephone cannot be null");
        if (name.isEmpty() || number.isEmpty())
            throw new IllegalArgumentException("name and telephone cannot be empty");
        if (!contactBook.containsKey(name)) {
            contactBook.put(name, new Contact(name, number));
            return true;
        } else
            return false;
    }

    public boolean removeContact(String name) {
        return contactBook.remove(name)!= null;
    }

    public List<Contact> findContactByName(String name) {
        ArrayList<Contact> listByNames = new ArrayList<>();
        Set<String> nameKeys = contactBook.keySet();
        for (String nameKey : nameKeys) {
            if (nameKey.toLowerCase().contains(name.toLowerCase())) {
                listByNames.add(contactBook.get(nameKey));
            }
        }
        return listByNames;
    }

    public List<Contact> findContactByNumber(String number) {
        ArrayList<Contact> listByNumbers = new ArrayList<>();
        Collection<Contact> values = contactBook.values();
        for (Contact value : values) {
            if (value.getNumber().contains(number)) {
                listByNumbers.add(value);
            }
        }
        return listByNumbers;
    }


}

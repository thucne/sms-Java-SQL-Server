package schoool.management.system.Tool_Group;

public class Password_To_String {

    public static String convert(char[] chars) {
        char[] passwordTemp = chars;
        Character[] characters = new Character[passwordTemp.length];
        StringBuilder password = new StringBuilder();

        for (int i = 0; i < passwordTemp.length; i++){
            characters[i] = passwordTemp[i];
        }

        for (Character c: characters){
            password.append(c.toString());
        }
        return password.toString();
    }
}

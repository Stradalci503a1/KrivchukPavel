public class Formatter {

    public static String build(String formatString, Object... arguments){
        if (formatString == null){
            return null;
        }

        StringBuilder formatedString = new StringBuilder().append(formatString);
        for(int i = 0;;){

            int openingBracketPosition = formatedString.indexOf("{", i);
            int closingBracketPosition = formatedString.indexOf("}", openingBracketPosition);
            
            if (openingBracketPosition < 0 || closingBracketPosition < 0){
                break;
            }

            try{
                int number = Integer.parseInt(formatedString.substring(openingBracketPosition + 1, closingBracketPosition));
                formatedString.replace(openingBracketPosition, closingBracketPosition + 1, arguments[number].toString());
            }
            catch (NumberFormatException e){
                i = openingBracketPosition + 1;
            }
            catch (ArrayIndexOutOfBoundsException e){
                return null;
            }
        }

        return formatedString.toString();
    }
}

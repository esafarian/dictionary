import java.util.ArrayList;

public class WordDef {

private String word;
private String definition;
ArrayList<WordDef> dictionary = new ArrayList<WordDef>();

public WordDef  (String w, String def) {
this.word = w;
this.definition = def;
}

public String getWord() {
return word;
}
public String getDefinition() {
return definition;
}

public void setWord(String w) {
word = w;
}
public void setDefinition(String def) {
definition = def;
}

public String toString() {

return word + "\t" + definition;

}





}





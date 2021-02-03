public class TextLine implements Comparable<TextLine>{
    int lineNum;
    String text;

    public TextLine(String s) {
        String divide[] = s.split(" ", 2);
        lineNum = Integer.parseInt(divide[0]);
        if(divide.length < 2)
            text = null;
        else
            text = divide[1];
    }
    public int getLineNum() {
        return this.lineNum;
    }
    public String getText() {
        return this.text;
    }
    public void setLineNum(int val) {
        lineNum = val;
    }
    public void setText(String val) {
        text = val;
    }
    public String toString() {
        return lineNum + " " + text + "\n";
    }
    public int compareTo(TextLine s1) {
        if(this.lineNum > s1.lineNum)
            return 1;
        if(this.lineNum < s1.lineNum)
            return -1;
        else
            return 0;
    }
}

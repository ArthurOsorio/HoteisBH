package hoteisBH;

import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import javax.swing.text.DocumentFilter;

public class FiltroNum extends DocumentFilter{
	private int length;
	public FiltroNum(int length) {
		this.length=length;
	}
	private boolean teste(String text) {
		try {
			Long.parseLong(text);
			return true;
		}catch(NumberFormatException nfe) {
			return false;
		}
	}
	@Override
	public void insertString(FilterBypass fb, int offset, String string, AttributeSet atrr) throws BadLocationException{
		Document doc = fb.getDocument();
		StringBuilder sb = new StringBuilder();
		sb.append(doc.getText(0, doc.getLength()));
		sb.insert(offset,string);
		if(teste(sb.toString()) && sb.length()<=this.length) {
			super.insertString(fb, offset, string, atrr);
		}else {
			System.out.println("Insira apenas numeros.");
		}
	}
	@Override
	public void replace(FilterBypass fb, int offset,int length, String string, AttributeSet atrr) throws BadLocationException{
		Document doc = fb.getDocument();
		StringBuilder sb = new StringBuilder();
		sb.append(doc.getText(0, doc.getLength()));
		sb.replace(offset,offset + length,string);
		if(teste(sb.toString())&& sb.length()<=this.length) {
			super.replace(fb, offset,length, string, atrr);
		}else {
			System.out.println("Insira apenas numeros.");
		}
	}
	@Override
	public void remove(FilterBypass fb, int offset, int length) throws BadLocationException{
		Document doc = fb.getDocument();
		StringBuilder sb = new StringBuilder();
		sb.append(doc.getText(0, doc.getLength()));
		sb.delete(offset,offset + length);
		if(sb.toString().length() == 0) {
			super.replace(fb, offset, length, "", null); 	    	 	  
			}
		else if(teste(sb.toString())&& sb.length()<=this.length) {
			super.remove(fb, offset, length);
		}else {
			System.out.println("Insira apenas numeros.");
		}
	}

}

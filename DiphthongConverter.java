import java.util.*;
import java.io.*;

class DiphthongConverter {
	protected static Properties Diphthongs = new Properties();  // Diphthong names w/ spellings
	protected static Properties Spellings = new Properties();  // Spellings w/ diphthong names
	protected boolean loadDiphthongs(String file) {
    try {
      FileInputStream d_prop  = new FileInputStream(file);
      Diphthongs.load(d_prop);
    }
    catch (FileNotFoundException e) {
      System.err.println(e.getMessage() + "\nThe stack trace is:");
      e.printStackTrace();
    }
    catch (IOException e) {
      System.err.println(e.getMessage() + "\nThe stack trace is:");
      e.printStackTrace();
    }
    return true;
  }
	public static void main(String argv[]) {
		// Load properties file
		DiphthongConverter dc = new DiphthongConverter();

		if (argv.length > 0) {
			dc.loadDiphthongs(argv[1]);
		}
		else {
			dc.loadDiphthongs("diphthong.properties");
		}

		// Step through properties file
		Enumeration keys; // generic for getting property names
    keys = Diphthongs.propertyNames(); 	

		// For each diphthong in the file:
		String diph_spellings = "";
		String currSpelling = "";
		String currDiph = "";
		while (keys.hasMoreElements()) {
			// Store curr diphthong so we can add into other table
			currDiph = (String)keys.nextElement();
			diph_spellings = (String)Diphthongs.getProperty(currDiph);
//System.out.println("======================> currDiph = " + currDiph + "\ndiph_spellings = " + diph_spellings + "\n");
			StringTokenizer st = new StringTokenizer(diph_spellings, ","); // spellings separated w/ ","
			// While there are more spellings of this diphthong 
	    while (st.hasMoreElements()) {
				currSpelling = (String)st.nextElement();
//System.out.println("got here 7");
//System.out.println("currSpelling = " + currSpelling + "\n");
				// If the entry exists

				StringBuffer temp; 
				String temp2;
				temp2 = Spellings.getProperty(currSpelling);

				if (temp2 != null) {
//System.out.println("got here 1");
					temp = new StringBuffer(Spellings.getProperty(currSpelling));
					// Remove old association
//System.out.println("got here 2");
					Spellings.remove(currSpelling);
					// Append on to current string
//System.out.println("got here 3");
					temp.append("," + currDiph);
					// Replace old association with new spelling
//System.out.println("got here 4");
					Spellings.put(currSpelling, temp.toString());
				}
				else {
//System.out.println("new entry:");
//System.out.println("currSpelling = " + currSpelling + "\n");
//System.out.println("currDiph = " + currDiph + "\n");
					// Create the HashTable entry
				  Spellings.put(currSpelling, currDiph);	
//System.out.println("got here 5");
				}
			}
		}
		// Step through properties file
		Enumeration keys2; // generic for getting property names
		keys2 = Spellings.propertyNames(); 	
		while (keys2.hasMoreElements()) {
			String key3 = (String)keys2.nextElement();
			System.out.println(key3 + "=" + Spellings.getProperty(key3) + "\n");
		}
	}
}

// Ternary Tree implementation

import java.util.*;
import java.io.*;

	class TernaryNode { 
		char splitchar;
     TernaryLeaf lokid;
     TernaryLeaf eqkid;
     TernaryLeaf hikid;
   }

   class TernaryLeaf extends TernaryNode {
     String s;
   }

public class TernaryTree {

   public synchronized void insert(String s) {
     s = s + "\0";  // This data structure relies on a sentinel to term. str.s
		 insertstr = new String(s);
     root = insert1(root, s);
   }

	protected String insertstr;

  private synchronized TernaryLeaf insert1(TernaryLeaf p, String s) {
    if (p == null) {
      p = new TernaryLeaf();
      p.splitchar = s.charAt(0);
      p.lokid = p.eqkid = p.hikid = null;
    }
    if (s.charAt(0) < p.splitchar) 
      p.lokid = insert1(p.lokid, s);
    else if (s.charAt(0) == p.splitchar) {
      if (s.charAt(0) == 0)
        p.s = insertstr;
      else
        p.eqkid = insert1(p.eqkid, s.substring(1));
    } 
    else
      p.hikid = insert1(p.hikid, s);
    return p;
  }

  protected TernaryLeaf root = null;

  public void pmsearch(String s) {
    pmsearch(root, s + '\0');
  }

  private void pmsearch(TernaryLeaf p, String s) {
    if (p == null) return;
    // nodecnt++;  // uncomment to keep track of how many nodes touched
    if ((s.charAt(0) == '.') || (s.charAt(0) < p.splitchar))
      pmsearch(p.lokid, s);
    if ((s.charAt(0) == '.') || (s.charAt(0) == p.splitchar))
      if ((p.splitchar != 0) && (s.charAt(0) != 0))
        pmsearch(p.eqkid, s.substring(1));
    if ((s.charAt(0) == 0) && (p.splitchar == 0))
      System.out.println(p.s); // print it out
      //srcharr[srchtop++] = p.s;  // save it off
    if ((s.charAt(0) == '.') || (s.charAt(0) > p.splitchar))
      pmsearch(p.hikid, s);
  }

  public boolean sssearch(String s) {
    return sssearch(root, s);
  }
	/** Starting SubString Search
			Returns true if substring starts a word that exists in dictionary 
			Used in tree search pruning
	  */
	public boolean sssearch(TernaryLeaf p, String s) {
     if  (p == null) return false;
		 if (s.length() == 0) return true;  // Zero length string substr of all str.
     if (s.charAt(0) < p.splitchar)
       return sssearch(p.lokid, s);
     else if (s.charAt(0) > p.splitchar)
       return sssearch(p.hikid, s);
     else {
       if (s.length() == 1)  // the string is equal and 1 char
         return true;
       return sssearch(p.eqkid, s.substring(1)); 
     }
   }
   

   public boolean rsearch(String s) {
     return rsearch(root, s + "\0");
   }


   public boolean contains(StringBuffer s) {
     return rsearch(s.toString());
   }

   public boolean contains(String s) {
     return rsearch(root, s + "\0");
   }

   private boolean rsearch(TernaryLeaf p, String s) {
     if  (p == null) return false;
     if (s.charAt(0) < p.splitchar)
       return rsearch(p.lokid, s);
     else if (s.charAt(0) > p.splitchar)
       return rsearch(p.hikid, s);
     else {
       if (s.charAt(0) == 0)
         return true;
       return rsearch(p.eqkid, s.substring(1)); 
     }
   }

   public void nearsearch(String s, int d) {
     s = s + '\0';
     nearsearch(root, s, d);
   }

   private void nearsearch(TernaryLeaf p, String s, int d) {
     if ((p == null) || (d < 0)) return;
     if ((d > 0) || (s.charAt(0) < p.splitchar))
       nearsearch(p.lokid, s, d);
     if (p.splitchar == 0) {
       if (s.length() <= d)
         // srcharr[srchtop++] = p.s; // to store in array
         System.out.println(p.s); // to print out
     } else
       nearsearch(p.eqkid, (s.charAt(0) == 0) ? s.substring(1) : s,
         (s.charAt(0) == p.splitchar) ? d : d-1);
     if ((d > 0) || (s.charAt(0) > p.splitchar))
       nearsearch(p.hikid, s, d);
   }

   public void traverse() {
     traverse(root);
   }

   public void traverse(TernaryLeaf p) {
     if (p == null) return;
     traverse(p.lokid);
     if (p.splitchar != '\0')
       traverse(p.eqkid);
     else
       System.out.println(p.s);
     traverse(p.hikid);
   }

   public void rtraverse() {
     rtraverse(root);
   }

   private void rtraverse(TernaryLeaf p) {
		 if (p == null) return;
		 rtraverse(p.hikid);
		 if (p.splitchar != '\0')
			 rtraverse(p.eqkid);
		 else
			 System.out.println(p.s);
		 rtraverse(p.lokid);
   }

   public static void main (String argv[]) {
     TernaryTree ttb = new TernaryTree();
		 //ttb.insertstr = "abandon";
     //ttb.root = ttb.insert("abandon");
		 //ttb.insertstr = "aback";
     //ttb.root = ttb.insert("aback");
		 //ttb.insertstr = "aba&ft";
     //ttb.root = ttb.insert("aba&ft");
		 ttb.insertstr = "abandon";
     ttb.insert("abandon");
		 //ttb.insertstr = "abandoned";
     //ttb.root = ttb.insert("abandoned");
		 //ttb.insertstr = "abandoning";
     //ttb.root = ttb.insert("abandoning");
		 //ttb.insertstr = "abandonment";
     //ttb.root = ttb.insert("abandonment");
		 //ttb.insertstr = "abandons";
     //ttb.root = ttb.insert("abandons");
		 //ttb.insertstr = "abase";
     //ttb.root = ttb.insert("abase");
		 //ttb.insertstr = "abased";
     //ttb.root = ttb.insert("abased");
		 //ttb.insertstr = "abasement";
     //ttb.root = ttb.insert("abasement");
     //ttb.insert("notorious");
     //ttb.traverse();  // works!
     //ttb.rtraverse();  // works!
     //ttb.pmsearch("a.an.on");  // works!
     //ttb.nearsearch("abandom", 2);  // works!
     //System.out.println("It's there? : " + ttb.rsearch("abandon"));
     //System.out.println("It's there? : " + ttb.rsearch("abdoning"));
     System.out.println("It's there? : a" + ttb.sssearch("a"));
     System.out.println("It's there? : ab" + ttb.sssearch("ab"));
     System.out.println("It's there? : aba" + ttb.sssearch("aba"));
     System.out.println("It's there? : aban" + ttb.sssearch("aban"));
     System.out.println("It's there? : abant" + ttb.sssearch("abant"));
     System.out.println("It's there? : aband" + ttb.sssearch("aband"));
     System.out.println("It's there? : abando" + ttb.sssearch("abando"));
     System.out.println("It's there? : abandoo" + ttb.sssearch("abandoo"));
     System.out.println("It's there? : abandon" + ttb.sssearch("abandon"));
     System.out.println("It's there? : abandons" + ttb.sssearch("abandons"));
   }
}
